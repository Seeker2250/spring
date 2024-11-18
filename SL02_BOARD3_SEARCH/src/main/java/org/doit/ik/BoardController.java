package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
@AllArgsConstructor
public class BoardController {
	
	//private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//위는 Log4j annotation으로 대체되었다
	
	
	//@Autowired
	private BoardService boardService;
	
	/*@GetMapping("/board/list")
	public String list(Model model) {
		log.info("@@@BoardController.list()호출@@@");
		model.addAttribute("list", this.boardService.getList());
		
		return "/board/list";
	}*/
	
	
	//2번
	//(페이징 처리가 안된 controller method)
	/*@GetMapping("/list")
	public void list(Model model) {
		log.info("@@@BoardController.list()호출@@@");
		
		model.addAttribute("list", this.boardService.getList());
		
		//return "/board/list"; 요청한 url이랑 같은 경우(GetMapping에 명시된 것과 같은 경우)에 return 생략가능
	}*/
	
	@GetMapping("/list")//페이징 처리
	//http://localhos/board/list였는데
	//http://localhos/board/list?pageNum=3&amount=10
	public void list(Model model, Criteria criteria) {
		log.info("@@@BoardController.list()호출@@@");
		
		model.addAttribute("list", this.boardService.getListWithPaging(criteria));
		
		//paging block 1 2 [3] 4 5 6 7 8 9 10 >
		int total = this.boardService.getTotal(criteria);
		//필요없는데 넣어둔 이유 : 검색 조건 등등 추가하려고 검색했을 때 레코드 수 달라지면 반영하기 위해
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
		
		//return "/board/list"; 요청한 url이랑 같은 경우(GetMapping에 명시된 것과 같은 경우)에 return 생략가능
	}
	
	/*3번
	@GetMapping("/board/list")
	public ModelAndView list(ModelAndView mav) {
		log.info("@@@BoardController.list()호출@@@");
		
		mav.addObject("list", this.boardService.getList());
		mav.setViewName("/board/list");
		
		//ModelAndView에는 돌려보낼 객체와 경로가 모두 명시되어 있으니 똑같아
		return mav;
	}
	*/
	
	//<a href="/board/register"> 글쓰기</a>	 
	@GetMapping("/register")
	public void register() {
		log.info("@@@BoardController.register()호출@@@");
	}
	
	//<button type="submit">Submit</button>
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {//파라미터 커맨드 객체로 자동 저장(파라미터 갯수만큼, 첨부파일도)
		log.info("@@@BoardController.register() post로 호출@@@");//return으로 경로 주면 forwarding이야 그럼 안돼 redirect여야지 jsp에서는 return에 null 주고 redirect했었지
		
		this.boardService.register(board);//실행하고 난 후에도 글 번호를 계속 가지고 있는거야
		rttr.addFlashAttribute("result", board.getBno());//새로고침해도 값이 없어
		return "redirect:/board/list";//url이 redirect 붙여서 나가면 redirect돼
		//이렇게 글 번호를 안가져 간다면
		//return "redirect:/board/list?bno=2"; 이렇게 하든지
		//return "redirect:/board/list/2"; 이렇게 하든지 뭐 그런 방법들 있겠지
	}

	/* <a href="/board/get?bno=${board.bno}"> */
	
	@PostMapping(value = {"/modify"})//이럴 때 return 없는 게 유용해 바로 파라미터 별 url로 넘어가니까
    public String modify(BoardVO boardVO, RedirectAttributes rttr, @ModelAttribute("criteria") Criteria criteria) {
       log.info("~~ BoardController.modify() POST방식~~");
       
       if (this.boardService.modify(boardVO)) {
		rttr.addFlashAttribute("result", "SUCCESS");
       }
       //@ModelAttribute("criteria") Criteria criteria로 담는다고 해도 redirect 되면 초기화 되니까 안 넘어가
       //rttr.addAttribute("pageNum", criteria.getPageNum());
       
		/*
		 * rttr.addAttribute("pageNum", criteria.getPageNum());
		 * rttr.addAttribute("amount", criteria.getAmount()); rttr.addAttribute("type",
		 * criteria.getType()); rttr.addAttribute("keyword", criteria.getKeyword());
		 */
       String params = criteria.getListLink();
       //System.out.println("params 확인 디버깅~~~~@@@@@"+params);
       //params 확인 디버깅~~~~@@@@@?pageNum=3&amount=10&type=T&keyword=%EC%9E%90%EB%B0%94
       
       //rttr.addFlashAttribute("pageNum", criteria.getPageNum());
       //rttr.addFlashAttribute("amount", criteria.getAmount());//이러면 redirect할 때 parameter 값 달고 가
       
       //return String.format("redirect:/board/get?bno=%d", boardVO.getBno());
       return String.format("redirect:/board/get%s&bno=%d", params, boardVO.getBno());
       //return String.format("redirect:/board/get?bno=%d&pageNum=%d&amount=%d", boardVO.getBno(), criteria.getPageNum(), criteria.getAmount());
    }
	
	
	//3번
	//http://localhost/board/get?pageNum=5&amount=10&bno=133라고 하면 pageNum, amount도 넣어
	@GetMapping(value = {"/get", "/modify"})//이럴 때 return 없는 게 유용해 바로 파라미터 별 url로 넘어가니까
    public void get(@RequestParam("bno") Long bno, Model model, Criteria criteria) { //@ModelAttribute("criteria") Criteria criteria
//		Criteria criteria
       log.info("~~ BoardController.get()~~");
       model.addAttribute("boardVO", this.boardService.get(bno));
       model.addAttribute("criteria", criteria);
    }
	/*
	//http://localhost/board/get?pageNum=5&amount=10&bno=133라고 하면 pageNum, amount도 넣어
	@GetMapping(value = {"/get", "/modify"})//이럴 때 return 없는 게 유용해 바로 파라미터 별 url로 넘어가니까
    public void get(@RequestParam("bno") Long bno, Model model, Criteria criteria) {
       log.info("~~ BoardController.get()~~");
       model.addAttribute("boardVO", this.boardService.get(bno));
       model.addAttribute("criteria", criteria);
    }*/
	
	/*
	@GetMapping(value = {"/get/{bno}"})//return 없으니 뿌리는 곳도 get.jsp여야 해
	public String get (@PathVariable("bno") Long bno, Model model){
		log.info("@@@BoardController.get() 호출@@@");
		model.addAttribute("boardVO", this.boardService.get(bno));
		return "/board/get";
	}*/
	@GetMapping(value = {"/delete"})//이럴 때 return 없는 게 유용해 바로 파라미터 별 url로 넘어가니까
    public String delete(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
       log.info("~~ BoardController.delete()~~");
       if(this.boardService.delete(bno)) {
    	   rttr.addFlashAttribute("result", "SUCCESS");
       }
       return "redirect:/board/list";
    }
	

	
	
}//class
