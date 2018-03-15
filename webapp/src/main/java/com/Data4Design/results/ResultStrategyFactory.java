package com.Data4Design.results;

public class ResultStrategyFactory {

	 public IOutputService GetResultStrategy(Result result)
     {
         if (result instanceof TableResult)
             return new TableResultStrategy();
         if (result instanceof ImageResult)
             return new ImageResultStrategy();
         if (result instanceof NumberResult)
             return new NumberResultStrategy();
         else {
             return null;
         }
     }
}
