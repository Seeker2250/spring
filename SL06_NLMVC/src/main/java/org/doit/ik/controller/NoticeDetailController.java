package org.doit.ik.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//공지사항 상세보기 컨트롤러
public class NoticeDetailController implements Controller {
	

	private NoticeDao noticeDao;
	
	public NoticeDetailController() {
		
	}
	//생성자 DI
	public NoticeDetailController(NoticeDao noticeDao) {
		super();		
		this.noticeDao = noticeDao;
	}

	//공지사항 목록 요청 URL
	// http://localhost/customer/notice.htm?seq=1
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//return type이 ModelAndView
		//pdf 284
		
		ModelAndView mav = new ModelAndView("noticeDetail.jsp");
		
		String seq = request.getParameter("seq");
	      
	    
	    NoticeVO notice = this.noticeDao.getNotice(seq);
	    
	    mav.addObject("notice", notice);
	    
	    
	    //mav.setViewName("notice.jsp");이렇게 안해도 ModelAndView 만들 때 넣을 수 이썽
	    
	    
		return mav;
	}
	
}
