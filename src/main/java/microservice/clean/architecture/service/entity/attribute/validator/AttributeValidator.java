package microservice.clean.architecture.service.entity.attribute.validator;

import microservice.clean.architecture.service.entity.attribute.Attribute;

public interface AttributeValidator {
	public boolean validate(Attribute<?> attribute);
}
