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
			Scene scene = new Scene(root,600,600);
			
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
			HamDist1.setText("" + (int)ham.getValue());
			
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
			
			//Distance Labels
			Label L0 = new Label("Distance 0");
			Label L1 = new Label("Distance 1");
			Label L2 = new Label("Distance 2");
			Label L3 = new Label("Distance 3");
			Label L4 = new Label("Distance 4");
			
			//Distance text area
			TextField d0 = new TextField();
			TextField d1 = new TextField();
			TextField d2 = new TextField();
			TextField d3 = new TextField();
			TextField d4 = new TextField();
			
			d0.setEditable(false);
			d1.setEditable(false);
			d2.setEditable(false);
			d3.setEditable(false);
			d4.setEditable(false);

			//Calculate HD button
			Button calc = new Button("Calculate HD");
			calc.setOnAction(new EventHandler<ActionEvent>()  {

				@Override
				public void handle(ActionEvent event)  {
					
					d0.setText("" + newList.countHamDist(menu.getValue().toString(), 0));
					d1.setText("" + newList.countHamDist(menu.getValue().toString(), 1));
					d2.setText("" + newList.countHamDist(menu.getValue().toString(), 2));
					d3.setText("" + newList.countHamDist(menu.getValue().toString(), 3));
					d4.setText("" + newList.countHamDist(menu.getValue().toString(), 4));
				}
			});
			
			//add station Button
			TextField id = new TextField();
			Button add = new Button("Add Station");
			add.setOnAction(new EventHandler<ActionEvent>()  {

				@Override
				public void handle(ActionEvent event)  {
					
					menu.getItems().add(id.getText());
					
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
			root.add(calc,0 , 5);
			root.add(L0, 0, 6);
			root.add(L1, 0, 7);
			root.add(L2, 0, 8);
			root.add(L3, 0, 9);
			root.add(L4, 0, 10);
			root.add(d0, 1, 6);
			root.add(d1, 1, 7);
			root.add(d2, 1, 8);
			root.add(d3, 1, 9);
			root.add(d4, 1, 10);
			root.add(add, 0, 11);
			root.add(id, 1, 11);
			
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
