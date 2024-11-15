package org.doit.ik;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;

// Ajax 요청을 처리하는 컨트롤러
@RestController
public class ScottRestController {
   
   private static final Logger logger = LoggerFactory.getLogger(ScottRestController.class);
   
   @Setter(onMethod=@__({@Autowired}))
   private DeptMapper deptMapper;
   
   // json -> DeptDTO 로 바로 받을 수 있다.
   @PostMapping(value = "/scott/dept/new")
   // ResponseEntity : 성공, 실패와 응답 상태값을 준다. / 네트워크에서 확인
   public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto){
      logger.info("scottRestController.insertDept()");
      
      int rowCount = this.deptMapper.insertDept(dto);
      
      return rowCount == 1 
            ? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   /* 내가 만든 remove함수에 따른 controller method
    * @PostMapping("/scott/dept/remove") public ResponseEntity<String>
    * removeDept(@RequestBody DeptDTO dto){//String을 응답할거야 JSON도 String이니까
    * 
    * logger.info("@@@@ScottRestController.removeDept() 호출@@@@"); int removeCount =
    * this.deptMapper.removeDept(dto);//1 또는 0 돌려
    * 
    * return removeCount==1 ? new ResponseEntity<>("SUCCESS", HttpStatus.OK) : new
    * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//ResponseEntity 활용하면 결과
    * 상태값까지 전달 }
    */

   	/* 1차 쌤
   	 * scott/dept/delete?deptno=50 이런 식으로 넘어올거야
	 * @GetMapping("/scott/dept/delete") public ResponseEntity<String>
	 * deleteDept(@RequestParam ("deptno")){//사실 RequestParam없어도 알아서 int로 parse돼
	 * //@RequestBody쓴 이유 : JSON형태로 날아오는 거 지가 알아서 변환되게 하려고
	 * logger.info("@@@@ScottRestController.deleteDept() 호출@@@@"); //int deptno =
	 * Integer.parseInt(request.getParameter("deptno")); 이렇게 하고 HttpServletRequest
	 * request로 parameter 줘도 되지만 아냐아냐 int rowCount =
	 * this.deptMapper.deleteDept(deptno); return rowCount==1 ? new
	 * ResponseEntity<>("SUCCESS", HttpStatus.OK) : new
	 * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//ResponseEntity 활용하면 결과
	 * 상태값까지 전달 }
	 */


   
//	  2차 쌤
	  @DeleteMapping(value = "/scott/dept/{deptno}")
	  public ResponseEntity<String> removeDept(@PathVariable("deptno") int deptno ){
	  logger.info("@@@@scottRestController.deleteDept()요청@@@@");
	  
	  int rowCount = this.deptMapper.deleteDept(deptno);
	  
	  return rowCount == 1 ? new ResponseEntity<>("SUCCESS", HttpStatus.OK) : new
	  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	 
   
} // class
