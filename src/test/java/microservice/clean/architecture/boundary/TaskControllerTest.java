package microservice.clean.architecture.boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.fake.FakeTask;
import microservice.clean.architecture.module.DefaultModule;
import microservice.clean.architecture.task.Task;

public class TaskControllerTest {

	@Test
	public void controllerThrowsMissingConcreteClassExceptionWithNullRequest() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Task.class, null);
						
			TaskController controller = new TaskController(module);
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
			
			TaskController controller = new TaskController(module);
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
			
			TaskController controller = new TaskController(module);
			OutputBoundary presenter = controller.execute();
		} catch(Exception e) {
			//TODO: Add some form of assert statement
			fail("Could not execute the controller");
		}	
	}
}
