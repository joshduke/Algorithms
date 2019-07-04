package com.learn.linked;

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of Linked List
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}*/
class RemoveDulicateNodes
{
    Node removeDuplicates(Node head)
    {
	// Your code here	
	Node currentNode = head;
	if(currentNode != null){
	    while(currentNode.getNext() != null){
	        if(currentNode.getData() == currentNode.getNext().getData()){
	            currentNode.setNext(currentNode.getNext().getNext());
	        }else {
	        	currentNode = currentNode.getNext();
	        }
	    }
	}
	return head;
    }
}

public class RemoveDuplicates{
	
	public static void main(String[] args) {
		
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();
		Node node5 = new Node();
		Node node6 = new Node();
		Node node7 = new Node();
		
		node1.setData(10);
		node2.setData(20);
		node3.setData(30);
		node4.setData(30);
		node5.setData(50);
		node6.setData(60);
		node7.setData(70);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		
		RemoveDulicateNodes remove = new RemoveDulicateNodes();
		
		Node uniqueNodes = remove.removeDuplicates(node1);
		
		Node currentNode = uniqueNodes;
		
		while(currentNode.getNext() != null) {
			
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
			
		}
	}
	
}
