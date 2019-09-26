package microservice.clean.architecture.fake;

import microservice.clean.architecture.boundary.OutputBoundary;
import microservice.clean.architecture.boundary.TaskResponse;
import microservice.clean.architecture.gateway.GatewayResponse;

public class FakePresenter implements OutputBoundary {

	@Override
	public TaskResponse present() {
		TaskResponse presenter = new FakeTaskResponse();		
		return presenter;
	}

	@Override
	public void setResponse(GatewayResponse response) {
		// TODO Auto-generated method stub
		
	}
	
}
