package microservice.clean.architecture.service.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import microservice.clean.architecture.fake.FakeConfiguredEntity;
import microservice.clean.architecture.fake.FakeEntity;
import microservice.clean.architecture.service.entity.Entity;
import microservice.clean.architecture.service.entity.attribute.MoneyAttribute;
import microservice.clean.architecture.service.entity.attribute.PhoneAttribute;
import microservice.clean.architecture.service.entity.attribute.StringAttribute;

public class EntityTest {

	@Test
	public void canInstantiateEntity() {
		try {
			Entity entity = new FakeEntity();
		} catch(Exception e) {
			fail("failed to instantiate the entity");
		}
	}
	
	@Test
	public void canSetEntityAttributes() {
		try {
			Entity entity = new FakeEntity();
			entity.newAttribute("Name", new StringAttribute("Jeff"));
			entity.newAttribute("Phone", new PhoneAttribute("888-888-8888"));
			entity.newAttribute("GrossAnnualIncome", new MoneyAttribute(new BigDecimal(12235.25)));
		} catch(Exception e) {
			fail("failed to instantiate the entity and set its attributes");
		}
	}
	
	@Test
	public void entityAttributesReturnAppropriateValues() {
		Entity entity = new FakeEntity();
		entity.newAttribute("Name", new StringAttribute("Jeff"));
		entity.newAttribute("Phone", new PhoneAttribute("888-888-8888"));
		entity.newAttribute("GrossAnnualIncome", new MoneyAttribute(new BigDecimal(12235.25)));
		
		assertEquals(entity.getAttribute("Name").getValue(),"Jeff");
		assertEquals(entity.getAttribute("Phone").getValue(),"888-888-8888");
		assertEquals(entity.getAttribute("GrossAnnualIncome").getValue(),new BigDecimal(12235.25));
	}
	
	@Test
	public void configuredEntityAttributesReturnAppropriateValues() {
		Entity entity = new FakeConfiguredEntity();
		
		//values stored in the FakeConfiguredEntity configure() method
		assertEquals(entity.getAttribute("Name").getValue(),"Jeff");
		assertEquals(entity.getAttribute("Phone").getValue(),"888-888-8888");
		assertEquals(entity.getAttribute("GrossAnnualIncome").getValue(),new BigDecimal(12235.25));
		assertEquals(entity.getAttribute("FakeEntity").getValue().getClass(),new FakeEntity().getClass());
	}
}
