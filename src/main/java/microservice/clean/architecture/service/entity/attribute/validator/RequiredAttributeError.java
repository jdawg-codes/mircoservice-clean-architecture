package microservice.clean.architecture.service.entity.attribute.validator;

import microservice.clean.architecture.error.Error;
import microservice.clean.architecture.service.entity.attribute.Attribute;

public class RequiredAttributeError implements Error<Attribute<?>> {
	private Attribute<?> errorObject;
	
	public RequiredAttributeError(Attribute<?> object) {
		errorObject = object;
	}
	
	@Override
	public String getErrorCode() {
		return "100000";
	}
	
	@Override
	public String getErrorMessage() {
		return "The attribute " + errorObject.getName() + " is required and cannot be null";
	}

	@Override
	public boolean isFatal() {
		return true;
	}

	
}
