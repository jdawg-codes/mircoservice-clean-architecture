package microservice.clean.architecture.service.entity.attribute;

public class StringAttribute implements Attribute<String> {
	private String value;
	private String name;
	
	public StringAttribute() {
		this.setValue(value);
	}
	
	public StringAttribute(String value) {
		this.setValue(value);
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
