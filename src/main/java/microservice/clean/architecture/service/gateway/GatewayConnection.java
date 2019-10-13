package microservice.clean.architecture.service.gateway;

public interface GatewayConnection {
	public void connect();
	public void close();
}
