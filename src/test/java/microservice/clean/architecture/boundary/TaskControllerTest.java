package microservice.clean.architecture.boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.exception.MissingConcreteClassException;
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
		} catch(Exception e) {
			Exception expectedException = new MissingConcreteClassException(Task.class);
			
			System.out.println(e.getMessage() + " = " + expectedException.getMessage());
			
			//TODO: Change to assert equals statement
			if(!e.getMessage().equals(expectedException.getMessage())) {
				fail("The NoTaskException was not thrown when it should have been");
			}			
		}		
	}
	
	@Test
	public void canInstantiateControllerWithTaskAndRequestModel() {
		try {
			//set up module with fake task
			DefaultModule module = new DefaultModule();
			module.bind(Task.class, FakeTask.class);
			
			TaskController controller = new TaskController(module);
		} catch(Exception e) {
			//TODO: Add some form of assert statement
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
