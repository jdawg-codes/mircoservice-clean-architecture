package microservice.clean.architecture.boundary;

import microservice.clean.architecture.gateway.GatewayResponse;

public interface OutputBoundary {
	public void setResponse(GatewayResponse response);
	public TaskResponse present();
}
