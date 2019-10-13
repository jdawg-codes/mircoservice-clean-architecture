package microservice.clean.architecture.service.boundary;

import java.util.HashMap;
import java.util.Map;

public abstract class TaskRequest {
	private Map<String,TaskRequestElement<?>> request  = new HashMap<String,TaskRequestElement<?>>();
	
	public void put(String elementName, TaskRequestElement element) {
		this.request.put(elementName, element);
	}
	
	public TaskRequestElement get(String elementName) {
		return this.request.get(elementName);
	}
	
	public abstract void configure();
}