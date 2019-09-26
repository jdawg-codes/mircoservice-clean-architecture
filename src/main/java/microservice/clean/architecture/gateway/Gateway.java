package microservice.clean.architecture.gateway;

public interface Gateway {	
	public GatewayConnection connect();	
	public GatewayResponse execute(GatewayRequest request); 
}
