package org.doit.ik.di4;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;


import org.springframework.stereotype.Component;

import lombok.Setter;
@Setter
@Component
public class RecordViewImpl4 implements RecordView4{

	@Inject
	@Named(value = "record4")
 	private RecordImpl4 record = null;
	public RecordViewImpl4() {
	}
	public RecordViewImpl4(RecordImpl4 record) {
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
