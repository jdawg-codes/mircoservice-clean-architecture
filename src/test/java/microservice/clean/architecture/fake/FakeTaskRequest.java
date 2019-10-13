package microservice.clean.architecture.fake;

import java.util.UUID;

import microservice.clean.architecture.service.boundary.TaskRequest;
import microservice.clean.architecture.service.boundary.UUIDTaskRequestElement;

public class FakeTaskRequest extends TaskRequest {
	@Override
	public void configure() {
		this.put("TransactionUUId", 
				new UUIDTaskRequestElement(UUID.fromString("f0f25e90-e838-11e9-aaef-0900500c9a66")));
		this.put("TaskUUId", 
				new UUIDTaskRequestElement(UUID.fromString("f9f24e90-e838-11e9-aaef-0800200c9a66")));
		
	}
}
