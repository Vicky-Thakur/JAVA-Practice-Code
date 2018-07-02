package com.practice;

public class ZigZagArray {
	
	public void zigzagArray(int arr[]){
		for(int i=0;i<arr.length-1;i++){
			if((i%2==0 && arr[i]>arr[i+1]) || (i%2!=0 && arr[i]<arr[i+1])){
				arr[i] +=arr[i+1];
				arr[i+1]=arr[i]-arr[i+1];
				arr[i]=arr[i]-arr[i+1];
			}
		}
		for(int i :arr)
			System.out.println(" "+i);
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{1,2,8,3,4,5};
		ZigZagArray z = new ZigZagArray();
		z.zigzagArray(arr);
	}
}
