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
			
			NumeroModel model = new NumeroModel();
			FXMLLoader loader = new FXMLLoader();
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Numero.fxml"));
			NumeroController controller = loader.getController();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
