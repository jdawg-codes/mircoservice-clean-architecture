package microservice.clean.architecture.exception;

public class ModuleBindingMismatchException extends Exception {
	private Class<?> interfaceClass;
	
	public ModuleBindingMismatchException(Class<?> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getMessage() {
		return "The concrete class supplied in the binding is not of the expected type " + this.interfaceClass + ".";
	}
}
