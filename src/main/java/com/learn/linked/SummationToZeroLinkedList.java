package com.learn.linked;

public class SummationToZeroLinkedList {

	
	// Brute Force or Iteration Method -- Can also be done with Stack
	public void summationOfNodes(Node[] nodes) {
		int[] rejectedIndex = new int[nodes.length];
		int sum = 0;
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i].getData() > 0) {	// In stack this can be done with Push
				sum = sum + nodes[i].getData();
			}else {
//				if()
			}
			
		}
		
	}
}
