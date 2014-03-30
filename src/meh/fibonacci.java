package meh;

import java.util.Scanner;

public class fibonacci {
		static long m1=0;
		static long m2=1;
	
		public static long myfib (long n){
			long temp=1;
			if (n<2) return temp;
			else while(n>1){
				temp=m1+m2;
				m1=m2;
				m2=temp;
				n--;
			}
			m1=0;
			m2=1;
			return temp;
		}
		public static long fib(long n){
			if (n<2) return 1;
			else {
				n=fib(n-1)+fib(n-2);
				return n;
			}
		}
		
		public static void  main(String[] args){
			System.out.print("enter n ");
			long n;
			Scanner cin=new Scanner(System.in);
			n=cin.nextInt();
			long startTime = System.nanoTime();
			System.out.print("fib "+n+" is "+myfib(n));
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println(" total time"+totalTime);
			
		}
		
		
		
}
