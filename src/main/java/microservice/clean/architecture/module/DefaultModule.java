package microservice.clean.architecture.module;

import java.util.HashMap;
import java.util.Map;

import microservice.clean.architecture.exception.ModuleAbstractConcreteClassException;
import microservice.clean.architecture.exception.ModuleBindingMismatchException;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;

public class DefaultModule implements Module {
	Map<Class<?>,Object> components = new HashMap<Class<?>, Object>();
	
	@Override
	public void bind(Class<?> interfaceClass, Class<?> concreteClass) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException, ModuleBindingMismatchException, ModuleAbstractConcreteClassException {
		try {
			if(concreteClass != null) {					
				if(!interfaceClass.isInstance(concreteClass.newInstance())) {
					throw new ModuleBindingMismatchException(interfaceClass); 
				}
				
				components.put(interfaceClass, concreteClass.newInstance());
			} else {
				throw new ModuleMissingConcreteClassException(interfaceClass);
			}
		} catch(InstantiationException e) {
			throw new ModuleAbstractConcreteClassException(concreteClass);
		}
	}
	
	@Override
	public void bind(Class<?> interfaceClass, Object concreteClass) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException, ModuleBindingMismatchException {
		if(concreteClass != null) {
			if(!interfaceClass.isInstance(concreteClass)) {
				throw new ModuleBindingMismatchException(interfaceClass); 
			}
			
			components.put(interfaceClass, concreteClass);
		} else {
			throw new ModuleMissingConcreteClassException(interfaceClass);
		}
	}

	@Override
	public Object getComponent(Class<?> interfaceClass) throws ModuleMissingConcreteClassException {
		if(components.get(interfaceClass) == null) {		
			throw new ModuleMissingConcreteClassException(interfaceClass); 
		}
		
		return components.get(interfaceClass);
	}	
}