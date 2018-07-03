package com.practice;

public class SortArray0s1s2s {

	public void swap(int arr[], int i, int j){
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
	
	//Method 1
	//Time Complexity O(n)
	//Sort array of 0s,1s and 2s
	public void sortArray(int[] arr){
		int i=0, k=0, j=arr.length-1;
		while(k<=j){
			while(arr[i]==0)
				i++;
			while(arr[j]==2)
				j--;
			if(k<i)
				k=i;
			if(arr[k]==0){
				swap(arr, k, i);
				i++;
			}
			if(arr[k]==2){
				swap(arr, k, j);
				j--;
			}
			k++;
		}
	}
	
	//Method 2 
	//Time Complexity O(n)
	//Count number of 0s, 1s and put 0s at begining ang then put 1s then put 2s
	
	public static void main(String[] args) {
		int arr[] = new int[]{1,1,1,1,0,0,0,0};
		SortArray0s1s2s s = new SortArray0s1s2s();
		s.sortArray(arr);
		for(int i:arr)
			System.out.print(" "+i);
	}
}
