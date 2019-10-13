package microservice.clean.architecture.entity.attribute.validator;

import java.util.ArrayList;
import java.util.List;

import microservice.clean.architecture.entity.attribute.Attribute;
import microservice.clean.architecture.error.Error;

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
