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
				return w.getTranslationList(); //problema in questa istruzione restituisce solo la prima parola della lista
			return null;
	}

	public void resetDizionario() {
		dizionario.clear();
	}
	
	//Esercizio 3
	
	public String translateWordWildCard(String alienWildCard) {
		// Utilizzo le regual expression di Java (posso usare stringa.matches())
		// Sostituisco "?" con "."
		// "." nelle regex indica un qualsiasi carattere

		alienWildCard = alienWildCard.replaceAll("\\?", ".");
		
		int matchCounter = 0;
		StringBuilder sb = new StringBuilder();

		for (WordEnhanced w : dizionario) {
			if (w.compareWild(alienWildCard)) {
				matchCounter++;
				sb.append(w.getTranslationList() + "\n");
			}
		}
		if (matchCounter != 0)
			return sb.toString();
		else return null;
	}

	//public List<WordEnhanced> getDizionario() {
	//	return dizionario;
	//}
}

