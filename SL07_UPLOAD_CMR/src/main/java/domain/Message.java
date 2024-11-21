package domain;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
public class Message {
	
	private String output;
	
	//<div><input type="file" name="attach"></div>
	private CommonsMultipartFile attach;
}
