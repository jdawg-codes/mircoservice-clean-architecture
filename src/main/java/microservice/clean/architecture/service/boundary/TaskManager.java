package microservice.clean.architecture.service.boundary;

import microservice.clean.architecture.exception.NoTaskRequestException;
import microservice.clean.architecture.service.boundary.output.OutputBoundary;
import microservice.clean.architecture.service.module.Module;
import microservice.clean.architecture.service.task.Task;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;

public class TaskManager {
	private Module module;
	private Task task;
	
	public TaskManager (Module module) throws NoTaskRequestException, InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException {
		this.module = module;		
		task = (Task) this.module.getComponent(Task.class);
	}
	
	public OutputBoundary execute() throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException {
		OutputBoundary presenter = task.execute(this.module);		
		return presenter;		
	}
}