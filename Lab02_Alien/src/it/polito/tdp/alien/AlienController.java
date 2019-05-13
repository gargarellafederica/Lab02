package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary diz= new AlienDictionary();
	 
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String testo = txtWord.getText().toLowerCase();
    	String txt = testo.trim();
    	
    	// controllo sull'input se ho inserito solo spazi o nulla 
    	if (txt.length()==0 || testo==null) {
    		txtResult.setText("Inserire una o due parole!\n");
    		txtWord.clear();
    		return;
    	}
    	String[] parole = testo.split(" "); //salvo le due parole
  
    	if (parole.length==2) {
    		
    		//controllo siano solo caratteri alfabetici
    		if (!parole[0].matches("[a-zA-Z]*") || !parole[1].matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici.\n");
    			txtWord.clear();
    			return;
    		}
    		
    		//aggiungo la parola
    		txtWord.clear();
    		diz.addWord(parole[0], parole[1]);
    		txtResult.appendText("La traduzione della parola: " + parole[0] +" è: " + parole[1] + "\n");
    		//for (WordEnhanced w: diz.getDizionario())
    		//	if( w.getAlienWord().contains(parole[0]))
    		//		txtResult.appendText(w.getTranslationList());
    	}
    	if (parole.length==1) {
    		
    		//controllo siano solo caratteri alfabetici
    		if (!parole[0].matches("[a-zA-Z?]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici.\n");
    			txtWord.clear();
    			return;
    		} 
    		String trad;
    		if (parole[0].matches("[a-zA-Z?]*") &&  !parole[0].matches("[a-zA-Z]*"))
    		//traduzione con WildCrd
    			trad=diz.translateWordWildCard(parole[0]);
    		else
    			//cerco o aggiungo la traduzione
    			trad= diz.translateWord(parole[0]);
    		
			if(trad !=null)
				txtResult.setText("La traduzione è: " + trad );
			else txtResult.setText("Parola non presente, aggiungerla con relativa traduzione!\n");
    	}
    	if (parole.length>2)
    		txtResult.setText("Inserire una o due parole\n");
    		txtWord.clear();
    }
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    	diz.resetDizionario();
    }
    
    }
    
