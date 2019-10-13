package microservice.clean.architecture.boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.service.boundary.DefaultTaskRequest;
import microservice.clean.architecture.service.boundary.TaskRequest;

public class DefaultTaskRequestTest {

	@Test
	public void canInstantiateDefaultTaskRequest() {
		try {
			TaskRequest request = new DefaultTaskRequest();
		} catch(Exception e) {
			fail("Not yet implemented");
		}
	}

}
