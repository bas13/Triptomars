package com.caseware.triptomars.domains;



import org.springframework.stereotype.Component;

@Component
public class Spaceship {
	
	//If app taking too long to run, reduce the size of ROWS and COLS.
	private static final int CABINS = 4;
	private static final int ROWS = 5000;
	private static final int COLS = 5000;
	
	//Used primitive type int instead of an object type due to this large array
	//taking lots of memory.
	int[][][] floorMap = new int[CABINS][ROWS][COLS];

	private static final int EMPTY = 0;
	private static final int PASSENGER = 1;
	private static final int MACHINERY = 2;
	private static final int CONTAINER = 3;
	
	
	public Spaceship() {
		
		initializeFloormap();
	}
	
	public int[][][] getFloorMap() {
		return floorMap;
	}

	public void setFloorMap(int[][][] floorMap) {
		this.floorMap = floorMap;
	}
	
	/**
	 * Helper method to initialize the floor map.
	 */
	private void initializeFloormap() {
		//Initialize the floor map.
		for (int i = 0; i < CABINS; i++) {
			for (int j = 0; j < ROWS; j++) {
				for (int k = 0; k < COLS; k++) {
					floorMap[i][j][k] = EMPTY;
				}
			}
		}
	}

	public static int getCabins() {
		return CABINS;
	}

	public static int getRows() {
		return ROWS;
	}

	public static int getCols() {
		return COLS;
	}

	public static int getEmpty() {
		return EMPTY;
	}

	public static int getPassenger() {
		return PASSENGER;
	}

	public static int getMachinery() {
		return MACHINERY;
	}

	public static int getContainer() {
		return CONTAINER;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(CABINS * ROWS * COLS);
		for (int i = 0; i < CABINS; i++) {
			result.append("\n" + "CABIN" + (i + 1) + "\n" + "[");
			for (int j = 0; j < ROWS; j++) {
				for (int k = 0; k < COLS; k++) {
					result.append(floorMap[i][j][k] + ",");
				}
				result.append("\n");
			}
			result.append("]\n");
		}
		return result.toString();
	}

}
