package microservice.clean.architecture.service.boundary.response;

import java.util.Map;

import microservice.clean.architecture.service.boundary.element.TaskBoundaryElement;

public abstract class TaskResponse {
	private Map<String,TaskBoundaryElement<?>> response;
	
	public void put(String elementName, TaskBoundaryElement<?> element) {
		this.response.put(elementName, element);
	}
	
	public TaskBoundaryElement<?> get(String elementName) {
		return this.response.get(elementName);
	}
}
