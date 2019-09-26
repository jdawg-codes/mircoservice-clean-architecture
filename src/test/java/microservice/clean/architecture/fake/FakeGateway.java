package microservice.clean.architecture.fake;

import microservice.clean.architecture.gateway.Gateway;
import microservice.clean.architecture.gateway.GatewayConnection;
import microservice.clean.architecture.gateway.GatewayRequest;
import microservice.clean.architecture.gateway.GatewayResponse;

public class FakeGateway implements Gateway {

	@Override
	public GatewayConnection connect() {
		return new FakeGatewayConnection();
	}

	@Override
	public GatewayResponse execute(GatewayRequest request) {
		return new FakeGatewayResponse();
	}

}
