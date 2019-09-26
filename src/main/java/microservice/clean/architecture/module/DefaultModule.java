package microservice.clean.architecture.module;

import java.util.HashMap;
import java.util.Map;

import microservice.clean.architecture.exception.MissingConcreteClassException;

public class DefaultModule implements Module {
	Map<Class<?>,Object> components = new HashMap<Class<?>, Object>();
	
	@Override
	public void bind(Class<?> interfaceClass, Class<?> concreteClass) throws InstantiationException, IllegalAccessException {
		if(concreteClass != null) {
			components.put(interfaceClass, concreteClass.newInstance());
		} else {
			components.put(interfaceClass, null);
		}		
	}
	
	@Override
	public void bind(Class<?> interfaceClass, Object concreteClass) throws InstantiationException, IllegalAccessException {
		if(concreteClass != null) {
			components.put(interfaceClass, concreteClass);
		} else {
			components.put(interfaceClass, null);
		}
	}

	@Override
	public Object getComponent(Class<?> interfaceClass) throws MissingConcreteClassException {
		if(components.get(interfaceClass) == null) {		
			throw new MissingConcreteClassException(interfaceClass); 
		}
		
		return components.get(interfaceClass);
	}

	
}