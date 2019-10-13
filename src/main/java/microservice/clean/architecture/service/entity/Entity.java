package microservice.clean.architecture.entity;

import java.util.HashMap;
import java.util.Map;

import microservice.clean.architecture.entity.attribute.Attribute;
import microservice.clean.architecture.entity.attribute.validator.ValidationErrors;
import microservice.clean.architecture.gateway.GatewayRequest;

public abstract class Entity {
	protected String entityName;
	protected Map<String,Attribute<?>> map = new HashMap<String,Attribute<?>>();
	
	public String entityName() {
		return this.entityName;
	}
	
	public <T> void newAttribute(String name, Attribute<T> attribute) {
		map.put(name, attribute);		
	}
	
	public  Attribute<?> getAttribute(String name) {
		return map.get(name);
	}
	
	public Map<String, Attribute<?>> getAttributes() {
		return map;
	}
	
	public abstract void configure();

	public abstract ValidationErrors validate(GatewayRequest gatewayRequest);
}