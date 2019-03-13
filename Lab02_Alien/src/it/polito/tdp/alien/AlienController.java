package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
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
  
    AlienDictionary diz;
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String testo = txtWord.getText().toLowerCase();
    	String[] parole = testo.split(" ");
    	if (parole.length==2) {
    		diz.addWord(parole[0], parole[1]);
    		txtWord.clear();
    	}
    	if (parole.length==1) {
    		if(diz.translateWord(parole[0])!=null)
    			txtResult.appendText("La traduzione è" + diz.translateWord(parole[0].toLowerCase())+ "\n");
    		else txtResult.appendText("Parola non presente, aggiungerla con relativa traduzione!\n");
    	}
    		
    	throw new InvalidParameterException("Testo inserito non valido");
    		
    	}
    	    	
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();

    }
    
    }
    
