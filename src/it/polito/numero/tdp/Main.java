package it.polito.numero.tdp;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import it.polito.model.numero.tdp.NumeroModel;;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader((getClass().getResource("Numero.fxml")));
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Numero.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			NumeroModel model = new NumeroModel();
			NumeroController controller = (NumeroController)loader.getController();
			controller.setModel(model);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
