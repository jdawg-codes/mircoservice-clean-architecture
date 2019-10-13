package microservice.clean.architecture.fake;

import microservice.clean.architecture.service.gateway.Gateway;
import microservice.clean.architecture.service.gateway.GatewayConnection;
import microservice.clean.architecture.service.gateway.GatewayRequest;
import microservice.clean.architecture.service.gateway.GatewayResponse;

public class FakeGateway implements Gateway {

	@Override
	public GatewayConnection connect() {
		return new FakeGatewayConnection();
	}

	@Override
	public GatewayResponse execute(GatewayConnection gatewayConnection, GatewayRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
