package microservice.clean.architecture.service.boundary.request;

import java.util.UUID;

import microservice.clean.architecture.service.boundary.element.UUIDTaskBoundaryElement;

public class DefaultTaskRequest extends TaskRequest {
		
	@Override
	public void configure() {
		this.put("TaskUUId", new UUIDTaskBoundaryElement(UUID.randomUUID()));
		
	}	
}
