package org.instantlogic.interaction.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageCoordinates {

	private static final Pattern coordinate = Pattern.compile("\\.?(\\w+)(\\[([\\d,\\-]*)\\])?");
	
	public static class Coordinate {
		
		private String nodeName;
		private List<String> activeInstances;

		public Coordinate(String nodeName, List<String> activeInstanceIds) {
			this.nodeName = nodeName;
			if (activeInstanceIds!=null) {
				this.activeInstances = activeInstanceIds;
			} else {
				this.activeInstances = Collections.emptyList();
			}
		}

		public String getNodeName() {
			return nodeName;
		}

		public List<String> getActiveInstances() {
			return activeInstances;
		}
		
		@Override
		public String toString() {
			if (activeInstances.size()==0) {
				return nodeName;
			}
			StringBuilder sb = new StringBuilder(nodeName);
			sb.append('[');
			boolean first = true;
			for (String activeInstance: activeInstances) {
				if (first) {
					first = false;
				} else {
					sb.append(',');
				}
				sb.append(activeInstance);
			}
			sb.append(']');
			return sb.toString();
		}
	}
	
	public static PageCoordinates parse(String in) {
		PageCoordinates result = new PageCoordinates();
		Matcher matcher = coordinate.matcher(in);
		while (matcher.find()) {
			String nodeName = matcher.group(1);
			String indices = matcher.group(3);
			List<String> activeInstances=null;
			if (indices!=null) {
				String[] split = indices.split(",");
				activeInstances = new ArrayList<String>(split.length);
				for (String item:split) {
					activeInstances.add(item);
				}
			}
			result.addCoordinate(new Coordinate(nodeName, activeInstances));
		}
		return result;
	}

	private final List<Coordinate> path = new ArrayList<Coordinate>();
	
	public String format() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Coordinate coordinate: path) {
			if (first) {
				first = false;
			} else {
				sb.append('.');
			}
			sb.append(coordinate);
		}
		return sb.toString();
	}

	public List<Coordinate> getPath() {
		return path;
	}
	
	public void addCoordinate(Coordinate coordinate) {
		path.add(coordinate);
	}
	
	public Coordinate popCoordinate() {
		return path.remove(path.size()-1);
	}
}
