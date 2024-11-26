package org.doit.ik.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.doit.ik.domain.MemberVO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/common/*")
public class CommonController {
	
	@GetMapping("/accessError.htm")
	public String accessDenied(Model model
	         , Authentication auth) throws Exception{ 
	      log.info("> /common/accessError.htm... GET");
	      model.addAttribute("msg", "접근 금지됐당");
	      
	      // /WEB-INF/views/common/accessError.jsp
	      return "/common/accessError"; //이게 tiles.xml에 없기 때문에 jsp파일로 가겠지 servlet.xml에 그렇게 해놨으니까
	   }
} // class
