package microservice.clean.architecture.service.gateway;

public interface Gateway {	
	public GatewayConnection connect();	
	public GatewayResponse execute(GatewayConnection gatewayConnection, GatewayRequest request); 
}
