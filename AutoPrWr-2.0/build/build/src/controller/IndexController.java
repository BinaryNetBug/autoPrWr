package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class IndexController {
	@FXML
	private ProgressBar pro;
	
	
	public ProgressBar getPro() {
		return pro;
	}


	public void setPro(ProgressBar pro) {
		this.pro = pro;
	}


	/**
	 * @param pro
	 */
	public IndexController(ProgressBar pro) {
		this.pro = pro;
		this.proTime();
	}


	@FXML
	protected void proTime(){
		Timeline timeLine = new Timeline();
		final KeyValue kv = new KeyValue(pro.progressProperty(), 1);
		final KeyFrame kf = new KeyFrame(Duration.seconds(10), kv);
		
		timeLine.getKeyFrames().add(kf);
		timeLine.play();
	}
}
