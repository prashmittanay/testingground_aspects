package testing.ground.model;

import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Component;

@Component
public class Enhancers {
	public boolean validateURL(String url){
		return GenericValidator.isUrl(url);
	}
}
