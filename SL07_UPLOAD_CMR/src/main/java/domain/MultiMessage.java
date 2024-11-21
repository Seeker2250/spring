package domain;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;

@Data
public class MultiMessage {
	
	private String output;
	
	//<div><input type="file" name="attach" multiple="multiple"></div>
	//private CommonsMultipartFile [] attach;
	private List<CommonsMultipartFile> attach;
}
