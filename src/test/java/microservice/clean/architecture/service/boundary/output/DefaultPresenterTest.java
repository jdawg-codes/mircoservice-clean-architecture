package microservice.clean.architecture.boundary;

import static org.junit.Assert.*;

import org.junit.Test;

import microservice.clean.architecture.fake.FakeGatewayResponse;
import microservice.clean.architecture.fake.FakePresenter;
import microservice.clean.architecture.service.boundary.OutputBoundary;
import microservice.clean.architecture.service.boundary.TaskResponse;
import microservice.clean.architecture.service.gateway.GatewayResponse;

public class PresenterTest {

	@Test
	public void canSetGatewayResponse() {
		try {
			GatewayResponse response = new FakeGatewayResponse();
			
			OutputBoundary presenter = new FakePresenter();
			presenter.setResponse(response);
		} catch(Exception e) {
			fail("Could not set the GatewayResponse");
		}
	}
	
	@Test
	public void canPresentWithGatewayResponse() {
		try {
			GatewayResponse response = new FakeGatewayResponse();
		
			OutputBoundary presenter = new FakePresenter();
			presenter.setResponse(response);
			TaskResponse presenterResponse = presenter.present();
		} catch(Exception e) {
			fail("Could not present the Task Response Object");
		}
	}
}
