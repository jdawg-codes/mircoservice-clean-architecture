package microservice.clean.architecture.boundary;

import microservice.clean.architecture.gateway.GatewayResponse;

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