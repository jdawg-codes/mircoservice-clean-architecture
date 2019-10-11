package microservice.clean.architecture.entity.attribute;

import microservice.clean.architecture.entity.Entity;
import microservice.clean.architecture.entity.attribute.validator.ValidationErrors;
import microservice.clean.architecture.gateway.GatewayRequest;

public class EntityAttribute extends Entity implements Attribute<Entity> {
	private Entity entity;
	private String name;
	
	public EntityAttribute(Entity entity) {
		this.setValue(entity);
	}
	
	@Override
	public Entity getValue() {
		return entity;
	}

	@Override
	public void setValue(Entity attribute) {
		entity = attribute;		
	}

	@Override
	public void configure() {
		entity.configure();	
	}

	@Override
	public ValidationErrors validate(GatewayRequest gatewayRequest) {
		return entity.validate(gatewayRequest);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}