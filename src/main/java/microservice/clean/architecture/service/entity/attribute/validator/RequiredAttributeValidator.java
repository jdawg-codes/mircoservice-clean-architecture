package microservice.clean.architecture.entity.attribute.validator;

import microservice.clean.architecture.entity.attribute.Attribute;

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