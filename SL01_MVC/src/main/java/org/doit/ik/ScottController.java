package org.doit.ik;

import java.util.ArrayList;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;



@Controller
public class ScottController {
	private static final Logger logger = LoggerFactory.getLogger(ScottController.class);
		
	/* @Autowired */
	@Setter(onMethod=@__({@Autowired}))//lombok으로 Autowired한다
	private DeptMapper  deptMapper;
	
  //@RequestMapping(value = "/scott/dept", method = RequestMethod.POST) 여기서 method 지우면 GET, POST 다 돼
	@GetMapping(value = "/scott/dept")
	public String dept(Locale locale, Model model) {
		logger.info("@@@@ScottController.dept() 호출@@@@");
		
		ArrayList<DeptDTO> list = this.deptMapper.selectDept();
		model.addAttribute("list", list);
		
		
// /WEB-INF/views/		.jsp
		return "scott/dept";//ViewResolver에 의해 경로가 만들어져.
	}
	

	@Setter(onMethod=@__({@Autowired}))//lombok으로 Autowired한다
	private EmpMapper empMapper;
	
  //@RequestMapping(value = "/scott/dept", method = RequestMethod.POST) 여기서 method 지우면 GET, POST 다 돼
	@PostMapping(value = "/scott/emp")//이거 POST요청인데 GET으로 받으면 405 에러 일어나
	public String emp(Locale locale, Model model, @RequestParam(value = "deptno") int[] deptnos) {
		logger.info("@@@@ScottController.emp() 호출@@@@");
		
		ArrayList<EmpDTO> list = this.empMapper.selectEmp(deptnos);
		model.addAttribute("list", list);
		
		return "scott/emp";//ViewResolver에 의해 경로가 만들어져.
	}
	/* 예전에 하던 방식
	 	?deptno=10&deptno=20&deptno=30이렇게 넘어오겠지 GET이면...
		@PostMapping(value = "/scott/emp")//이거 POST요청인데 GET으로 받으면 405 에러 일어나
		public String emp(Locale locale, Model model, HttpServletRequest request) {
			logger.info("@@@@ScottController.emp() 호출@@@@");
		
			int[] deptnos = null;
			String [] pdeptnos = request.getParameterValues("deptno");
			deptnos = new int[pdeptnos.length];
			for (int i = 0; i < pdeptnos.length; i++) {
				deptnos[i] = Integer.parseInt(pdeptnos[i]);
			}
			
			return "scott/emp";//ViewResolver에 의해 경로가 만들어져.
		}*/
}
