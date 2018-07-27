package com.practice.bt;

import java.util.Scanner;

public class ArrayImplOfTree {

	public Integer treeArr[];
	public int MAXNODE;
	
	ArrayImplOfTree(int maxNode){
		this.MAXNODE = maxNode;
		this.treeArr = new Integer[maxNode];
	}
	
	public int searchKey(int key){
		for(int i=0;i<this.MAXNODE;i++){
			if(this.treeArr[i]==key)
				return i;
		}
		return -1;
	}
	
	public void rootInsert(int value){
		if(this.treeArr[0]!=null){
			System.out.print("Root already filled.");
			return;
		}
		treeArr[0] = value;
	} 
	
	public void leftInsert(int key,int value){
		int keyIndex = searchKey(key);
		if(keyIndex>=0){
			int insertIndex = keyIndex * 2 + 1;
			if(insertIndex < this.MAXNODE)
				this.treeArr[insertIndex] = value;
			else
				System.out.print("No more value can be inserted in tree");
		}else
			System.out.print("key not found");
	}
	
	public void rightInsert(int key,int value){
		int keyIndex = searchKey(key);
		if(keyIndex>=0){
			int insertIndex = keyIndex * 2 + 2;
			if(insertIndex < this.MAXNODE)
				this.treeArr[insertIndex] = value;
			else
				System.out.print("No more value can be inserted in tree");
		}else
			System.out.print("key not found");
	}
	
	public void printTree(){
		System.out.print("\nYour tree array is ");
		for(Integer value:this.treeArr)
			System.out.print(" "+value);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of nodes in tree");
		int treeLength = scan.nextInt();
		scan.close();
		ArrayImplOfTree obj = new ArrayImplOfTree(treeLength);
		obj.rootInsert(9);
		obj.leftInsert(9, 5);
		obj.rightInsert(9, 11);
		obj.printTree();
		obj.leftInsert(5, 4);
		obj.rightInsert(5, 8);
		obj.printTree();
	}

}
