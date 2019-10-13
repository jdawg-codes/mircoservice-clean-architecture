package microservice.clean.architecture.service.task;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.fake.FakeEntity;
import microservice.clean.architecture.fake.FakeGateway;
import microservice.clean.architecture.fake.FakePresenter;
import microservice.clean.architecture.fake.FakeTaskRequest;
import microservice.clean.architecture.service.boundary.output.OutputBoundary;
import microservice.clean.architecture.service.boundary.request.TaskRequest;
import microservice.clean.architecture.service.entity.Entity;
import microservice.clean.architecture.service.gateway.Gateway;
import microservice.clean.architecture.service.gateway.GatewayRequest;
import microservice.clean.architecture.service.module.DefaultModule;
import microservice.clean.architecture.service.task.EntityInsertTask;
import microservice.clean.architecture.service.task.Task;

public class EntityInsertTaskTest {
	@Test
	public void taskExecutionReturnsObjectOfTypeOutputBoundary() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Entity.class, FakeEntity.class);
			module.bind(TaskRequest.class, FakeTaskRequest.class);
			module.bind(Gateway.class, FakeGateway.class);
			module.bind(OutputBoundary.class, FakePresenter.class);
			
			Task insertTask = new EntityInsertTask();
			OutputBoundary presenter = insertTask.execute(module);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			//TODO: Add some form of assert statement
			fail("Could not execute the entity manipulation task");
		}	
	}
	
	@Test
	public void taskThrowsMissingClassExceptionForMissingEntity() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Entity.class, null);
			module.bind(TaskRequest.class, FakeTaskRequest.class);
			module.bind(Gateway.class, FakeGateway.class);
			module.bind(OutputBoundary.class, FakePresenter.class);
			
			Task insertTask = new EntityInsertTask();
			OutputBoundary presenter = insertTask.execute(module);
			
			fail("Should have thrown Missing Entity Exception, but didn't");
		} catch(Exception e) {			
			Exception expectedException = new ModuleMissingConcreteClassException(Entity.class);
			
			assertEquals(e.getMessage(),expectedException.getMessage());
		}	
	}
	
	@Test
	public void taskThrowsMissingClassExceptionForMissingGatewayRequest() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Entity.class, FakeEntity.class);
			module.bind(GatewayRequest.class, null);
			module.bind(Gateway.class, FakeGateway.class);
			module.bind(OutputBoundary.class, FakePresenter.class);
			
			Task insertTask = new EntityInsertTask();
			OutputBoundary presenter = insertTask.execute(module);
			
			fail("Should have thrown Missing Gateway Request Exception, but didn't");
		} catch(Exception e) {			
			Exception expectedException = new ModuleMissingConcreteClassException(GatewayRequest.class);
			
			assertEquals(e.getMessage(),expectedException.getMessage());
		}	
	}
	
	@Test
	public void taskThrowsMissingClassExceptionForMissingGateway() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Entity.class, FakeEntity.class);
			module.bind(TaskRequest.class, FakeTaskRequest.class);
			module.bind(Gateway.class, null);
			module.bind(OutputBoundary.class, FakePresenter.class);
			
			Task insertTask = new EntityInsertTask();
			OutputBoundary presenter = insertTask.execute(module);
			
			fail("Should have thrown Missing Gateway Exception, but didn't");
		} catch(Exception e) {			
			Exception expectedException = new ModuleMissingConcreteClassException(Gateway.class);
			
			assertEquals(e.getMessage(),expectedException.getMessage());
		}	
	}
	
	@Test
	public void taskThrowsMissingClassExceptionForMissingPresenter() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Entity.class, FakeEntity.class);
			module.bind(TaskRequest.class, FakeTaskRequest.class);
			module.bind(Gateway.class, FakeGateway.class);
			module.bind(OutputBoundary.class, null);
			
			Task insertTask = new EntityInsertTask();
			OutputBoundary presenter = insertTask.execute(module);
			
			fail("Should have thrown Missing Presenter Exception, but didn't");
		} catch(Exception e) {			
			Exception expectedException = new ModuleMissingConcreteClassException(OutputBoundary.class);
			
			assertEquals(e.getMessage(),expectedException.getMessage());
		}	
	}
}
