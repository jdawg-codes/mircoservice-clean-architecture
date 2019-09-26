package microservice.clean.architecture.gateway;

public interface GatewayConnection {
	public void connect();
	public void close();
}
