package org.instantlogic.designer.dataexplorer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.text.TextTemplate;
import org.instantlogic.fabric.value.WriteableAttributeValue;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.Element;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

public class DataExplorerAddInstancePlaceTemplate extends PlaceTemplate {

  static String describeInstance(Instance instance) {
    return instance.getMetadata().getEntity().getName()+ " '"+instance.renderTitle()+"'";
  }

  public class ExecuteElement extends Element {
    
    private String id = "confirm-addinstance";
    
    @Override
    public void render(RenderContext context, List<Map<String, Object>> appendTo) {
      Map<String, Object> result = new HashMap<>();
      appendTo.add(result);
      result.put("id", id);
      result.put("type", "confirmActions");
      Instance from = context.getSelectedInstance(entity, entity.getName());
      Instance candidate = context.getSelectedInstance(null, "instance");
      if (!Entity.extendsFrom(candidate.getMetadata().getEntity(), relation.getTo())) {
        result.put("actions", "A ["+candidate.getMetadata().getEntity().getName()+"] is not a ["+relation.getTo()+"].");
        return;
      };
      StringBuffer actions = new StringBuffer();
      if (relation.isOwner()) {
        if (relation.isMultivalue()) {
          actions.append("Add a copy of "+describeInstance(candidate)+"' to "+relation.getName()+"\n");
        } else {
          Instance original = (Instance)relation.get(from).getValue();
          if (original == candidate) {
            result.put("actions", "This relation does already exist.");
            return;
          }
          if (original!=null) {
            actions.append("Delete "+describeInstance(original)+"\n");
          }
          actions.append("Set "+relation.getName()+" to a copy of "+describeInstance(candidate)+"\n");
        }
      } else {
        if (relation.isMultivalue()) {
          if (!relation.getReverseRelation().isMultivalue()) {
            actions.append("Remove " + 
                describeInstance((Instance)relation.getReverseRelation().get(candidate).getValue()) + 
                " as " + 
                relation.getReverseRelation().getName() + 
                " on " + 
                describeInstance(candidate) + 
                "\n");
          }
          actions.append("Add "+describeInstance(candidate)+"' to "+relation.getName()+" on "+describeInstance(from)+"\n");
        } else {
          Instance original = (Instance)relation.get(from).getValue();
          if (original == candidate) {
            result.put("actions", "This relation does already exist.");
            return;
          }
          if (original!=null) {
            actions.append("Remove the old value "+describeInstance(original)+" from "+relation.getName()+"\n");
          }
          actions.append("Set "+relation.getName()+" to "+ describeInstance(candidate)+"\n");
        }
      }
      result.put("actions", actions.toString());
      result.put("executable", true);
    }

    @Override
    public FlowEventOccurrence submit(SubmitContext context) {
      Instance from = context.getSelectedInstance(entity, entity.getName());
      Instance candidate = context.getSelectedInstance(null, "instance");
      if (context.getPageElementId().equals(id+"-ok")) {
        if (relation.isOwner()) {
          Instance clone = candidate.getMetadata().getEntity().createInstance();
          ((WriteableAttributeValue)relation.get(from)).setOrAdd(clone);
          clone.getMetadata().deepCopyFrom(candidate);
        } else {
          ((WriteableAttributeValue)relation.get(from)).setOrAdd(candidate);
        }
        return new FlowEventOccurrence(administration.getRelationPlaceTemplate(entity, relationId), from);
      }
      if (context.getPageElementId().equals(id+"-cancel")) {
        return new FlowEventOccurrence(administration.getExplorePlaceTemplate(), candidate);
      }
      return null;
    }

    @Override
    public void change(ChangeContext changeContext) {
    }
  }
  
	private final Entity<?> entity;
	private final String entityId;
	private final String relationId;
	private final DataExplorerAdministration administration;
	@SuppressWarnings("rawtypes")
	private Relation relation;
	private Entity<?>[] parameters;
	
	public DataExplorerAddInstancePlaceTemplate(Entity<?> entity,
			Relation<?,?,?> relation, 
			DataExplorerAdministration administration) {
		this.entity = entity;
		this.entityId = entity.getUniqueId();
		this.relation = relation;
		this.relationId = relation.getUniqueId();
		this.administration = administration;
		this.parameters = new Entity<?>[]{entity, null};
	}

	@Override
	public FragmentTemplate getRootContainer() {
    FragmentTemplate page = new FragmentTemplate(relation.getUniqueId()+"-add-to", "Page")
      .addChild("mainContent",
        new FragmentTemplate("h1", "Heading1")      
          .putText("text", new TextTemplate().getUntranslated().add((relation.isMultivalue()?"Add to relation '":"Set relation '")+ relation.getName()+"'").getTextTemplate()));
      
    page.addChild("mainContent", new ExecuteElement());
    
    return page;
	}

	@Override
	public String getId() {
		return getName();
	}
	
	@Override
	public Entity<?>[] getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return "_DataExplorer-AddToRelation-"+relationId;
	}
}
