package microservice.clean.architecture.service.boundary.element;

import java.util.UUID;

public class UUIDTaskBoundaryElement implements TaskBoundaryElement<UUID> {
	private UUID requestElement;
	
	public UUIDTaskBoundaryElement(UUID element) {
		this.set(element);
	}
	
	@Override
	public UUID get() {
		return this.requestElement;
	}

	@Override
	public void set(UUID element) {
		this.requestElement = element;
	}

}
