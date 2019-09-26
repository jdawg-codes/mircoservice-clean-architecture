package microservice.clean.architecture.module;

import microservice.clean.architecture.exception.MissingConcreteClassException;

public interface Module {
	public void bind(Class<?> interfaceClass, Class<?> concreteClass) throws InstantiationException, IllegalAccessException;
	public void bind(Class<?> interfaceClass, Object concreteClass) throws InstantiationException, IllegalAccessException;
	public Object getComponent(Class<?> interfaceClass) throws InstantiationException, IllegalAccessException, MissingConcreteClassException;
}