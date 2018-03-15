package com.Data4Design.results;

public class TableResultStrategy implements IOutputService {

	
	public String GetOutput(Result result) {
		
		TableResult table = (TableResult)result;
		


        StringBuilder stringBuilder = new StringBuilder();


        int bound0 = table.getData().length;
        int bound1 = table.getData()[0].length;
        for (int i = 0; i <= bound0; i++)
        {
            for (int x = 0; x <= bound1; x++)
            {
                stringBuilder.append(table.getData()[i][x]);
                stringBuilder.append('\t');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
	}
	
	
}


