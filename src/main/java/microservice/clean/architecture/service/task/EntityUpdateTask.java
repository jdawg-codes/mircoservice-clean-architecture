package microservice.clean.architecture.service.task;

import microservice.clean.architecture.exception.ModuleMissingConcreteClassException;
import microservice.clean.architecture.service.boundary.output.OutputBoundary;
import microservice.clean.architecture.service.entity.Entity;
import microservice.clean.architecture.service.gateway.Gateway;
import microservice.clean.architecture.service.gateway.GatewayConnection;
import microservice.clean.architecture.service.gateway.GatewayRequest;
import microservice.clean.architecture.service.gateway.GatewayResponse;
import microservice.clean.architecture.service.module.Module;

public class EntityUpdateTask implements Task {
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