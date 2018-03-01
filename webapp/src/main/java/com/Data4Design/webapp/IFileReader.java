package com.Data4Design.webapp;
/**
 * Reads files -- implementations determine type of file.
 * @author HHCD
 *
 */
import java.util.ArrayList;

public interface IFileReader {
	
	public ArrayList<String> readFile(String filename);

}
