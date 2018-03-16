package com.Data4Design.results;


public class OutputService implements IOutputService{

	IResultStrategyFactory iResultStrategyFactory;
	
	public OutputService(IResultStrategyFactory iResultStrategyFactory) {
		this.iResultStrategyFactory = iResultStrategyFactory;
	}
	
	public String GetOutput(Result result) {
		return iResultStrategyFactory.GetResultStrategy(result).GetOutput(result);
	}
	
}