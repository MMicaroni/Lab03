/**
 * Sample Skeleton for 'SpellChecker.fxml' Controller Class
 */

package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
public class SpellCheckerController {

	Dictionary model;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    private TextArea txtArea;
    @FXML
    private TextArea output;
    @FXML // fx:id="btnLanguage"
    private ComboBox<String> btnLanguage; // Value injected by FXMLLoader

    @FXML // fx:id="btnSpellCheck"
    private Button btnSpellCheck; // Value injected by FXMLLoader

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	output.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    	String text = txtArea.getText();
   // text=text.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]\"]", " ");
    
    	text= text.replaceAll("[^\\w]", " ");
    text= text.trim().replaceAll(" +", " ");
    
    	String words[]=text.split(" ");
    	List<String> textWords = new LinkedList<String>();
    	for(String s: words) {
    		
    		textWords.add(s.trim());
    	}
    	List<String> wrongWords = model.wrongWords(model.spellCheckText(textWords));
    String out="";
    	for(String s:wrongWords) {
    		out+=s+"\n";
    	}
    output.setText(out);
    }

    @FXML
    void selectLanguage(ActionEvent event) {
 
    ComboBox cb= (ComboBox)event.getSource();
    
    String language=(String) cb.valueProperty().getValue();
    //Carico il dizionario della lingua scelta
    model.loadDictionary(language);
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnLanguage != null : "fx:id=\"btnLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
       // btnLanguage.getItems().setAll("English","Italian");
        // btnLanguage.getSelectionModel().selectFirst();
    }
    
    public void setModel(Dictionary model) {
    	
        	this.model=model;
    	     
    	     btnLanguage.getItems().setAll("English","Italian");
         btnLanguage.getSelectionModel().selectFirst();
    	     //Setto di default la lingua inglese
         //String language= (String)btnLanguage.valueProperty().getValue();
    	     //model.loadDictionary(language);
    }
}

