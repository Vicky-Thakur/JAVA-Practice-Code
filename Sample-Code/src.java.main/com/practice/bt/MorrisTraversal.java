package com.practice.bt;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class ThreadedNode{
	int value;
	ThreadedNode l;
	ThreadedNode r;
	boolean leftThreaded;
	boolean rightThreaded;
	ThreadedNode(int key){
		this.value = key;
		this.l = this.r = null;
		this.leftThreaded = false;
		this.rightThreaded = false;
	}
}
public class MorrisTraversal {

	public ThreadedNode root;

	int count;
	
	MorrisTraversal(){
		this.root=null;
		this.count=0;
	}
	public void morrisInsert(int key){
		ThreadedNode insertNode = new ThreadedNode(key);
		System.out.println("Insert node "+insertNode.value);
		if(root==null){
			System.out.println("Parent " +root);
			root=insertNode;
			return;
		}
		Queue<ThreadedNode> queue = new ArrayDeque<ThreadedNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			ThreadedNode temp = queue.poll();
			if(temp.leftThreaded || temp.l==null){
				if(temp.leftThreaded){
					insertNode.l = temp.l;
					temp.leftThreaded = false;
					temp.l = insertNode;
					insertNode.leftThreaded = true;
				}else{
					temp.l = insertNode;
				}
				//Only for Print
				System.out.print("Parent "+temp.value);
				if(temp.l!=null)
					System.out.print(" left "+temp.l.value);
				else
					System.out.print(" left null ");
				if(temp.r!=null)
					System.out.println(" right "+temp.r.value);
				else
					System.out.println(" right null ");
				//Only for Print
				insertNode.r = temp;
				insertNode.rightThreaded = true;
				count++;
				break;
			}else if(temp.rightThreaded || temp.r==null){
				if(temp.rightThreaded){
					insertNode.r = temp.r;
					temp.rightThreaded = false;
					temp.r = insertNode;
					insertNode.rightThreaded = true;
				}else{
					temp.r = insertNode;
				}
				//Only for Print
				System.out.print("Parent "+temp.value);
				if(temp.l!=null)
					System.out.print(" left "+temp.l.value);
				else
					System.out.print(" left null ");
				if(temp.r!=null)
					System.out.println(" right "+temp.r.value);
				else
					System.out.println(" right null \n");
				//Only for Print
				insertNode.l = temp;
				insertNode.leftThreaded = true;
				count++;
				break;
			}else{
				queue.add(temp.l);
				queue.add(temp.r);
			}	
		}
	}
	
	//Print threaded binary tree using stack
	public void print(){
		Stack<ThreadedNode> st = new Stack<ThreadedNode>();
		ThreadedNode temp = root;
		while(!st.isEmpty() ||temp!=null){
			if(temp!=null){
				st.push(temp);
				if(!temp.leftThreaded)
					temp = temp.l;	
				else
					temp = null;
			}else{
				temp = st.pop();
				System.out.print(temp.value+", ");
				if(!temp.rightThreaded)
					temp = temp.r;
				else
					temp = null;
			}	
		}
	}
	
	public void morrisTravesal(){
		ThreadedNode temp = root;
		//To find left most of root
		while(temp.l!=null && !temp.leftThreaded){
			temp = temp.l;
		}
		while(temp!=null){
			System.out.print(temp.value+", ");
			if(temp.rightThreaded)
				temp = temp.r;
			else{
				temp = temp.r;
				//To find left most of right sub tree
				while(temp!= null && !temp.leftThreaded){
					temp = temp.l;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MorrisTraversal mt = new MorrisTraversal();
		System.out.print("---- Morris Traversal ----\n");
		for(int i=0;i<15;i++){
			mt.morrisInsert(i);
		}
		System.out.println("\nInorder traversal of Morris tree(threaded binary tree)");
		mt.print();
		System.out.println("\n\nMorris traversal of Morris tree(threaded binary tree)");
		mt.morrisTravesal();
	}
}
