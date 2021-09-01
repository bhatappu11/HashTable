package com.bridgelabz.hashtable;

public class MyLinkedList<K> {
	Node<K> head;
	Node<K> tail;
	
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(Node<K> node) {
		if(this.head == null) {
			this.head = node;
		}
		if(this.tail == null) {
			this.tail = node;
		}
		else {
			Node<K> tempNode = this.head;
			this.head = node;
			this.head.setNext(tempNode);
		}
	}
	public void append(Node<K> node) {
		if(this.head == null) {
			this.head = node;
		}
		if(this.tail == null) {
			this.tail = node;
		}
		else {
			this.tail.setNext(node);
			this.tail = node;
		}
	}
	public void insert(Node<K> node,K key) {
		Node<K> keyNode = search(key);
		if(keyNode == null)
			return;
		if(this.tail.equals(keyNode))
			this.tail = node;
		node.setNext(keyNode.getNext());
		keyNode.setNext(node);
	}
	public Node<K> getHead(){
		return head;
	}
	public void pop() {
		if(head == null) {
			return;
		}
		head = head.getNext();
	}
	public void popLast() {
		if(head == null || head == tail) {
			head = null;
			tail = null;
		}
		else {	
			Node<K> tempNode = head;
			while(tempNode.getNext()!= this.tail) {
				tempNode = tempNode.getNext();
			}
			tail = tempNode;
			tempNode.setNext(null);
		}
	}
	public Node<K> search(K key) {
		Node<K> tempNode = head;
		while (tempNode != null && !tempNode.getKey().equals(key)) {
			tempNode = tempNode.getNext();
		}
		if (tempNode == null) {
			return null;
		}
		return tempNode;
	}
	public Node<K> delete(K key) {
		Node<K> keyNode = search(key);
		if(keyNode == null) {
			return null;
		}
		if(head==keyNode) {
			head=null;
			tail=null;
			return null;
		} else {
			Node<K> tempNode = head;
			while(tempNode.getNext()!= keyNode) {
				tempNode = tempNode.getNext();
			}
			Node<K> deletedNode = tempNode.getNext();
			tempNode.setNext(keyNode.getNext());
			if(keyNode == tail) {
				tail = tempNode;
			}
			return deletedNode;
		}
	}
	public int size() {
		int linkedListSize = 0;
		Node<K> tempNode = head;
		while(tempNode !=null) {
			tempNode = tempNode.getNext();
			linkedListSize++;
		}
		return linkedListSize;
	}
	
	public void printNodes() {
		Node<K> temp = head;
		while(temp!=null) {
			System.out.print(temp.getKey()+" ");
			temp = temp.getNext();
		}
		System.out.println();
	}

}
