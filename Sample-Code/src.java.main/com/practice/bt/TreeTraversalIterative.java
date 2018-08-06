package com.practice.bt;

import java.util.Stack;

public class TreeTraversalIterative {
	
	public void inorder(Node temp){
		/*if(temp==null)  no need because while condition will handle this
			return;*/
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || temp!=null){
			if(temp!=null){
				stack.push(temp);
				temp = temp.l;
			}else{
				temp = stack.pop();
				System.out.print(temp.value + ",");
				temp = temp.r;
			}
		}
	}
	
	public void preorder(Node temp){
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || temp!=null){
			if(temp!=null){
				System.out.print(temp.value+",");
				if(temp.r!=null)
					stack.push(temp.r);
				temp = temp.l;
			}else{
				temp = stack.pop();
			}
		}
	}

	public void postorder(Node temp){
		/*if(temp==null)  no need because while condition will handle this
			return;*/
		Stack<Node> stack = new Stack<Node>();
		//first time stack is empty So temp!=null condition is required otherwise not required
		while(!stack.isEmpty() || temp!=null){
			if(temp!=null){
				//push temp as well as right also
				if(temp.r!=null)
					stack.push(temp.r);
				stack.push(temp);
				temp=temp.l;
			}else{
				temp = stack.pop();
				Node peek = stack.isEmpty() ? null : stack.peek();
				//if current node's right is same as next to stack top(stack.peek()).
				//	then current node's right is not traversed yet
				if(temp.r!=null && temp.r==peek){
					stack.pop();
					stack.push(temp);
					temp = temp.r;
				}else{ //else current node's right is either traversed or null
					System.out.print(temp.value+",");
					temp = null;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		for(int i=1;i<9;i++){
			bt.insert(i);
		}
		TreeTraversalIterative ttI = new TreeTraversalIterative();
		System.out.println("Iterative Inorder traversal of tree is :");
		ttI.inorder(bt.root);
		System.out.println("\nIterative Preorder traversal of tree is :");
		ttI.preorder(bt.root);
		System.out.println("\nIterative Postorder traversal of tree is :");
		ttI.postorder(bt.root);
	}

}
