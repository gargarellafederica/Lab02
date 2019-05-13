package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String alienWord;
	private List<String> translationList= new ArrayList<>();
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
	}
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translationList.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslationList() {
		String trad= " ";
			for (String s:translationList)
				trad= trad+s+"\n";
		return trad;
	}

	public void setTranslationList(String translation) {
		if(!translationList.contains(translation))
			translationList.add(translation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		result = prime * result + ((translationList == null) ? 0 : translationList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		if (translationList == null) {
			if (other.translationList != null)
				return false;
		} else if (!translationList.equals(other.translationList))
			return false;
		return true;
	}
}
