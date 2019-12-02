package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StationsHD {
	
	private ArrayList<String> stationsList;
	private ArrayList<String> equalHD;
	
	public StationsHD() throws IOException {
		read();
		
	}
	
	public void read() throws IOException {
		stationsList = new ArrayList<>();
		
		File file = new File("C:\\Users\\m7md2\\Desktop\\Java 2 Porjects\\Project55\\src\\Mesonet.txt");
		BufferedReader bw = new BufferedReader(new FileReader(file));
		
		String curr = bw.readLine();
		
		while (curr != null ) {
			curr = curr.substring(0,4);
			stationsList.add(curr);
			curr = bw.readLine();
		}
		bw.close();
	}
	public ArrayList<String> equalHamDist(int dist) {
		equalHD = new ArrayList<>();
		
		return equalHD;
		
	}
	
}
