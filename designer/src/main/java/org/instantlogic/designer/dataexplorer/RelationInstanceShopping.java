package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Relation;

@SuppressWarnings("rawtypes")
public class RelationInstanceShopping {
	
	public static class TravelerExtension {
		private final List<RelationInstanceShopping> currentlyShoppingFor = new ArrayList<RelationInstanceShopping>();

		public List<RelationInstanceShopping> getCurrentlyShoppingFor() {
			return currentlyShoppingFor;
		}
	}
	
	private final Relation relation;
	
	private final Instance instance;

	public RelationInstanceShopping(Relation relation, Instance instance) {
		this.relation = relation;
		this.instance = instance;
	}

	public Relation getRelation() {
		return relation;
	}

	public Instance getInstance() {
		return instance;
	}
}
