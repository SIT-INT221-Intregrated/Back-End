package int221.integrated.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="integrated.storage")
public class StorageProperties {

	private String location ;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
