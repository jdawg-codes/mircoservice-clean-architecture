package microservice.clean.architecture.exception;

public class ModuleMissingConcreteClassException extends Exception {
	private Class<?> interfaceClass;
	
	public ModuleMissingConcreteClassException(Class<?> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getMessage() {
		return "The concrete class for " + this.interfaceClass + " could not be instantiated.";
	}
}
