package microservice.clean.architecture.service.entity.attribute.validator;

import java.util.ArrayList;
import java.util.List;

import microservice.clean.architecture.error.Error;
import microservice.clean.architecture.service.entity.attribute.Attribute;

public class ValidationErrors {
	private int fatalErrorCount=0;
	private List<Error<Attribute<?>>> errors = new ArrayList<Error<Attribute<?>>>();
	
	public void add(Error<Attribute<?>> error) {
		errors.add(error);
	}
	
	public boolean fatalErrors() {
		errors.forEach(error -> {
			if(error.isFatal()==true) {
				fatalErrorCount += 1;
			}
		});
		
		if(fatalErrorCount<=0) {
			return false; 
		} 

		return true;
	}
}
