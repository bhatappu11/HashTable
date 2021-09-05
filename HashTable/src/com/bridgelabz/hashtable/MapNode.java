package com.bridgelabz.hashtable;

public class MapNode<K,V> implements Node<K> {
	private K key;
	private V value;
	private MapNode<K, V> next;
	public MapNode(K key, V value) {
		this.key = key;
		this.setValue(value);
		this.next = null;
	}
	@Override
	public K getKey() {
		return this.key;
	}
	@Override
	public void setKey(K key) {
		this.key = key;
		
	}
	@Override
	public Node<K> getNext() {
		return this.next;
	}
	@Override
	public void setNext(Node<K> next) {
		this.next = (MapNode<K,V>)next;		
	}
	public V getValue() {
		return this.value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder myMapNodeString = new StringBuilder();
		myMapNodeString.append("MapNode {"+"K=").append(key).append(" V=").append(value).append("}");
		if(next != null)
			myMapNodeString.append("->").append(next);
		return myMapNodeString.toString();
	}
	
	
	
	
	
	
}
