package com.bridgelabz.hashtable;

public class HashTableMain {

	public static void main(String[] args) {
		String sentence = "To be or not to be";
		HashTable<String, Integer> myHashMap = new HashTable<String, Integer>();
		String [] words = sentence.toLowerCase().split(" ");	
		for( String word : words) {
			Integer value = myHashMap.get(word);
			if(value == null) 
				value = 1;
			else 
				value  = value+1;
			myHashMap.add(word, value);
		}
		Integer frequency  = myHashMap.get("to");
		System.out.println("The Word \"to\" is repeated : "+frequency+" times");

	}

}
