package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
@Setter
public class RecordViewImpl3 implements RecordView3{

	//@Setter어쩌고 lombok annotation
	/* @Autowired(required = false) */
	/* @Autowired */
	//@Resource(name = "record1") jdk 9 이상에선 못 써 어떤 bean 객체 쓸 지 명시할 수 있던 거
	@Inject
	@Named(value = "record1")
	private RecordImpl3 record = null;
	public RecordViewImpl3() {
	}
	public RecordViewImpl3(RecordImpl3 record) {
		this.record = record;
	}

	@Override
	public void input() {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("kor eng mat 입력");
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mat = sc.nextInt();
			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//input

	@Override
	public void output() {
		System.out.println(
				"kor는"+this.record.getKor()
				+"eng는"+this.record.getEng()
				+"math는"+this.record.getMat()
				+"total은"+this.record.total()
				+"avg는"+this.record.avg());
	}//output

}//class
