package org.doit.ik.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//공지사항과 관련된 모든 Controller method를 만드는 Controller
//밑에서부터 위로 추가
@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private NoticeDao noticeDao;
	
	
	//<a class="btn-del button" href="noticeDel.htm?seq=${notice.seq}">삭제</a>
	@GetMapping("noticeDel.htm")
	public String noticeDel(@RequestParam(value = "seq") String seq) throws ClassNotFoundException, SQLException {
		  int rowCount = this.noticeDao.delete(seq);
	      if(rowCount ==1 ) {//삭제 성공 -> 글 목록
	    	  return "redirect:notice.htm";
	      }else {//삭제 실패 -> 글 상세
	    	  return "redirect:noticeDetail.htm?seq="+seq+"&error";//dispatcher servlet에서 redirect:라는 접두사 있는지 판단해
	      }
	}
	
	
	//<form action="" method="post">
	//<input type="submit" value="수정" class="btn-save button"/>
	@PostMapping("noticeEdit.htm")
	public String noticeEdit(NoticeVO notice) throws ClassNotFoundException, SQLException {
		
		int rowCount = this.noticeDao.update(notice);
		
		//model.addAttribute("notice",  this.noticeDao.getNotice(seq));
		if(rowCount == 1) {//글쓰기 성공하면
			
			return "redirect:noticeDetail.htm?seq="+notice.getSeq();//dispatcher servlet에서 redirect:라는 접두사 있는지 판단해
		}else {//글쓰기 실패
			
			return "redirect:notice.htm";
		}//if-else
		
	}
	
	//<a class="btn-edit button" href="noticeEdit.htm?seq=${notice.seq}">수정</a>요청
	@GetMapping("noticeEdit.htm")
	public String noticeEdit(Model model, @RequestParam(value = "seq") String seq) throws ClassNotFoundException, SQLException {
		
		
		NoticeVO notice = this.noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);
		//model.addAttribute("notice",  this.noticeDao.getNotice(seq));
		
		return "noticeEdit.jsp";
	}
	
	
	//<input class="btn-save button" type="submit" value="저장" />
	// 위 버튼 누르면
	//<form action="" method="post">
	// 위가 활성화 되니 자기자긴(http://localhost/customer/noticeReg.htm로 post 요청 일어날 것)
	@PostMapping(value = "/noticeReg.htm")
	public String noticeReg( NoticeVO notice) throws ClassNotFoundException, SQLException{//커맨드 객체
		//getter, setter있고 jsp의 파라미터 name 속성, VO의 field 이름은 같아야 해
		int rowCount = this.noticeDao.insert(notice);
		if(rowCount == 1) {//글쓰기 성공하면
			//리다이렉트가 맞지(url이 바뀌어야지 noticeReg.htm이 아니라 notice.htm이어야 하니까)
			return "redirect:notice.htm";//dispatcher servlet에서 redirect:라는 접두사 있는지 판단해
		}else {//글쓰기 실패
			//글쓰기 페이지로 forwarding
			return "noticeReg.htm";
		}//if-else
		
	}
	/*
	 스프링에서 이럴 필요 없어 
	@PostMapping(value = "/noticeReg.htm")
	public String noticeReg( @RequestParam(value = "title") String title,  @RequestParam(value = "content") String content){
		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setContent(content);
		return "noticeReg.jsp";
	}*/

	
	
	//<a class="btn-write button" href="noticeReg.htm">글쓰기</a>클릭하면...
	//a태그니까 get방식 요청이 될거야
	@GetMapping("/noticeReg.htm")
	public String noticeReg(HttpSession httpSession){
			 
		//spring security로 인증 및 보안 처리할 예정
			return "noticeReg.jsp";
		}
	
	
	
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
