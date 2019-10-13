package microservice.clean.architecture.exception;

import microservice.clean.architecture.service.entity.attribute.Attribute;

public class AttributeValidationException extends Exception {
	private Attribute<?> attribute;
	
	public AttributeValidationException(Attribute<?> attribute) {
		this.attribute = attribute;
	}
	
	public String getMessage() {
		return "The concrete class for " + this.attribute + " could not be instantiated.";
	}
}