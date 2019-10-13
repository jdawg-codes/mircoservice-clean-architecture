package microservice.clean.architecture.service.boundary.element;

public interface TaskBoundaryElement<T> {
	public T get();
	public void set(T element);
}
