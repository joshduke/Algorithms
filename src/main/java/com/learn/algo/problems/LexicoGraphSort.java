package com.learn.algo.problems;

public class LexicoGraphSort {

	public static void main(String[] args) {
		String inputString = "hackerearth";
		char[] charArray = inputString.toCharArray();
		BinarySearchTreeLinkedListImpl linkedListTree = new BinarySearchTreeLinkedListImpl();
		for(char c : charArray) {
			linkedListTree.addElement(c);
		}
		BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal(linkedListTree.getRootNode());
		treeTraversal.performInOrderTraversal();
	}

}

class BinarySearchTreeLinkedListImpl{

	private BinaryTreeNode rootNode;

	public void addElement(char data) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);

		// If this is the first data, then this becomes the root node
		if(rootNode == null){
			rootNode = newNode;
		}else{	// Already tree created - Not an empty tree
			addToTree(rootNode, data, newNode);
		}
	}

	private void addToTree(BinaryTreeNode rootNode, char data, BinaryTreeNode nodeToAdd){
		while(true){
			int asciiValue = (int)data;
			Character c = (Character)rootNode.getNodeData();
			int nodeData = (int)c.charValue();
			if(asciiValue < nodeData){
				if(rootNode.getLeftChild() == null){
					rootNode.setLeftChild(nodeToAdd);
					break;
				}else{
					addToTree(rootNode.getLeftChild(), data, nodeToAdd);
					break;
				}
			}else if(asciiValue >= nodeData){
				if(rootNode.getRightChild() == null){
					rootNode.setRightChild(nodeToAdd);
					break;
				}else{
					addToTree(rootNode.getRightChild(), data, nodeToAdd);
					break;
				}
			}else{
				break;
			}
		}
	}

	public BinaryTreeNode getRootNode() {
		return this.rootNode;
	}

}


class BinaryTreeNode<T> {

	private T nodeData;
	private BinaryTreeNode<T> rightChild;
	private BinaryTreeNode<T> leftChild;

	public BinaryTreeNode(T nodeData) {
		this.nodeData = nodeData;
	}

	public void setLeftChild(BinaryTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public void setNodeData(T nodeData) {
		this.nodeData = nodeData;
	}

	public void setRightChild(BinaryTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public T getNodeData() {
		return nodeData;
	}

	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

}

class BinaryTreeTraversal<T> {

	private BinaryTreeNode<T> headNode;

	public BinaryTreeTraversal(BinaryTreeNode<T> rootNode) {
		this.headNode = rootNode;
	}


	public void performInOrderTraversal(){
		traverseInOrder(headNode);
	}

	public void performPreOrderTraversal(){
		traversePreOrder(headNode);
	}

	public void performPostOrderTraversal(){
		traversePostOrder(headNode);
	}

	private void traverseInOrder(BinaryTreeNode<T> node){
		if(node != null){
			if(node.getLeftChild() != null){
				traverseInOrder(node.getLeftChild());
			}

			System.out.println(node.getNodeData());

			if(node.getRightChild() != null){
				traverseInOrder(node.getRightChild());
			}
		}
	}

	private void traversePreOrder(BinaryTreeNode<T> node){
		if(node != null){

			System.out.println(node.getNodeData());

			if(node.getLeftChild() != null){
				traversePreOrder(node.getLeftChild());
			}


			if(node.getRightChild() != null){
				traversePreOrder(node.getRightChild());
			}
		}
	}

	private void traversePostOrder(BinaryTreeNode<T> node){
		if(node != null){


			if(node.getLeftChild() != null){
				traversePostOrder(node.getLeftChild());
			}


			if(node.getRightChild() != null){
				traversePostOrder(node.getRightChild());
			}

			System.out.println(node.getNodeData());
		}
	}

}
