package microservice.clean.architecture.service.boundary;

import java.util.UUID;

public class UUIDTaskRequestElement implements TaskRequestElement<UUID> {
	private UUID requestElement;
	
	public UUIDTaskRequestElement(UUID element) {
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
