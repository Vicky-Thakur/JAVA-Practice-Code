package com.practice.bt;

import java.util.ArrayDeque;
import java.util.Queue;

class Node{
	int value;
	Node l,r;
	Node(int value){
		this.value = value;
		this.l = this.r = null;
	}
}

public class BinaryTree {

	public Node head;
	public BinaryTree() {
		this.head = null;
	}
	
	public void insert(int insertValue, Queue<Node> queue){
		if(this.head!=null){
			if(queue!=null){
				Node temp = queue.poll();
				if(temp.l==null)
					temp.l = new Node(insertValue);
				else if(temp.r==null)
					temp.r = new Node(insertValue);
				else{
					queue.offer(temp.l);
					queue.offer(temp.r);
					insert(insertValue, queue);
				}
			}else{
				queue =new ArrayDeque<Node>();
				queue.offer(this.head);
				insert(insertValue,queue);
			}
		}else
			this.head = new Node(insertValue);
	}
	
	public void print(Node temp){
		if(temp==null)
			return;
		else{
			System.out.print(temp.value);
			print(temp.l);
			print(temp.r);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		for(int i=1;i<51;i++){
			bt1.insert(i,null);
		}
		bt1.print(bt1.head);
	}
}
