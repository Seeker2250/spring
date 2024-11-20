package org.doit.ik.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	
	//문자열을 Date 객체로 변환할 뿐이야~
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date hiredate;//java.util.Date
	
	private int sal;
	private int comm;
	private int deptno;
	
	//empDTO + salgradeDTO 1:1 관계( 한 사람의 급여 등급은 하나 )
	private SalgradeDTO salgradeDTO;
}
