package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.doit.ik.mapper.DeptEmpSalgradeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor//이게 Autowired 대신이야~ 생성자에 의해 주입!
@Controller
@Log4j
public class DeptEmpMybatisController {
	
//	private static final Logger logger = LoggerFactory.getLogger(DeptEmpMybatisController.class);

//	@Autowired
	private DeptEmpSalgradeMapper deptEmpSalgradeMapper;

	@GetMapping(value = "/dept/emp")
	public void DeptEmpSalgrade(Model model) {
		log.info("@@@@DeptEmpMybatisController에 왔다네~!~!@@@@");
		model.addAttribute("list", this.deptEmpSalgradeMapper.getDeptEmpInfo());
		
		
	}
	
}
