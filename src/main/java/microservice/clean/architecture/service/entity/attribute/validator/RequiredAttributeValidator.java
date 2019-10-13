package microservice.clean.architecture.service.entity.attribute.validator;

import microservice.clean.architecture.service.entity.attribute.Attribute;

public class RequiredAttributeValidator implements AttributeValidator {

	@Override
	public boolean validate(Attribute<?> attribute) {
		if(attribute.getValue()==null) {
			return false;
		} else {
			return true;
		}
	}	
}