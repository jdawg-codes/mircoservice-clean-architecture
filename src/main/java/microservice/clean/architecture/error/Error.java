package microservice.clean.architecture.error;

public interface Error<T> {
	public String getErrorCode();
	public String getErrorMessage();
	public boolean isFatal();
}
