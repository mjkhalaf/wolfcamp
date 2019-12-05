package application;
	

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
	
	@SuppressWarnings("unchecked")
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
			Slider slider = new Slider(1, 4, val);
			slider.setSnapToTicks(true);
			slider.setMajorTickUnit(1);
			
			slider.setShowTickMarks(true);
			slider.setShowTickLabels(true);
			slider.setBlockIncrement(1);
			slider.setMinorTickCount(0);
			
			
			TextField HamDist1 = new TextField();
			HamDist1.setEditable(false);
			HamDist1.setText("" + (int)slider.getValue());
			
			//updating the textfield according to the slider
			slider.valueProperty().addListener(new ChangeListener<Number>()  {
				
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					
					slider.setValue(newValue.intValue());
					HamDist1.setText("" + (int)slider.getValue());
					
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
			
			
			//Show showButton button
			Button showButton = new Button("Show Stations");
			showButton.setOnAction(new EventHandler<ActionEvent>()  {

				@Override
				public void handle(ActionEvent event)  {
					whiteSpace.getItems().clear();
					whiteSpace.getItems().addAll(newList.equalHamDist(menu.getValue().toString(), (int)slider.getValue()));
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
			
			//start of the creative section
			//finding the index of the station in the dropdown menu
			Label indexLabel = new Label("	Station Index is:	");
			TextField index = new TextField();
			index.setEditable(false);
			menu.setOnAction(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					index.setText("" + newList.stationIndex(menu.getValue().toString()));
				}
			});
			
			//Finding ASCEII average of the station from the menu
			Button avgAS = new Button("Ascii Average");
			Label floorL = new Label("	Floor: ");
			Label ceilingL = new Label("	Ceiling: ");
			Label avgL = new Label("	Average: ");
			
			TextField floor = new TextField();
			TextField ceiling = new TextField();
			TextField avg = new TextField();
			
			floor.setEditable(false);
			ceiling.setEditable(false);
			avg.setEditable(false);
			
			avgAS.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					floor.setText("" + newList.Avg(menu.getValue().toString())[0]);
					ceiling.setText(""+ newList.Avg(menu.getValue().toString())[1]);
					avg.setText("" + newList.Avg(menu.getValue().toString())[2]);
					
				}
			});
			
			
			//adding the componenets to the layout
			root.add(sliderLabel, 0 , 0);
			root.add(HamDist1, 1, 0);
			root.add(slider, 0, 1);
			root.add(showButton, 0, 2);
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
			
			//creative section
			root.add(indexLabel, 2, 4);
			root.add(index, 3, 4);
			root.add(avgAS, 2, 5);
			root.add(floorL, 2, 6);
			root.add(ceilingL, 2, 7);
			root.add(avgL, 2, 8);
			root.add(floor, 3, 6);
			root.add(ceiling, 3, 7);
			root.add(avg, 3, 8);
			
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
