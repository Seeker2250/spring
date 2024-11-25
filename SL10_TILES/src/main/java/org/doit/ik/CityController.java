package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
@RequestMapping("/city/*")
public class CityController {
	@GetMapping("/london")
		public String london() {
			log.info("CityController london에는 들어온거야~~ Get으루");
			//return "/WEB-INF/views/city/london.jsp"; 이거였는데
			//return "asdfnaemaumdaero";//그냥 내 마음대로 tiles 이름 줘
			return "city/london.tiles";//tiles view resolver 사용
		}
	@GetMapping("/paris")
	public String paris() {
		log.info("CityController paris에는 들어온거야~~ Get으루");
		//return "/WEB-INF/views/city/london.jsp"; 이거였는데
		//return "asdfnaemaumdaero";//그냥 내 마음대로 tiles 이름 줘
		return "city/paris.tiles";//tiles view resolver 사용
	}
	@GetMapping("/seoul")
	public String seoul() {
		log.info("CityController seoul에는 들어온거야~~ Get으루");
		//return "/WEB-INF/views/city/london.jsp"; 이거였는데
		//return "asdfnaemaumdaero";//그냥 내 마음대로 tiles 이름 줘
		return "city/seoul.tiles";//tiles view resolver 사용
	}
	
	
	
}//class
