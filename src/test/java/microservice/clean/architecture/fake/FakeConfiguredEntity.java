package microservice.clean.architecture.fake;

import java.math.BigDecimal;

import microservice.clean.architecture.service.entity.Entity;
import microservice.clean.architecture.service.entity.attribute.EntityAttribute;
import microservice.clean.architecture.service.entity.attribute.MoneyAttribute;
import microservice.clean.architecture.service.entity.attribute.PhoneAttribute;
import microservice.clean.architecture.service.entity.attribute.StringAttribute;
import microservice.clean.architecture.error.ValidationErrors;
import microservice.clean.architecture.service.gateway.GatewayRequest;

public class FakeConfiguredEntity extends Entity {
	public FakeConfiguredEntity() {
		this.configure();
	}

	@Override
	public void configure() {
		this.newAttribute("Name", new StringAttribute("Jeff"));
		this.newAttribute("Phone", new PhoneAttribute("888-888-8888"));
		this.newAttribute("GrossAnnualIncome", new MoneyAttribute(new BigDecimal(12235.25)));
		this.newAttribute("FakeEntity", new EntityAttribute(new FakeEntity()));
	}

	@Override
	public ValidationErrors validate(GatewayRequest gatewayRequest) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
