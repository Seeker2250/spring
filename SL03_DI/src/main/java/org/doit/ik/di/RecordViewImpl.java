package org.doit.ik.di;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
@Setter
public class RecordViewImpl implements RecordView{

	private RecordImpl record = null;
	public RecordViewImpl() {
	}
	public RecordViewImpl(RecordImpl record) {
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
