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
	
	MorrisTraversal(){
		this.root=null;
	}
	public void morrisInsert(int key){
		if(root==null){
			root=new ThreadedNode(key);
			return;
		}
		ThreadedNode insertNode = new ThreadedNode(key);
		Queue<ThreadedNode> queue = new ArrayDeque<ThreadedNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			ThreadedNode temp = queue.poll();
			if(temp.leftThreaded || temp.l==null){
				if(temp.leftThreaded){
					insertNode.l = temp.l;
					temp.l = insertNode;
				}else{
					temp.l = insertNode;
				}
				insertNode.r = temp;
				insertNode.rightThreaded = true;
				break;
			}else if(temp.rightThreaded || temp.r==null){
				if(temp.rightThreaded){
					insertNode.r = temp.r;
					temp.r = insertNode;
				}else{
					temp.r = insertNode;
				}
				insertNode.l = temp;
				insertNode.leftThreaded = true;
				break;
			}else{
				queue.add(temp.l);
				queue.add(temp.r);
			}	
		}
	}
	
	public void print(){
		Stack<ThreadedNode> st = new Stack<ThreadedNode>();
		st.push(root);
		ThreadedNode temp = null;
		ThreadedNode temp1 = null;
		while(!st.isEmpty()){
			temp = st.pop();
			if(!st.isEmpty())
				temp1 = st.pop();
			if(temp.l==null || (temp1!=null && temp1.l == temp)){
				System.out.print(temp.value+", ");
				if(temp.r!=null)
					st.push(temp.r);
			}else{
				st.push(temp);
				st.push(temp.l);
			}
		}
	}
	
	public static void main(String[] args) {
		MorrisTraversal mt = new MorrisTraversal();
		System.out.print("heool");
		for(int i=0;i<15;i++){
			mt.morrisInsert(i);
		}
		mt.print();
	}
}
