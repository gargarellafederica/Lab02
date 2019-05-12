package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dizionario;
	
	public AlienDictionary() {
		dizionario= new ArrayList<>(); 
	}
	
	public void addWord(String alienWord, String translation) {
		Word parola=new Word(alienWord,translation);
		if(dizionario.contains(parola)){
			
			dizionario.get(dizionario.indexOf(parola)).setTranslation(translation);
			return;
			}
		dizionario.add(parola);
	}

	public String translateWord (String alienWord) {
		Word parola=new Word(alienWord); 
			if(dizionario.contains(parola)) {
				return dizionario.get(dizionario.indexOf(parola)).getTranslation();
			}
		return null;
	}

	public void resetDizionario() {
		dizionario.clear();
	}

}

