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
	
	//Insert in level order using BFS(recursion) 
	public void insert(int key, Queue<Node> queue){
		if(this.head!=null){
			if(queue!=null){
				Node temp = queue.poll();
				if(temp.l==null)
					temp.l = new Node(key);
				else if(temp.r==null)
					temp.r = new Node(key);
				else{
					queue.offer(temp.l);
					queue.offer(temp.r);
					insert(key, queue);
				}
			}else{
				queue =new ArrayDeque<Node>();
				queue.offer(this.head);
				insert(key,queue);
			}
		}else
			this.head = new Node(key);
	}
	
	//Insert in level order using BFS(iterative)
	public void insert(int key){
		if(this.head==null){
			this.head = new Node(key);
		}else{
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add(this.head);
			while(!queue.isEmpty()){
				Node temp = queue.poll();
				if(temp.l==null){
					temp.l = new Node(key);
					break;
				}else if(temp.r==null){
					temp.r = new Node(key);
					break;
				}else{
					queue.add(temp.l);
					queue.add(temp.r);
				}
			}
		}
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
		for(int i=1;i<15;i++){
			bt1.insert(i);
		}
		bt1.print(bt1.head);
	}
}
