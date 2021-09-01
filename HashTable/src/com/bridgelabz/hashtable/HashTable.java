package com.bridgelabz.hashtable;

import java.util.*;

public class HashTable<K,V> {
	private int numOfBuckets;
	ArrayList<MyLinkedList<K>> bucketArray;
	
	public HashTable() {
		this.numOfBuckets = 10;
		this.bucketArray = new ArrayList<>(numOfBuckets);
		for(int i=0;i<numOfBuckets;i++) {
			bucketArray.add(null);
		}
	}
	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}
	
	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> linkedList = bucketArray.get(index);
		if(linkedList == null) {
			return null;
		}
		MapNode<K,V> myMapNode = (MapNode<K,V>) linkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}
	
	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> linkedList = bucketArray.get(index);
		if(linkedList == null) {
			linkedList = new MyLinkedList();
			bucketArray.set(index, linkedList);
		}
		MapNode<K,V> myMapNode = (MapNode<K,V>) linkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MapNode<K,V> (key, value);
			linkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	public void remove(K key) {
		int index = getBucketIndex(key);
		MyLinkedList<K> linkedList = bucketArray.get(index);
		if(linkedList == null)
			return;
		MapNode<K,V> myMapNode = (MapNode<K,V>) linkedList.delete(key); 
		System.out.println("Deleted key="+myMapNode.getKey()+" and value="+myMapNode.getValue());
	}
	
	@Override
	public String toString() {
		return "MyHashMapNodes{" + bucketArray+ "}";
	}
}
