package microservice.clean.architecture.exception;

public class MissingConcreteClassException extends Exception {
	private Class<?> interfaceClass;
	
	public MissingConcreteClassException(Class<?> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getMessage() {
		return "The concrete class for " + this.interfaceClass + " could not be instantiated.";
	}
}
