package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			double val = 0;
			GridPane root = new GridPane();
			Scene scene = new Scene(root,500,600);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Label sliderLabel = new Label("Enter Hamming Distance:");
			sliderLabel.setFont(new Font(15));
		
			Slider ham = new Slider(1, 4, val);
			
			ham.setSnapToTicks(true);
			ham.setMajorTickUnit(1);
			ham.setShowTickMarks(true);
			ham.setShowTickLabels(true);
			ham.setBlockIncrement(1);
			ham.setMinorTickCount(0);
			
			TextField HamDist1 = new TextField();
			HamDist1.setEditable(false);
			
			ham.valueProperty().addListener(new ChangeListener<Number>()  {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					
					ham.setValue(newValue.intValue());
					HamDist1.setText("" + (int)ham.getValue());
					
				}

				
				
			});
			
			//adding the componenets to the layout
			root.add(sliderLabel, 0 , 0);
			root.add(HamDist1, 1, 0);
			root.add(ham, 0, 1);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hamming Distance");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
