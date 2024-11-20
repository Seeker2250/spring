package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//이 Class 자체가 하나의 handler
//mapping 해주는 코딩이 없어! 그래서 servlet-context 갈거야
@org.springframework.stereotype.Controller(value = "/customer/notice.htm")
//공지사항 목록 컨트롤러
public class NoticeController implements Controller {
	

	private NoticeDao noticeDao;
	
	public NoticeController() {
		
	}
	//생성자 DI
	public NoticeController(NoticeDao noticeDao) {
		super();		
		this.noticeDao = noticeDao;
	}

	//공지사항 목록 요청 URL
	// http://localhost/customer/notice.htm?page=2&field=검색조건&query=검색어 라는 url 요청하자
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//return type이 ModelAndView
		//pdf 284
		
		ModelAndView mav = new ModelAndView();
		
		String ppage = request.getParameter("page");
	    String pfield = request.getParameter("field");
	    String pquery = request.getParameter("query");
	      
	    int page = 1;
	    String field = "title";
	    String query = "";
	      
	    if( ppage != null && !ppage.equals("") ) page = Integer.parseInt(ppage);
	    if( pfield != null && !pfield.equals("") ) field = pfield;
	    if( pquery != null && !pquery.equals("") ) query = pquery;
		
	    List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
	    
	    mav.addObject("list", list);
	    mav.addObject("message", "제발 되어라아아");
	    
	    mav.setViewName("notice.jsp");
	    
	    
		return mav;
	}
	
}
