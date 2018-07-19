package com.practice.bt;
//
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Node{
	int value;
	Node l,r;
	Node(int value){
		this.value = value;
		this.l = this.r = null;
	}
}

public class BinaryTree {

	public Node root;
	public BinaryTree() {
		this.root = null;
	}
	
	//Insert in level order using BFS(recursion) 
	public void insert(int key, Queue<Node> queue){
		if(this.root!=null){
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
				queue.offer(this.root);
				insert(key,queue);
			}
		}else
			this.root = new Node(key);
	}
	
	//Insert in level order using BFS(iterative)
	public void insert(int key){
		if(this.root==null){
			this.root = new Node(key);
		}else{
			Queue<Node> queue = new ArrayDeque<Node>();
			queue.add(this.root);
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
	
	//delete node 
	public void delete(int key){
		Queue<Node> queue = new ArrayDeque<Node>();
		Node temp = null, keyNode = null;
		queue.add(root);
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp.value == key)
				keyNode = temp;
			if(temp.l!=null)
				queue.add(temp.l);
			if(temp.r!=null)
				queue.add(temp.r);
		}
		if(keyNode!=null){
			keyNode.value = temp.value;
			Node temp1 = null;
			queue.add(root);
			while(!queue.isEmpty()){
				temp1 = queue.poll();
				if(temp1.l!=null){
					if(temp1.l==temp){
						temp1.l=null;
						return;
					}else
						queue.add(temp1.l);
				}
				if(temp1.r!=null){
					if(temp1.r==temp){
						temp1.r = null;
						return;
					}else
						queue.add(temp1.r);
				}
			}
		}
		else{
			System.out.print("Key not found");
			return;
		}
	}
	
	//print preorder
	public void print(Node temp){
		if(temp==null)
			return;
		else{
			System.out.print(temp.value + ",");
			print(temp.l);
			print(temp.r);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		for(int i=1;i<15;i++){
			bt1.insert(i);
		}
		bt1.print(bt1.root);
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter key to delete :");
		int key = scan.nextInt();
		scan.close();
		bt1.delete(key);
		bt1.print(bt1.root);
	}
}
