package microservice.clean.architecture.module;

import microservice.clean.architecture.exception.ModuleAbstractConcreteClassException;
import microservice.clean.architecture.exception.ModuleBindingMismatchException;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;

public interface Module {
	public void bind(Class<?> interfaceClass, Class<?> concreteClass) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException, ModuleBindingMismatchException, ModuleAbstractConcreteClassException;
	public void bind(Class<?> interfaceClass, Object concreteClass) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException, ModuleBindingMismatchException;
	public Object getComponent(Class<?> interfaceClass) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException;
}