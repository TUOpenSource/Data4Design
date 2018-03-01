package site;

public class TableResultService implements IResultService {

	
	public Result getResult(String country) {
		return new TableResult();
	}
}
