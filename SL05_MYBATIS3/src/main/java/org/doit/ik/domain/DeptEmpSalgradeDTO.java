package org.doit.ik.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias(value = "DeptEmpSalgradeDTO")
public class DeptEmpSalgradeDTO {
	
	//1:1 관계 ( 1개의 부서에 1개)
	private DeptDTO deptDTO;
	
	//1:N 관계 (1개 부서에 여러 사람)
	private EmpDTO empDTO;//List<EmpDTO> empList
	
	
}
