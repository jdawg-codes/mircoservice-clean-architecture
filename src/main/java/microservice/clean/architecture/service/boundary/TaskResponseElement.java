package microservice.clean.architecture.service.boundary;

public class TaskResponseElement<T> {
	private TaskResponseElement<T> taskElement;
	
	TaskResponseElement(TaskResponseElement<T> element){
		set(element);
	}

	public TaskResponseElement<T> get() {
		return taskElement;
	}

	public void set(TaskResponseElement<T> element) {
		taskElement = element;
	}
}
