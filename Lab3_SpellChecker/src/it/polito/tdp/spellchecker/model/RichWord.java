package it.polito.tdp.spellchecker.model;

public class RichWord {

	private String word;
	private boolean correct;
	
	protected RichWord(String word) {
		this.word = word;
	}
	public String getWord() {
		return word;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	
	
	
	
	
	
}
