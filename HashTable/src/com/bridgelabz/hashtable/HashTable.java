package com.bridgelabz.hashtable;

public class HashTable<K,V> {
	MyLinkedList<K> myLinkedList;
	
	public HashTable() {
		this.myLinkedList = new MyLinkedList<K>();
	}
	
	public V get(K key) {
		MapNode<K,V> myMapNode = (MapNode<K,V>) this.myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}
	
	public void add(K key, V value) {
		MapNode<K,V> myMapNode = (MapNode<K,V> ) this.myLinkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MapNode<K,V> (key, value);
			this.myLinkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	
	@Override
	public String toString() {
		return "HashMapNodes{" + myLinkedList+ "}";
	}
}
