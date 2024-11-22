package org.doit.ik.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {
	private String id;		// uid->id
	private String pwd;
	private String name;
	private String gender;
	private String birth;
	private String is_lunar; // isLunar->is_lunar
	private String cphone;   // cPhone->cphone
	private String email;
	private String habit;
	private Date regdate;    // regDate->regdate
	
}
