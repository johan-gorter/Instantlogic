

package org.instantlogic.fabric.util;


public interface ValueChangeObserver {
	
	/**
	 * Listener interface for value changes
	 * 
	 * @param event The event that changed a value.
	 */
	public void valueChanged(ValueChangeEvent event);
	
}
