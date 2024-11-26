package org.doit.ik.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

//403 접근 금지 에러를 직접 개발자가 처리하는 class(객체)
@Log4j
@Component//이름 등록 안했으니 class명의 소문자로 등록될 것
public class CustomAccessDeniedHandler implements AccessDeniedHandler{@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.error("ACcess Denied Handler 입장~");
		log.error("redirect 시킬거야");
		//개발자가 이것저것 처리하기
		//그 후에 아래로 보내버려~
		response.sendRedirect("/common/accessError.htm");
		
	}
	
	
}
