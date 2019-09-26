package microservice.clean.architecture.task;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.boundary.OutputBoundary;
import microservice.clean.architecture.boundary.TaskController;
import microservice.clean.architecture.entity.Entity;
import microservice.clean.architecture.fake.FakeEntity;
import microservice.clean.architecture.fake.FakeGateway;
import microservice.clean.architecture.fake.FakeGatewayRequest;
import microservice.clean.architecture.fake.FakePresenter;
import microservice.clean.architecture.gateway.Gateway;
import microservice.clean.architecture.gateway.GatewayRequest;
import microservice.clean.architecture.module.DefaultModule;

public class EntityManipulationTaskTest {
	@Test
	public void taskExecutionReturnsObjectOfTypeOutputBoundary() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Task.class, EntityManipulationTask.class);
			module.bind(Entity.class, FakeEntity.class);
			module.bind(GatewayRequest.class, FakeGatewayRequest.class);
			module.bind(Gateway.class, FakeGateway.class);
			module.bind(OutputBoundary.class, FakePresenter.class);
			
			//TODO: remove task controller from the test and test only the task
			TaskController controller = new TaskController(module);
			OutputBoundary presenter = controller.execute();
		} catch(Exception e) {
			//TODO: Add some form of assert statement
			fail("Could not execute the entity manipulation task");
		}	
	}
}
