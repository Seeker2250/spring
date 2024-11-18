package org.doit.ik.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 페이징 기준, 척도
@Getter  
@Setter
@ToString
public class Criteria {
	private int pageNum; // 현재 페이지 번호
	private int amount;  // 한 페이지에 출력할 게시글 수
	
	private String type;    //검색조건 T C W TC TW TWC
	private String keyword; //검색어 
	
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//?pageNum2&amount=10&type=T&keyword=홍길동& 뭐시기
	//org.springframework.web.util.
	//	ㄴUriComponentsBuilder
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.type)
				.queryParam("keyword", this.keyword);
		return builder.toUriString();
	}
 // 검색조건 : 단일 항목일 땐 상관없는데 다중 항목일 땐 "TWC"같은 건 잘라서 ["T", "W", "C"] String Array로 만들거야
 public String[] getTypeArr(){
	 return this.type == null ? new String[] {} : this.type.split("");//한 문자씩 자르기
 }
}//class