package com.practice.bt;

import java.util.Stack;

public class TreeTraversalIterative {
	
	public void inorder(Node temp){
		if(temp==null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(temp);
		while(!stack.isEmpty()){
			if(temp!=null){
				stack.push(temp);
				temp = temp.l;
			}else{
				temp = stack.pop();
				System.out.println(temp.value + ",");
				temp = temp.r;
			}
		}
	}
	
	public void preorder(Node temp){
		
	}

	public void postorder(Node temp){
		
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		for(int i=1;i<15;i++){
			bt.insert(i);
		}
		System.out.println("Your inserted tree is :");
		TreeTraversalIterative ttI = new TreeTraversalIterative();
		System.out.println("Iterative Inorder traversal of tree is :");
		ttI.inorder(bt.root);
		System.out.println("Iterative Preorder traversal of tree is :");
		ttI.preorder(bt.root);
		System.out.println("Iterative Postorder traversal of tree is :");
		ttI.postorder(bt.root);
	}

}
