package it.polito.numero.tdp;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import it.polito.model.numero.tdp.NumeroModel;;

public class NumeroController {

	private NumeroModel model;
	
    public NumeroModel getModel() {
		return model;
	}

	public void setModel(NumeroModel model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonNuova;

    @FXML
    private TextArea TentativiText;

    @FXML
    private TextField InserimentoText;

    @FXML
    private Button ButtonProva;

    @FXML
    private TextArea TextResult;
    
    private int mio;
    
    @FXML
    void DoGame(ActionEvent event) {
    	
    	this.TextResult.clear();
    	this.ButtonNuova.setDisable(true);
    	this.TentativiText.setDisable(true);
    	this.TentativiText.setText(Integer.toString(model.gettMax()));
    	this.ButtonProva.setDisable(false);
    	this.InserimentoText.setDisable(false);
    	this.InserimentoText.clear();
    	
    	model.newGame();
    }

    @FXML
    void DoTry(ActionEvent event) {
    	
    	this.InserimentoText.clear();
    	try {
    	this.mio = Integer.parseInt(InserimentoText.getText());
    	}catch (NumberFormatException e) {
    		e.printStackTrace();
    	}
    		
    	if(!model.TentativoValido(mio)) {
    		TextResult.appendText("Tentativo non valido");
    		return;
    	}
    	
    	int risultato = model.newTentativo(mio);
    	
    	if(risultato == 0) {
    		TextResult.appendText("Numero TROVATO in "+model.getTentativiFatti()+" tentativi \n");
    		this.ButtonNuova.setDisable(false);
			this.ButtonProva.setDisable(true);
    	} else if(risultato <0){
    		this.TextResult.appendText("Tentativi terminati, HAI PERSO! Il numero era "+model.getNumero()+"\n");
			this.ButtonNuova.setDisable(false);
			this.ButtonProva.setDisable(true);
    	} else {
    		this.TextResult.appendText("Tentativi terminati, HAI PERSO! Il numero era "+model.getNumero()+"\n");
			this.ButtonNuova.setDisable(false);
			this.ButtonProva.setDisable(true);
    	}
    	
    	TentativiText.setText(Integer.toString((model.gettMax()) - model.getTentativiFatti()));
    
    	if(!model.isInGioco()) {
    		if(risultato != 0) {
    			TextResult.appendText("Hai perso, il numero era "+model.getNumero()+"\n");
    			this.ButtonNuova.setDisable(false);
    			this.ButtonProva.setDisable(true);
    		}
    	}
    }

    @FXML
    void initialize() {
        assert ButtonNuova != null : "fx:id=\"ButtonNuova\" was not injected: check your FXML file 'Numero.fxml'.";
        assert TentativiText != null : "fx:id=\"TentativiText\" was not injected: check your FXML file 'Numero.fxml'.";
        assert InserimentoText != null : "fx:id=\"InserimentoText\" was not injected: check your FXML file 'Numero.fxml'.";
        assert ButtonProva != null : "fx:id=\"ButtonProva\" was not injected: check your FXML file 'Numero.fxml'.";
        assert TextResult != null : "fx:id=\"TextResult\" was not injected: check your FXML file 'Numero.fxml'.";
    }
}