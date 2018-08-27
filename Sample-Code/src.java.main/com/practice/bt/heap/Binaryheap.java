package com.practice.bt.heap;

import java.util.Scanner;

public class Binaryheap {

	int capacity;
	int []heap;
	int heapSize;
	
	Binaryheap(int capacity){
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.heapSize = 0;
	}
	
	public int leftIndex(int i){
		return 2*i + 1;
	}

	public int rightIndex(int i){
		return 2*i + 2;
	}
	
	public int parentIndex(int i){
		if(i>1)
			return (i-1)/2;
		else
			//return i<=0?-1:0;
			return 0;
	}

	public void heapify(int keyIndex){
		while(keyIndex<heapSize){
			int leftI = leftIndex(keyIndex), rightI = rightIndex(keyIndex);
			if(leftI<heapSize && heap[keyIndex]<heap[leftI] && heap[leftI]>heap[rightI]){ 
				heap[keyIndex] = heap[keyIndex] + heap[leftI];
				heap[leftI] = heap[keyIndex] - heap[leftI];
				heap[keyIndex] = heap[keyIndex] - heap[leftI];
				keyIndex = leftI;
			}else if(rightI<heapSize && heap[keyIndex]<heap[rightI] && heap[rightI]>heap[leftI]){
				heap[keyIndex] = heap[keyIndex] + heap[rightI];
				heap[rightI] = heap[keyIndex] - heap[rightI];
				heap[keyIndex] = heap[keyIndex] - heap[rightI];
				keyIndex = rightI;
			}else
				break;
		}
	}
	
	public void printHeap(){
		for(int i = 0;i<heapSize;i++){
			System.out.print(heap[i] + " ");
		}
	}
	
	public void insertKey(int key){
		if(heapSize>=capacity){
			System.out.println("Heap Overflow!");
			return;
		}
		int tempIndex = heapSize;
		heap[heapSize++] = key;
		while(heap[tempIndex]>heap[parentIndex(tempIndex)]){
			int parentIndex = parentIndex(tempIndex);
			heap[tempIndex] = heap[tempIndex] + heap[parentIndex];
			heap[parentIndex] = heap[tempIndex] - heap[parentIndex];
			heap[tempIndex] = heap[tempIndex] - heap[parentIndex];
			tempIndex = parentIndex;
		}
	}
	
	public void printMax(){
		if(heapSize>0)
			System.out.println("Heap Max is "+heap[0]);
		else
			System.out.println("Empty Heap");
	}
	
	public void deleteMax(){
		heap[0] = heap[heapSize-1];
		heap[heapSize-1] = 0;
		heapify(0);
		heapSize--;
	}
	
	public static void main(String[] args) {
		System.out.println("<--------------Binary Max Heap--------------->");
		System.out.println("Enter Capacity ");
		Scanner scan = new Scanner(System.in);
		int userCapacity = scan.nextInt();
		scan.close();
		Binaryheap bheap = new Binaryheap(userCapacity);
		int lower = 10,upper = 100;
		for(int i = 0;i<userCapacity;i++){
			bheap.insertKey((int)(Math.random()*(upper-lower))+lower);
		}
		bheap.printHeap();
		System.out.print("\nDelete Max 1  ");
		bheap.deleteMax();
		bheap.printHeap();
		System.out.print("\nDelete Max 2  ");
		bheap.deleteMax();
		bheap.printHeap();
	}

}
