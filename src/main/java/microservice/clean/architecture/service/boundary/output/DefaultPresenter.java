package microservice.clean.architecture.service.boundary.output;

import microservice.clean.architecture.service.boundary.response.TaskResponse;
import microservice.clean.architecture.service.gateway.GatewayResponse;

public class DefaultPresenter implements OutputBoundary {
	GatewayResponse gatewayResponse;
	
	@Override
	public void setResponse(GatewayResponse response) {
		this.gatewayResponse = response;
	}

	@Override
	public TaskResponse present() {		
		return null;
	}
}