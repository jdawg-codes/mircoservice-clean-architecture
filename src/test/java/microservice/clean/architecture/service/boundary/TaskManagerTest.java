package microservice.clean.architecture.service.boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.fake.FakeTask;
import microservice.clean.architecture.service.boundary.output.OutputBoundary;
import microservice.clean.architecture.service.boundary.TaskManager;
import microservice.clean.architecture.service.module.DefaultModule;
import microservice.clean.architecture.service.task.Task;

public class TaskManagerTest {

	@Test
	public void controllerThrowsMissingConcreteClassExceptionWithNullRequest() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Task.class, null);
						
			TaskManager controller = new TaskManager(module);
			fail("The NoTaskException was not thrown when it should have been");
		} catch(Exception e) {
			Exception expectedException = new ModuleMissingConcreteClassException(Task.class);
			
			//TODO: Change to assert equals statement
			assertEquals(e.getMessage(),expectedException.getMessage());
		}		
	}
	
	@Test
	public void canInstantiateControllerWithModule() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Task.class, FakeTask.class);
			
			TaskManager controller = new TaskManager(module);
			OutputBoundary presenter = controller.execute();
		} catch(Exception e) {
			//This test could fail for several reasons. Not clear why it fails.
			fail("Could not instantiate controller because of missing request");
		}		
	}

	@Test
	public void controllerExecutionReturnsObjectOfTypeOutputBoundary() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Task.class, FakeTask.class);
			
			TaskManager controller = new TaskManager(module);
			OutputBoundary presenter = controller.execute();
		} catch(Exception e) {
			//TODO: Add some form of assert statement
			fail("Could not execute the controller");
		}	
	}
}
