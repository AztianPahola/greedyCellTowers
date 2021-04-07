package onlyOne;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

public class CellTowers {

	public static void main(String[] args) {
		int[] testHouses = {3, 5, 8, 10, 14, 19, 21, 25, 29, 31, 37, 39, 44, 55, 59, 63, 66, 69, 75, 80};
		
		// Test brute force algorithm
		ArrayList<Integer> bfResult = bruteForceTowerPlacement(testHouses);
		System.out.println("Number of cell towers Required: " + bfResult.size());
		System.out.print("Placed at mile markers: ");
		for (Integer x : bfResult) {
			System.out.print(x + " ");
		}
		
		// Test greedy algorithm
		ArrayList<Integer> greedyResult = greedyTowerPlacement(testHouses);
		System.out.println("Number of cell towers Required: " + greedyResult.size());
		System.out.print("Placed at mile markers: ");
		for (Integer x : greedyResult) {
			System.out.print(x + " ");
		}
		
	}
	
	private static ArrayList<Integer> greedyTowerPlacement(int[] houses) {
		
		int[] roadWithHouses = new int[houses[houses.length-1] + 1]; // Create an array which will simulate the road
		ArrayList<Integer> cellTowers = new ArrayList<Integer>();
		for (int x: houses) { // Every mile marker with a house will be denoted by a 1
			roadWithHouses[x] = 1;
		}
		
		Hashtable<Integer,Integer> coverages;
		do {
			coverages = new Hashtable<Integer,Integer>();
			int index = 9;
			do {
				int coverage = 0;
				for(int j = index-9; j < roadWithHouses.length && j <= index+9; j++) {
					if (roadWithHouses[j] == 1)
						coverage++;
				}
				coverages.put(index, coverage);
				index++;
			}while(index < roadWithHouses.length - 10);
			int mostCoverage = 0;
			int mileMarker = 0;
			
			// Determine which potential cell tower has the most coverage
			for(Entry<Integer, Integer> entry : coverages.entrySet()) {
				if(entry.getValue() > mostCoverage) {
					mostCoverage = entry.getValue();
					mileMarker = entry.getKey();
				}
			}
			// Build the cell tower with the most coverage, flip the covered houses to 0
			cellTowers.add(mileMarker);
			for(int i = mileMarker-9; i < roadWithHouses.length && i <= mileMarker+9; i++) {
				roadWithHouses[i] = 0;
			}
		}while(!coverages.isEmpty());
		
		return cellTowers;
	}
	
	private static ArrayList<Integer> bruteForceTowerPlacement(int[] houses) {
		
		ArrayList<Integer> cellTowers = new ArrayList<Integer>();
		int index = 9;
		
		do {
		cellTowers.add(index);
		index += 18;
		}while (index < houses[houses.length-1]);
		cellTowers.add(index);
		
		return cellTowers;
		
	}
}
