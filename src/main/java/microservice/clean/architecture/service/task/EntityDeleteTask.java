package microservice.clean.architecture.task;

import microservice.clean.architecture.boundary.OutputBoundary;
import microservice.clean.architecture.entity.Entity;
import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.gateway.Gateway;
import microservice.clean.architecture.gateway.GatewayConnection;
import microservice.clean.architecture.gateway.GatewayRequest;
import microservice.clean.architecture.gateway.GatewayResponse;
import microservice.clean.architecture.module.Module;

public class EntityDeleteTask implements Task {
	private Entity entity;
	private Gateway gateway;
	private GatewayRequest gatewayRequest;
	
	@Override
	public OutputBoundary execute(Module module) throws InstantiationException, IllegalAccessException, ModuleMissingConcreteClassException {
		//create the entity and gateway
		entity = (Entity) module.getComponent(Entity.class);
		gatewayRequest = (GatewayRequest) module.getComponent(GatewayRequest.class);
		
		GatewayResponse response = null;
		
		if(entity.validate(gatewayRequest).fatalErrors()==false) {
			//establish a connection with the gateway
			gateway = (Gateway) module.getComponent(Gateway.class);		
			GatewayConnection gatewayConnection = (GatewayConnection) gateway.connect();
			
			//execute upon the entity through the gateway
			response = gateway.execute(gatewayConnection, gatewayRequest);
			
			gatewayConnection.close();			
		} 
		
		//create presenter object and set the response
		OutputBoundary presenter = (OutputBoundary) module.getComponent(OutputBoundary.class);		
		presenter.setResponse(response);
		
		return presenter;
	}
}