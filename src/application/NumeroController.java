package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NumeroController {

	private int nMax = 100;
	private int tMax = 10;
	private int numero;
	private int tentativiResidui = tMax;
	private int tentativo = 1;
	private List<Integer> numeri;
	
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
    	this.tentativiResidui = tMax;
    	this.ButtonNuova.setDisable(true);
    	this.TentativiText.setDisable(true);
    	this.numero = (int)(Math.random()* nMax +1);
    	this.TentativiText.clear();
    	this.TentativiText.appendText(Integer.toString(tentativiResidui));
    	this.ButtonProva.setDisable(false);
    	this.InserimentoText.setDisable(false);
    	
    }

    @FXML
    void DoTry(ActionEvent event) {
    	
    	try {
    	boolean h = false;
    	if(!InserimentoText.getText().equals("")) {
    	this.mio = Integer.parseInt(InserimentoText.getText());
    	if(numeri !=  null) {
    	for(int n : numeri) {
    		if(n == mio) {
    			h = true;
    			this.TextResult.appendText("Numero già inserito");
    			tentativiResidui--;
    			if(tentativiResidui == 0) {
        			this.TextResult.appendText("Tentativi terminati, HAI PERSO! Il numero era "+this.numero+"\n");
        			this.ButtonNuova.setDisable(false);
        			this.ButtonProva.setDisable(true);
        			this.InserimentoText.setDisable(true);
        			this.TentativiText.setDisable(false);
        		}
    		}
    	}
    	}
    	if(h == false) {
    	if(mio > this.numero) {
    		TextResult.appendText("Numero troppo ALTO \n");
    		this.tentativiResidui--;
    		this.InserimentoText.clear();
    		this.TentativiText.clear();
    		this.TentativiText.appendText(Integer.toString(tentativiResidui));
    		if(tentativiResidui == 0) {
    			this.TextResult.appendText("Tentativi terminati, HAI PERSO! Il numero era "+this.numero+"\n");
    			this.ButtonNuova.setDisable(false);
    			this.ButtonProva.setDisable(true);
    			this.InserimentoText.setDisable(true);
    			this.TentativiText.setDisable(false);
    		}
    	} else if( mio < this.numero) {
    		TextResult.appendText("Numero troppo BASSO \n");
    		this.tentativiResidui--;
    		this.InserimentoText.clear();
    		this.TentativiText.clear();
    		this.TentativiText.appendText(Integer.toString(tentativiResidui));
    		if(tentativiResidui == 0) {
    			this.TextResult.appendText("Tentativi terminati, HAI PERSO! Il numero era "+this.numero+"\n");
    			this.ButtonNuova.setDisable(false);
    			this.ButtonProva.setDisable(true);
    			this.InserimentoText.setDisable(true);
    			this.TentativiText.setDisable(false);
    		}
    	} else {
    		TextResult.appendText("Numero TROVATO \n");
    		this.InserimentoText.clear();
    		this.TentativiText.clear();
    		this.TentativiText.appendText(Integer.toString(tentativiResidui));
    		this.ButtonNuova.setDisable(false);
			this.ButtonProva.setDisable(true);
			this.InserimentoText.setDisable(true);
			this.TentativiText.setDisable(false);
    	}
    	}
    	}
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
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