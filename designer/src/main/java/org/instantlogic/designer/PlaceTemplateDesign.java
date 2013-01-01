package org.instantlogic.designer;


public class PlaceTemplateDesign extends AbstractPlaceTemplateDesign {

	public PlaceTemplateDesign() {}
	
	public PlaceTemplateDesign(String name) {
		setName(name);
	}
	
	public void init() {
	}
	
    public PlaceTemplateDesign setOwner(org.instantlogic.designer.FlowDesign newValue) {
    	super.setOwner(newValue);
    	return this;
    }
    
    public void lookUpTypes() {
    	ElementDesign element = getContent();
    	lookUpTypes(element);
    }

	private void lookUpTypes(ElementDesign element) {
		if (element instanceof FragmentTemplateDesign) {
			FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign)element;
			if (fragmentTemplate.getType()==null && fragmentTemplate.getFragmentTypeName()!=null) {
				fragmentTemplate.setType(findType(fragmentTemplate.getFragmentTypeName()));
			}
			for (PropertyDesign property: fragmentTemplate.getProperties()) {
				for(ElementDesign child : property.getChildren()) {
					lookUpTypes(child);
				}
			}
		} else if (element instanceof SelectionDesign) {
			SelectionDesign selection = (SelectionDesign)element;
			for(ElementDesign child : selection.getChildren()) {
				lookUpTypes(child);
			}
		} else if (element instanceof IfElseDesign) {
			IfElseDesign ifElse = (IfElseDesign)element;
			for(ElementDesign child : ifElse.getIfChildren()) {
				lookUpTypes(child);
			}
			for(ElementDesign child : ifElse.getElseChildren()) {
				lookUpTypes(child);
			}
		} // SharedElements are not yet needed...
	}

	private FragmentTypeDesign findType(String name) {
		for (FragmentTypeDesign type : getOwner().getApplication().getFragmentTypes()) {
			if (type.getName().equals(name)) return type;
		}
		throw new RuntimeException("Unknown type: "+name);
	}
}
