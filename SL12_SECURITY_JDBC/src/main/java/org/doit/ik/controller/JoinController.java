package org.doit.ik.controller;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 공지사항과 관련된 모든 컨트롤러 메서드를 만드는 컨트롤러
@Controller
@RequestMapping("/joinus/*")
public class JoinController {
   
	@Autowired
	private MemberMapper memberDao;
	
	//로그인	/joinus/login.htm -> /joinus/login.jsp
	@GetMapping("/login.htm")
	public String login() throws Exception{
		return "joinus.login"; // view name 수정
	}//나중에 SpringSecurity사용해서 처리
	
	
	//회원가입 	/joinus/join.htm	-> /joinus/join.jsp 응답
	@GetMapping("/join.htm")
	public String join() throws Exception{
		
		
		
		return "joinus.join"; // view name 수정
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	//회원가입 	/joinus/join.htm	POST -> main으로
	@PostMapping("/join.htm")
	public String join(MemberVO member) throws Exception{
		String pwd = member.getPwd();
		member.setPwd(this.passwordEncoder.encode(pwd));//암호화해서 set(집어넣어)
		this.memberDao.insert(member);
		return "redirect:../index.htm";//상위로 올라가야 index.jsp찾지
	}
} // class
