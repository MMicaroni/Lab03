package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

	private List<String>dictionary=new LinkedList<String>();
	public void loadDictionary(String language) {
		
		
		try
		    {
			 FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			 String word;
			 dictionary.clear();
			 while ((word = br.readLine()) != null) {
			
				// Aggiungere parola alla struttura dati
				 dictionary.add(word);
			 }
			br.close();

			 } catch (IOException e){
			 System.out.println("Errore nella lettura del file");
			}
		
		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord>richWords=new LinkedList<RichWord>();
		
		for(String s : inputTextList) {
			s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]\"]", "");
			s=s.toLowerCase();
			if(dictionary.contains(s)) {
				
				RichWord r = new RichWord(s);
				richWords.add(r);
				r.setCorrect(true);
			}
			else {
				RichWord r=new RichWord(s);
				richWords.add(r);
				r.setCorrect(false);
			}
				
			
		}
		
		return richWords;
		
		
	}
	public List<String> wrongWords(List<RichWord> input){
		List<String> wrongWords=new LinkedList<String>();
		for(RichWord rw: input) {
			if(rw.isCorrect()==false)
				wrongWords.add(rw.getWord());
		}

		return wrongWords;
		
	}
	
	
}
