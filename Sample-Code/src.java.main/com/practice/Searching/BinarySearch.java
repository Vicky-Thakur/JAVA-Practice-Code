package com.practice.Searching;

import java.util.Scanner;

public class BinarySearch {

	public int[] array; 

	BinarySearch(){
		this.array = new int[]{3,7,15,31,32,48,62};
	}

	public void binarySearch(int beg, int end, int num) {
		if(end < beg) {
			System.out.println("Number not found.");
			return ;
		}
		int mid = (beg + end)/2;
		if(this.array[mid] == num) {
			System.out.println("Number is found at " + mid);
		}else if(this.array[mid] > num) {
			this.binarySearch(beg, mid-1, num);
		}else {
			this.binarySearch(mid+1, end, num);
		}
	}

	public static void main(String[] args) {

		int num = 0;
		String choice;
		BinarySearch bs = new BinarySearch();
		Scanner scan = new Scanner(System.in);
		System.out.print("Your array ::" );
		for(int i:bs.array) {
			System.out.print(" " + i);
		}
		System.out.println();
		do {
			System.out.println("Enter Number to be search ");
			num = scan.nextInt();
	
			bs.binarySearch(0, bs.array.length-1, num);
			System.out.println("To continue press 1 :");
			scan.nextLine();
			choice = scan.nextLine();
		}while(choice.equals("1"));
		scan.close();
	}
}
