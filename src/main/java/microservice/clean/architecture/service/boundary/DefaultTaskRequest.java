package microservice.clean.architecture.boundary;

import java.util.UUID;

public class DefaultTaskRequest extends TaskRequest {
		
	@Override
	public void configure() {
		this.put("TaskUUId", new UUIDTaskRequestElement(UUID.randomUUID()));
		
	}	
}
