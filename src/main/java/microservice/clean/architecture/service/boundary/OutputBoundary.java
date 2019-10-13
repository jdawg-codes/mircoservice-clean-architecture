package microservice.clean.architecture.service.boundary;

import microservice.clean.architecture.service.gateway.GatewayResponse;

public interface OutputBoundary {
	public void setResponse(GatewayResponse response);
	public TaskResponse present();
}
