package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/list")
	public void list(Model model) {
		log.info("@@@BoardController.list()호출@@@");
		
		model.addAttribute("list", this.boardService.getList());
		
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
    public String modify(BoardVO boardVO, RedirectAttributes rttr) {
       log.info("~~ BoardController.modify() POST방식~~");
       
       if (this.boardService.modify(boardVO)) {
		rttr.addFlashAttribute("result", "SUCCESS");
       }
       
       return String.format("redirect:/board/get?bno=%d", boardVO.getBno());
    }
	
	@GetMapping(value = {"/get", "/modify"})//이럴 때 return 없는 게 유용해 바로 파라미터 별 url로 넘어가니까
    public void get(@RequestParam("bno") Long bno, Model model) {
       log.info("~~ BoardController.get()~~");
       model.addAttribute("boardVO", this.boardService.get(bno));
    }
	
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
