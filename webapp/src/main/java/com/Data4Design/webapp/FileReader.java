package com.Data4Design.webapp;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReader implements IFileReader{
	
	
	public FileReader() {
		
	}
	
	@Override
	public ArrayList<String> readFile(String filename) {
		String name = "";
		ArrayList<String> newList = new ArrayList<String>();
		try {
			File inFile = new File(filename);
			Scanner scan = new Scanner(inFile); 
			while(scan.hasNextLine()) {
				 name = scan.nextLine();
				 newList.add(name);
			
			}
			scan.close();
		}
		catch (IOException e) {
			
		}
		catch(Exception e) {
			
		}
		return newList;
	}
}
