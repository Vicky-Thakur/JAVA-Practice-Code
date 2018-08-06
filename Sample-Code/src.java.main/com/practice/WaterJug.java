package com.practice;

import java.util.Scanner;

public class WaterJug {
	
	public int min(int a, int b){
		if(a>b)
			return b;
		else
			return a;
	}
	
	public int gcd(int a, int b){
		if(b == 0)
			return a;
		return gcd(b,a%b);
	}
	
	public int countStep(int fromVessel, int toVessel, int limit){
		int step = 1, from = fromVessel, to =0;
		while(from != limit && to != limit){
			System.out.println("("+from+","+to+")");
			int temp = min(from,toVessel - to);
			from -= temp;
			to += temp;
			step++;
			System.out.println("("+from+","+to+")");
			if(from==limit || to == limit)
				break;
			if(from == 0){
				from = fromVessel;
				step++;
			}
			if(to == toVessel){
				to =0;
				step++;
			}
		}
		return step;
	}

	public static void main(String[] args) {
		int m,n,d;
		WaterJug obj = new WaterJug();
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		d = scan.nextInt();
		scan.close();
		System.out.println("Water Jug Problem");
		int ability = obj.gcd(m,n);
		System.out.println(" gcd is " + ability);
		if((m>n?d<m:d<n) && d%ability==0){
			System.out.println("Way 1 ===");
			int way1 = obj.countStep(m,n,d);
			System.out.println("Way 2 ===");
			int way2 = obj.countStep(n,m,d);
			int result =obj.min(way1, way2);
			System.out.print("minimum steps :: "+result);
		}else
			System.out.println("Not possible");
	}

}
