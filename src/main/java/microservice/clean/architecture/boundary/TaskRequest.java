package microservice.clean.architecture.boundary;

import java.util.Map;

public abstract class TaskRequest {
	private Map<String,TaskRequestElement> request;
	
	public void put(String elementName, TaskRequestElement element) {
		this.request.put(elementName, element);
	}
	
	public TaskRequestElement get(String elementName) {
		return this.request.get(elementName);
	}
}
