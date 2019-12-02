package application;
	

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
			//slider label
			Label sliderLabel = new Label("Enter Hamming Distance:");
			sliderLabel.setFont(new Font(15));
		
			//slider setup
			Slider ham = new Slider(1, 4, val);
			ham.setSnapToTicks(true);
			ham.setMajorTickUnit(1);
			ham.setShowTickMarks(true);
			ham.setShowTickLabels(true);
			ham.setBlockIncrement(1);
			ham.setMinorTickCount(0);
			
			
			TextField HamDist1 = new TextField();
			HamDist1.setEditable(false);
			
			//updating the textfield according to the slider
			ham.valueProperty().addListener(new ChangeListener<Number>()  {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					
					ham.setValue(newValue.intValue());
					HamDist1.setText("" + (int)ham.getValue());
					
				}				
			});
			
			//Station text
			ListView whiteSpace = new ListView();
			whiteSpace.setPrefSize(200, 200);
			whiteSpace.setEditable(false);
			
			//dropdown Menu
			Label listLabel = new Label("Compare with:");
			ComboBox menu = new ComboBox();
			StationsHD newList = new StationsHD();
			menu.getItems().addAll(newList.getStationsList());
			
			
			//Show stations button
			Button stations = new Button("Show Stations");
			stations.setOnAction(new EventHandler<ActionEvent>()  {

				@Override
				public void handle(ActionEvent event)  {
					whiteSpace.getItems().clear();
					whiteSpace.getItems().addAll(newList.equalHamDist(menu.getValue().toString(), (int)ham.getValue()));
				}
			});
			
			//adding the componenets to the layout
			root.add(sliderLabel, 0 , 0);
			root.add(HamDist1, 1, 0);
			root.add(ham, 0, 1);
			root.add(stations, 0, 2);
			root.add(whiteSpace, 0, 3);
			root.add(listLabel, 0, 4);
			root.add(menu, 1, 4);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hamming Distance");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {	
		launch(args);
	}
}
