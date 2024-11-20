package org.doit.ik.domain;

import java.util.Date;

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
	private String filesrc;	// fileSrc -> filesrc
	private int hit;
	private String content;
}
