package microservice.clean.architecture.gateway;

public interface Gateway {	
	public GatewayConnection connect();	
	public GatewayResponse execute(GatewayConnection gatewayConnection, GatewayRequest request); 
}
