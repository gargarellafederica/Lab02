package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		dizionario= new ArrayList<>(); 
	}
	
	public void addWord(String alienWord, String translation) {
		WordEnhanced parola=new WordEnhanced(alienWord,translation);
		if(dizionario.contains(parola)){
			dizionario.get(dizionario.indexOf(parola)).setTranslationList(translation);
			return;
			}
		dizionario.add(parola);
	}

	public String translateWord (String alienWord) {
		for (WordEnhanced w: dizionario)
			if( w.getAlienWord().contentEquals(alienWord))
				return dizionario.get(dizionario.indexOf(w)).getTranslationList(); //problema in questa istruzione restituisce solo la prima parola della lista
			return null;
	}

	public void resetDizionario() {
		dizionario.clear();
	}

	//public List<WordEnhanced> getDizionario() {
	//	return dizionario;
	//}
}

