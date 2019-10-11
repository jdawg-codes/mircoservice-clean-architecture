package microservice.clean.architecture.fake;

import microservice.clean.architecture.entity.Entity;
import microservice.clean.architecture.entity.attribute.validator.ValidationErrors;
import microservice.clean.architecture.gateway.GatewayRequest;

public class FakeEntity extends Entity {
	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ValidationErrors validate(GatewayRequest gatewayRequest) {
		return new FakeValidationErrors();
	}
}
