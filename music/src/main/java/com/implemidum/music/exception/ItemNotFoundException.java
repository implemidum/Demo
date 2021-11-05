package com.implemidum.music.exception;

public class ItemNotFoundException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(String itemType, Long id) {
		super("Could not find " + itemType + ": " + id);
	}
	
	public ItemNotFoundException(String itemType, String name) {
		super("Could not find " + itemType + ": " + name);
	}
}
