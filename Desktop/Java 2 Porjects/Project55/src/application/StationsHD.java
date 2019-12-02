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
	
	public int calcHD(String stationID1, String stationID2) {
		
		int hmDist = 0;
		
		for (int i = 0; i < 4; ++i) {
			
			if (stationID1.charAt(i) == stationID2.charAt(i) ) {
				hmDist += 0;
				
			}
			else {
				hmDist += 1;
			}
		}
		
		return hmDist;
		
	}
	
	public ArrayList<String> equalHamDist(String id, int dist) {
		
		equalHD = new ArrayList<>();
		
		for(int i = 0; i < stationsList.size(); i++) {
			
			if (calcHD(stationsList.get(i), id) == dist) {
				equalHD.add(stationsList.get(i));
			}
		}
		return equalHD;
	}

	public ArrayList<String> getStationsList() {
		return stationsList;
	}

	public ArrayList<String> getEqualHD() {
		return equalHD;
	}
	
}
