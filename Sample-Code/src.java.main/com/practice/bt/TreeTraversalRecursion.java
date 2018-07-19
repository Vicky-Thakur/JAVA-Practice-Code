package com.practice.bt;

public class TreeTraversalRecursion {
	
	public Node root;
	
	public void inorderRec(Node temp){
		if(temp==null)
			return;
		inorderRec(temp.l);
		System.out.print(temp.value + ",");
		inorderRec(temp.r);
	}
	
	public void preorderRec(Node temp){
		if(temp==null)
			return;
		System.out.print(temp.value + ",");
		preorderRec(temp.l);
		preorderRec(temp.r);
	}
	
	public void postorderRec(Node temp){
		if(temp==null)
			return;
		postorderRec(temp.l);
		postorderRec(temp.r);
		System.out.print(temp.value + ",");
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		for(int i=1;i<15;i++){
			bt.insert(i);
		}
		TreeTraversalRecursion tTR = new TreeTraversalRecursion();
		System.out.println("your Binary tree is ");
		bt.print(bt.root);
		System.out.println("\nInorder Traversal");
		tTR.inorderRec(bt.root);
		System.out.println("\nPreorder Traversal");
		tTR.preorderRec(bt.root);
		System.out.println("\nPostorder Traversal");
		tTR.postorderRec(bt.root);
	}

}
