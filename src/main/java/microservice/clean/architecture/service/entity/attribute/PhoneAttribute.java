package microservice.clean.architecture.entity.attribute;

public class PhoneAttribute implements Attribute<String> {
	private String value;
	private String name;
	
	public PhoneAttribute() {
		this.setValue(value);
	}
	
	public PhoneAttribute(String value) {
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
