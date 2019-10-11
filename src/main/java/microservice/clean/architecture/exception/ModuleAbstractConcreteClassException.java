package microservice.clean.architecture.exception;

public class ModuleAbstractConcreteClassException extends Exception {
	private Class<?> concreteClass;
	
	public ModuleAbstractConcreteClassException(Class<?> concreteClass) {
		this.concreteClass = concreteClass;
	}

	public String getMessage() {
		return "The concrete class " + this.concreteClass + " could not be instantiated because it is an interface or abstract class.";
	}
}
