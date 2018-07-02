package com.practice;

import java.util.Scanner;

public class NumberFrequency {
	
	//Count frequency by Negative the number
	public void countFreq(int[] arr){
		for(int i=0;i<arr.length;){
			if(arr[i]>0){
				if(arr[arr[i]-1]>0){
					arr[i] = arr[arr[i]-1];
					arr[arr[i]-1]=-1;
				}
				else{
					--arr[arr[i]-1];
					arr[i] = 0;
					i++;
				}
			}else
				i++;
		}
		//print the frequencies;
		int j=1;
		for(int i:arr){
			System.out.println(j++ +"-"+Math.abs(i));
		}
	}
	
	//Count frequency by adding n 
	public void countFreq1(int[] arr){
		int n = arr.length;
		for(int i=0;i<arr.length;i++){
			arr[arr[i]%n-1]+=n;
		}
		int j=1;
		for(int i:arr){
			System.out.println(j+"-"+i/n);
			j++;
		}
	}

	public static void main(String[] args) {
		int arr[] = new int []{2,2,3,4,4,5};
		NumberFrequency n= new NumberFrequency();
		System.out.println("1.By negative approach");
		System.out.println("2.By add n approach");
		System.out.println("Please Choose an option: ");
		Scanner in = new Scanner( System.in);
		char ch = in.next().charAt(0);
		in.close();
		switch(ch){
		case '1':
			n.countFreq(arr);
			break;
		case '2':
			n.countFreq1(arr);
			break;
		default:
			System.out.println("Wrong otpion.");
		}
	}
}
