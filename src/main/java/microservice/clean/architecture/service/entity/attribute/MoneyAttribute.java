package microservice.clean.architecture.service.entity.attribute;

import java.math.BigDecimal;
import java.util.Currency;

public class MoneyAttribute implements Attribute<BigDecimal> {
	private BigDecimal value;
	private String name;
	
	public MoneyAttribute() {
		this.setValue(value);
	}
	
	public MoneyAttribute(BigDecimal value) {
		this.setValue(value);
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void setValue(BigDecimal value) {
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
