package com.Data4Design.webapp;
/**
 * Used to parse JSON files
 * @author HHCD
 *
 */
import java.util.ArrayList; // could use ArrayList
// could use package org.json.simple

public interface IJSONParsingService<T> {
	
	public T[] parseFile(String filename);
	
	public T[] parseFile(String filename, String inquiry);

}
