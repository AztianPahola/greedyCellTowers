package onlyOne;

import java.util.ArrayList;
import java.util.List;

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
	}
	
	private static int[] greedyTowerPlacement(int[] houses) {
		
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
