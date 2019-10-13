package microservice.clean.architecture.service.entity.attribute;

public interface Attribute<T> {
	public String getName();
	public void setName(String name);
	public T getValue();
	public void setValue(T attribute);
}
