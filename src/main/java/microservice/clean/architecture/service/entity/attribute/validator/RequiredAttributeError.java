package microservice.clean.architecture.entity.attribute.validator;

import microservice.clean.architecture.entity.attribute.Attribute;
import microservice.clean.architecture.error.Error;

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
