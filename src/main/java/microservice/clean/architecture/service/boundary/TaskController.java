package microservice.clean.architecture.service.boundary;

import microservice.clean.architecture.exception.NoTaskRequestException;
import microservice.clean.architecture.service.module.Module;
import microservice.clean.architecture.service.task.Task;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;

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