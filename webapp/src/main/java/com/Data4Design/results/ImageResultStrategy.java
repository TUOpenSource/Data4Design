package com.Data4Design.results;

public class ImageResultStrategy implements IOutputService {

	
	
	public String GetOutput(Result result) {
		
		ImageResult image = (ImageResult)result;
		
         String ans ="";
         return ans+ image.getData().length;
		
		
	}
}
