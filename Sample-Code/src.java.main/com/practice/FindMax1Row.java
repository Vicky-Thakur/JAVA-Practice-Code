package com.practice;

//Row wise Sorted matrix having only 0s, 1s
//Find Row having maximum number of 1s
//Git fetch Test1
public class FindMax1Row {

	public int findRow(int matrix[][]){
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0,0,1,1},{0,0,0,0},{0,1,1,1},{0,0,0,1}};
		FindMax1Row f = new FindMax1Row();
		int result = f.findRow(matrix);
		System.out.println("Row having max no of 1s " + result);
	}

}
