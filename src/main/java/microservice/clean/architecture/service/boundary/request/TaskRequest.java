package microservice.clean.architecture.service.boundary.request;

import java.util.HashMap;
import java.util.Map;

import microservice.clean.architecture.service.boundary.element.TaskBoundaryElement;

public abstract class TaskRequest {
	private Map<String,TaskBoundaryElement<?>> request  = new HashMap<String,TaskBoundaryElement<?>>();
	
	public void put(String elementName, TaskBoundaryElement<?> element) {
		this.request.put(elementName, element);
	}
	
	public TaskBoundaryElement<?> get(String elementName) {
		return this.request.get(elementName);
	}
	
	public abstract void configure();
}