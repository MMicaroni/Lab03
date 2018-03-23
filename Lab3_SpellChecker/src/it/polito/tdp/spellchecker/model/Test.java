package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		Dictionary dictionary = new Dictionary();

		dictionary.loadDictionary("English");
		
		List<String> input = new LinkedList<String>();
		
		input.add("Hello");
		input.add("Dog");
		input.add("Cat");
		input.add("Gatto");
		
		dictionary.spellCheckText(input);
		
		for(RichWord r:dictionary.spellCheckText(input)) {
			
			System.out.println(r.getWord()+" "+r.isCorrect());
		}
		
	}

}
