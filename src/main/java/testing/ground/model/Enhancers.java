package testing.ground.model;

import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;

@Component
public class Enhancers {
	public boolean validateURL(String url){
		return GenericValidator.isUrl(url);
	}
	
	public String removeProtocol(String url){
		if(url.contains("http://")){
			url = url.substring(6);
		}else if(url.contains("https://")){
			url = url.substring(7);
		}
		
		return url;
	}
}
