package com.bridgelabz.hashtable;

public interface Node<K> {
	K getKey();
    void setKey(K key);
    Node<K> getNext();
    void setNext(Node<K> next);	
}
