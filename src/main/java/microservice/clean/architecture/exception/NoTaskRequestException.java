package microservice.clean.architecture.exception;

public class NoTaskRequestException extends Exception {	
	public String getMessage() {
		return "You must provide a task request model to proceed";
	}
}
