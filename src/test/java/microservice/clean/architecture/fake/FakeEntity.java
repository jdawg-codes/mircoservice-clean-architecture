package microservice.clean.architecture.fake;

import microservice.clean.architecture.service.entity.Entity;
import microservice.clean.architecture.service.entity.attribute.validator.ValidationErrors;
import microservice.clean.architecture.service.gateway.GatewayRequest;

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
