package microservice.clean.architecture.task;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.boundary.OutputBoundary;
import microservice.clean.architecture.entity.Entity;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.fake.FakeEntity;
import microservice.clean.architecture.fake.FakeGateway;
import microservice.clean.architecture.fake.FakeGatewayRequest;
import microservice.clean.architecture.fake.FakePresenter;
import microservice.clean.architecture.gateway.Gateway;
import microservice.clean.architecture.gateway.GatewayRequest;
import microservice.clean.architecture.module.DefaultModule;

public class EntityInsertTaskTest {
	@Test
	public void taskExecutionReturnsObjectOfTypeOutputBoundary() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Entity.class, FakeEntity.class);
			module.bind(GatewayRequest.class, FakeGatewayRequest.class);
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
			module.bind(GatewayRequest.class, FakeGatewayRequest.class);
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
			module.bind(GatewayRequest.class, FakeGatewayRequest.class);
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
			module.bind(GatewayRequest.class, FakeGatewayRequest.class);
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
