package org.doit.ik.domain;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeVO {
	private String seq;
	private String title;
	private String writer;
	private Date regdate;
	private String filesrc;	// fileSrc -> filesrc 첨부된 파일명만 가지고 DB에 insert하는 용도
	private int hit;
	private String content;
	
	//<input type="file" id="txtFile" name="file" />
	//자동으로 파일 업로드 될 때 그 파일 객체를 받기 위해서 input 태그의 name 속성으로 주기
	//type을 MultipartFile에 받아도 되지만 일단 명시적으로 줘보자(확장성을 고려한다면 MultipartFile로 받는 게 나음)
	private CommonsMultipartFile file;//서버로 전송된 파일을 받기 위한 것
}
