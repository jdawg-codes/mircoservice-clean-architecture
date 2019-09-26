package microservice.clean.architecture.task;

import microservice.clean.architecture.boundary.OutputBoundary;
import microservice.clean.architecture.entity.Entity;
import microservice.clean.architecture.exception.MissingConcreteClassException;
import microservice.clean.architecture.gateway.Gateway;
import microservice.clean.architecture.gateway.GatewayConnection;
import microservice.clean.architecture.gateway.GatewayRequest;
import microservice.clean.architecture.gateway.GatewayResponse;
import microservice.clean.architecture.module.Module;

public class EntityManipulationTask implements Task {
	private Entity entity;
	private Gateway gateway;
	private GatewayRequest entityRequest;
	
	@Override
	public OutputBoundary execute(Module module) throws InstantiationException, IllegalAccessException, MissingConcreteClassException {
		//create the entity and gateway
		entity = (Entity) module.getComponent(Entity.class);
		entityRequest = (GatewayRequest) module.getComponent(GatewayRequest.class);
		
		entity.validateRequest(entityRequest);
		
		//establish a connection with the gateway
		gateway = (Gateway) module.getComponent(Gateway.class);		
		GatewayConnection gatewayConnection = (GatewayConnection) gateway.connect();
		
		//execute upon entity through the gateway
		GatewayResponse response = gateway.execute(entityRequest);
		
		gatewayConnection.close();
		
		//create presenter object and set the response
		OutputBoundary presenter = (OutputBoundary) module.getComponent(OutputBoundary.class);		
		presenter.setResponse(response);
		
		return presenter;
	}
}