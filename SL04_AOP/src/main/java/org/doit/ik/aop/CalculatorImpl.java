package org.doit.ik.aop;

public class CalculatorImpl implements Calculator {
//204-253 aop
	@Override
	public int add(int x, int y) {
		
		long start = System.nanoTime();//1970.01.01부터의 ns, cross-cutting concern
		int result = x + y;	//core concern
		long end =System.nanoTime();//cross-cutting concern
		System.out.printf("덧셈 처리 시간 : %d ns\n", (end - start));
		
		return result;
	}

	@Override
	public int sub(int x, int y) {
		long start = System.nanoTime();//1970.01.01부터의 ns, cross-cutting concern
		int result = x - y;	//core concern
		long end =System.nanoTime();//cross-cutting concern
		System.out.printf("뺄셈 처리 시간 : %d ns\n", (end - start));
		return result;
	}

	@Override
	public int mult(int x, int y) {
		long start = System.nanoTime();//1970.01.01부터의 ns, cross-cutting concern
		int result = x * y;	//core concern
		long end =System.nanoTime();//cross-cutting concern
		System.out.printf("곱셈 처리 시간 : %d ns\n", (end - start));
		
		return result;
	}

	@Override
	public int div(int x, int y) {
		long start = System.nanoTime();//1970.01.01부터의 ns, cross-cutting concern
		int result = x / y;	//core concern
		long end =System.nanoTime();//cross-cutting concern
		System.out.printf("나눗셈 처리 시간 : %d ns\n", (end - start));
		
		return result;
	}
	
}// class
