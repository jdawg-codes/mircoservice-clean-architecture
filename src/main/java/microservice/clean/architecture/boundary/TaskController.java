package microservice.clean.architecture.boundary;

import microservice.clean.architecture.exception.NoTaskRequestException;
import microservice.clean.architecture.module.Module;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.task.Task;

public class TaskController {
	private Module module;
	private Task task;
	
	public TaskController (Module module) throws NoTaskRequestException, InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException {
		this.module = module;		
		task = (Task) this.module.getComponent(Task.class);
	}
	
	public OutputBoundary execute() throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException {
		OutputBoundary presenter = task.execute(this.module);		
		return presenter;		
	}
}