import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.exception.ModuleAbstractConcreteClassException;
import microservice.clean.architecture.exception.ModuleBindingMismatchException;
import microservice.clean.architecture.fake.FakeEntity;
import microservice.clean.architecture.fake.FakeGateway;
import microservice.clean.architecture.service.entity.Entity;
import microservice.clean.architecture.service.module.DefaultModule;
import microservice.clean.architecture.service.module.Module;

public class DefaultModuleTest {

	@Test
	public void canBindAbstractClassToConcreteClass() {
		try {
			Module module = new DefaultModule();			
			module.bind(Entity.class, FakeEntity.class);			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			fail("Unable to Bind a Concrete Class to an Abstract Class");
		}		
	}
	
	@Test
	public void canGetBoundConcreteClassFromAbstractClass() {
		try {
			Module module = new DefaultModule();			
			module.bind(Entity.class, FakeEntity.class);
			
			assertEquals(module.getComponent(Entity.class).getClass(),new FakeEntity().getClass());
		}catch(Exception e) {
			fail("Unable to Get a Concrete Class from an Abstract Class");
		}		
	}
	
	@Test
	public void canBindAbstractClassToConcreteObject() {
		try {
			Module module = new DefaultModule();			
			module.bind(Entity.class, new FakeEntity());			
		} catch(Exception e) {
			fail("Unable to Bind a Concrete Class to an Abstract Class");
		}		
	}
	
	@Test
	public void canGetBoundConcreteObjectFromAbstractClass() {
		try {
			Module module = new DefaultModule();			
			module.bind(Entity.class, new FakeEntity());
			
			assertEquals(module.getComponent(Entity.class).getClass(),new FakeEntity().getClass());
		} catch(Exception e) {
			fail("Unable to Get a Concrete Object from an Abstract Class");
		}		
	}

	@Test
	public void throwsExceptionWhenMismatchBetweenAbstractAndConcreteClass() {
		try {
			Module module = new DefaultModule();			
			module.bind(Entity.class, FakeGateway.class);
		
			fail("Should throw exception showing mismatch between abstract and concrete class");
		} catch(Exception e) {			
			Exception expectedException = new ModuleBindingMismatchException(Entity.class);			
			assertEquals(e.getMessage(),expectedException.getMessage());
		}		
	}
	
	@Test
	public void throwsExceptionWhenAbstractClassProvidedAsConcreteClass() {
		try {
			Module module = new DefaultModule();			
			module.bind(Entity.class, Entity.class);
		
			fail("Should throw exception showing abstract class cannot be instantiated");
		} catch(Exception e) {			
			Exception expectedException = new ModuleAbstractConcreteClassException(Entity.class);			
			assertEquals(e.getMessage(),expectedException.getMessage());
		}		
	}
}
