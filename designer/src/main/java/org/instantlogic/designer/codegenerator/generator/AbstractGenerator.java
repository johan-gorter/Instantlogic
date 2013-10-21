package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.instantlogic.designer.Design;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public abstract class AbstractGenerator<CM extends AbstractClassModel> {

	protected ObservationsOutdatedObserver observations;
	
	/**
	 * Used to keep track of the last rootPackageName, name and isCustomized
	 */
	private CM lastClassModel;

	public abstract CM generate(GeneratedClassModels context);

	private boolean equals(String s1, String s2) {
		if (s1==null) return s2==null;
		return (s1.equals(s2));
	}
	
	public final void update(GeneratedClassModels context) {
		CM newClassModel = generate(context);
		if (newClassModel == null) return;
		if (lastClassModel!=null && !lastClassModel.isDeleted) {
			if (!equals(lastClassModel.technicalNameCapitalized, newClassModel.technicalNameCapitalized)
					|| !equals(lastClassModel.rootPackageName, newClassModel.rootPackageName)
					|| (lastClassModel.isCustomized != newClassModel.isCustomized) || newClassModel.isDeleted) {
				delete(context);
			}
		}
		if (lastClassModel==null || !newClassModel.isDeleted) {
			queueClassModel(newClassModel, context);
			lastClassModel = newClassModel;
		}
	}
	
	public abstract void queueClassModel(CM classModel, GeneratedClassModels context);
	
	public final void delete(GeneratedClassModels context) {
		if (lastClassModel!=null && !lastClassModel.isDeleted) {
			try {
				@SuppressWarnings("unchecked")
				CM clone = (CM)lastClassModel.clone();
				clone.isDeleted = true;
				queueClassModel(clone, context);
				lastClassModel = clone;
			} catch (CloneNotSupportedException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	protected <G extends AbstractGenerator> List<Design> updateGenerators(Map<String, G> generators, Iterable<? extends Design> from, GeneratedClassModels context) {
		List<Design> newDesigns = new ArrayList<Design>();
		for(Design instance: from) {
			AbstractGenerator generator = generators.get(instance.getName());
			if (generator!=null) {
				generator.update(context);
			} else {
				newDesigns.add(instance);
			}
		}
		Iterator<Map.Entry<String, G>> i = generators.entrySet().iterator();
		nextEntry: while (i.hasNext()) {
			Entry<String, G> entry = i.next();
			for (Design instance : from) {
				if (entry.getKey().equals(instance.getName())) {
					continue nextEntry;
				}
			}
			entry.getValue().delete(context);
			i.remove();
		}
		return newDesigns;
	}
	
	protected void updateAll(Collection<? extends AbstractGenerator> generators, GeneratedClassModels context) {
		for (AbstractGenerator generator: generators) {
			generator.update(context);
		}
	}

	protected String javaSafeName(String name) {
		if ("package".equals(name) || "default".equals(name)) {
			return "_"+name;
		}
		return name;
	}
}
