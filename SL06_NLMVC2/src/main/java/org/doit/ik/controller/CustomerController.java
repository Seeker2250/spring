package org.doit.ik.controller;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//공지사항과 관련된 모든 Controller method를 만드는 Controller

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	
	@Autowired
	private NoticeDao noticeDao;
	
	//http://localhost/customer/notice.htm?seq=1
	@GetMapping("/noticeDetail.htm")
	public String noticeDetail(Model model,
			@RequestParam(value = "seq") String seq) throws ClassNotFoundException, SQLException {
		  NoticeVO notice = this.noticeDao.getNotice(seq);
		  model.addAttribute("notice", notice);
		return "noticeDetail.jsp";
	}
	//[1]
	// http://localhost/customer/notice.htm?seq=1
	/*	@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//return type이 ModelAndView
			//pdf 284
			
			ModelAndView mav = new ModelAndView("noticeDetail.jsp");
			
			String seq = request.getParameter("seq");
		      
		    
		    NoticeVO notice = this.noticeDao.getNotice(seq);
		    
		    mav.addObject("notice", notice);
		    
		    
		    //mav.setViewName("notice.jsp");이렇게 안해도 ModelAndView 만들 때 넣을 수 이썽
		    
		    
			return mav;
		}*/
	
	
	
	@GetMapping("/notice.htm")
	public String notices(Model model,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "field", defaultValue = "title") String field,
			@RequestParam(value = "query", defaultValue = "") String query) throws ClassNotFoundException, SQLException {
	
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
			
		model.addAttribute("list", list);
		model.addAttribute("message", "스프링 재밌는딩?!~");
			
		return("notice.jsp");
	}
	
/*	NoticeController.java 코딩	
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
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
	}*/
	
	
}//class
