package org.doit.ik;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;


//Ajax요청을 처리하는 컨트롤러
@RestController
public class ScottRestController {
	private static final Logger logger = LoggerFactory.getLogger(ScottRestController.class);
	
	@Setter(onMethod = @__({@Autowired}))//lombok으로 Autowired한다
	private DeptMapper  deptMapper;
	
	//json을 아무것도 안해도 DeptDTO로 받아버려
	@PostMapping("/scott/dept/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto){//String을 응답할거야 JSON도 String이니까
	
		logger.info("@@@@ScottRestController.insertDept() 호출@@@@");
		int rowCount = this.deptMapper.insertDept(dto);//1 또는 0 돌려
		
		return rowCount==1
				? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//ResponseEntity 활용하면 결과 상태값까지 전달
	}
	
	@PostMapping("/scott/dept/remove")
	public ResponseEntity<String> removeDept(@RequestBody DeptDTO dto){//String을 응답할거야 JSON도 String이니까
		
		logger.info("@@@@ScottRestController.removeDept() 호출@@@@");
		int removeCount = this.deptMapper.removeDept(dto);//1 또는 0 돌려
		
		return removeCount==1
				? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//ResponseEntity 활용하면 결과 상태값까지 전달
	}
}
