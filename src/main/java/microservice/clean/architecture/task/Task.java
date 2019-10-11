package microservice.clean.architecture.task;

import microservice.clean.architecture.boundary.OutputBoundary;
import microservice.clean.architecture.boundary.TaskRequest;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.module.Module;

public interface Task {
	public OutputBoundary execute(Module module) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException;
}
