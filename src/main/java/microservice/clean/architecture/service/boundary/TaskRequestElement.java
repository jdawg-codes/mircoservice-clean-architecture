package microservice.clean.architecture.boundary;

public interface TaskRequestElement<T> {
	public T get();
	public void set(T element);
}
