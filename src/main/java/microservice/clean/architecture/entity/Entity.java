package microservice.clean.architecture.entity;

import microservice.clean.architecture.gateway.GatewayRequest;

public interface Entity {

	public void validateRequest(GatewayRequest entityRequest);
	
}
