package microservice.clean.architecture.boundary;

import java.util.Map;

public abstract class TaskResponse {
	private Map<String,TaskResponseElement> response;
	
	public void put(String elementName, TaskResponseElement element) {
		this.response.put(elementName, element);
	}
	
	public TaskResponseElement get(String elementName) {
		return this.response.get(elementName);
	}
}
