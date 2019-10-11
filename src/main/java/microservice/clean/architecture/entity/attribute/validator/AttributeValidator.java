package microservice.clean.architecture.entity.attribute.validator;

import microservice.clean.architecture.entity.attribute.Attribute;

public interface AttributeValidator {
	public boolean validate(Attribute<?> attribute);
}
