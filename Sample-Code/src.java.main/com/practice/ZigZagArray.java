package com.practice;

public class ZigZagArray {
	
	public void zigzagArray(int arr[]){
		for(int i=1;i<arr.length;i=i+2){
			if(arr[i-1]>arr[i]){
				arr[i] +=arr[i-1];
				arr[i-1]=arr[i]-arr[i-1];
				arr[i]=arr[i]-arr[i-1];
			}
			if(arr[i]<arr[i+1]){
				arr[i] +=arr[i+1];
				arr[i+1]=arr[i]-arr[i+1];
				arr[i]=arr[i]-arr[i+1];
			}
		}
		for(int i :arr)
			System.out.println(" "+i);
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{2,1,3,3,4,5};
		ZigZagArray z = new ZigZagArray();
		z.zigzagArray(arr);
	}

}
