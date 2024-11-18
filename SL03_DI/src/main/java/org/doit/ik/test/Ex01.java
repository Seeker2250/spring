package org.doit.ik.test;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;

public class Ex01 {
	public static void main(String[] args) {
		RecordImpl record = new RecordImpl();
		//1번) 생성자 의존성 주입(DI)
		//RecordImpl rvi = new RecordImpl(record);
		
		//2번) Setter를 통한 의존성 주입
		RecordViewImpl rvi = new RecordViewImpl(record);
		rvi.setRecord(record);
		rvi.input();
		rvi.output();
		
		System.out.println("END!!!");
	}
}
