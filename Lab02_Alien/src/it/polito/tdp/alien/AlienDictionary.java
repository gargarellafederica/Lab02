package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	List<Word> dizionario= new ArrayList<Word>(); 
	
	public void addWord(String alienWord, String translation) {
		Word parola=new Word(alienWord,translation);
		for (Word w:dizionario) {
			if(w.equals(parola))
				parola.setTranslation(translation);
			else dizionario.add(parola);
		}
	}

	public String translateWord (String alienWord) {
		for (Word w:dizionario) 
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();	
		return null;
	}

}

