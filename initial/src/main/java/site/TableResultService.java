package site;

public class TableResultService implements IResultService {

	
	public Result getResult() {
		return new TableResult();
	}

	public int getId() {
		return 5;
	}

	
}
