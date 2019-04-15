package application;
	
import com.jfoenix.controls.JFXProgressBar;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Index.fxml"));
			JFXProgressBar pro = (JFXProgressBar) root.lookup("#pro");
			this.proTime(pro,primaryStage);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("css/application.css").toExternalForm());
			primaryStage.setTitle("网虫自动编译器");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void proTime(JFXProgressBar pro,Stage stage){
		Timeline timeLine = new Timeline();
		final KeyValue kv = new KeyValue(pro.progressProperty(), 1);
		final KeyFrame kf = new KeyFrame(Duration.seconds(3), kv);
		
		timeLine.getKeyFrames().add(kf);
		timeLine.play();
		timeLine.setOnFinished(event -> {
			stage.hide();
			Home home = new Home();
			home.show();
		});
	}
	public static void main(String[] args) {
		launch(args);
	}
}
