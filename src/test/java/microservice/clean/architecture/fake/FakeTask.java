package microservice.clean.architecture.fake;

import microservice.clean.architecture.service.boundary.OutputBoundary;
import microservice.clean.architecture.service.boundary.TaskRequest;
import microservice.clean.architecture.service.module.Module;
import microservice.clean.architecture.service.task.Task;

public class FakeTask implements Task {
	@Override
	public OutputBoundary execute(Module module) {
		// TODO Auto-generated method stub
		return null;
	}

}
