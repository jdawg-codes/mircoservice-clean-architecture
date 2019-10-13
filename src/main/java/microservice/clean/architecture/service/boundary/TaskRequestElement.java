package microservice.clean.architecture.service.boundary;

public interface TaskRequestElement<T> {
	public T get();
	public void set(T element);
}
