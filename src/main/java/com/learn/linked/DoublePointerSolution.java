package com.learn.linked;

public class DoublePointerSolution {
	
	public static void main(String[] args) {
		Node head = new Node();
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		Node fourth = new Node();
		Node fifth = new Node();
		head.setData(10);
		first.setData(20);
		second.setData(30);
		third.setData(40);
		fourth.setData(50);
		fifth.setData(60);
		
		head.setNext(first);
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		fourth.setNext(fifth);
		
		System.out.println(new DoublePointerSolution().findNthNodeFromLast(head, 4).getData());
	}
	
	public Node findNthNodeFromLast(Node head, int n) {
		
		Node mainPtr = head;
		Node findPtr = head;
		int length = 1;
		int pointerDifference = Math.abs(-n+1);
		int findPointerPos = 1;
		
		if(head != null) {
			
			while(mainPtr.getNext() != null) {
				mainPtr = mainPtr.getNext();
				if(length - (pointerDifference) == findPointerPos) {
					findPtr = findPtr.getNext();
					findPointerPos++;
				}
				length++;
			}
		}
		
		return findPtr;
	}

}
