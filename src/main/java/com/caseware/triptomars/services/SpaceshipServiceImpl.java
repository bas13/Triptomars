package com.caseware.triptomars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caseware.triptomars.domains.Spaceship;

@Service
public class SpaceshipServiceImpl implements SpaceshipService {

	
	private Spaceship spaceShip;
	
	@Autowired
	public void setSpaceship(Spaceship spaceShip) {
		this.spaceShip = spaceShip;
	}
	
	/**
	 * Finds the next spot in the floor map.
	 * @param objectType is either 0(empty), 1(container), 2(passenger), 
	 * or 3(machinery).
	 * @return coordinates which is an array that has the cabin, row and col.
	 */
	@Override
	public int[] nextSpot(int objectType) {
		int[][][] floorMap = spaceShip.getFloorMap();
		int[] coordinates = new int[3];
		boolean isValidSpot = false;
		if (objectType == spaceShip.getContainer()) {
			for (int i = 0; i < spaceShip.getCabins(); i++) {
				for (int j = 0; j < spaceShip.getRows(); j++) {
					for(int k = 0; k < spaceShip.getCols(); k++) {
						if (floorMap[i][j][k] == spaceShip.getEmpty()) {
							coordinates = new int[]{i, j, k};
							isValidSpot = true;
							break;
						}
					}
					if (isValidSpot) {
						break;
					}
				}
				if(isValidSpot) {
					break;
				}
			}
		} else if (objectType == spaceShip.getPassenger()) {
			isValidSpot = false;
			for (int i = 0; i < spaceShip.getCabins(); i++) {
				for (int j = 0; j < spaceShip.getRows(); j++) {
					for(int k = 0; k < spaceShip.getCols(); k++) {
						if (floorMap[i][j][k] == spaceShip.getEmpty()) {
							coordinates = new int[]{i, j, k};
							isValidSpot = true;
							
							// Prevents from going out of bounds.
							if ((spaceShip.getRows() - j) > 5 && (spaceShip.getCols() - k) > 5) {
								//Checks if there is enough room for a passenger 
								//from 1st empty spot found.
								for (int m = j; m < 5; m++) {
									for (int n = k + 1; n < 5; n++) {
										if (floorMap[i][m][n] != spaceShip.getEmpty()) {
											isValidSpot = false;
											break;
										}
									}
								}
								
								if (isValidSpot) {
									break;
								}
							}
						}
						if (isValidSpot) {
							break;
						}
						
					}
					if (isValidSpot) {
						break;
					}
				}
				if (isValidSpot) {
					break;
				}
			}
		} else if (objectType == spaceShip.getMachinery()) {
			isValidSpot = false;
			for (int i = 0; i < spaceShip.getCabins(); i++) {
				for (int j = 0; j < spaceShip.getRows(); j++) {
					for(int k = 0; k < spaceShip.getCols(); k++) {
						if (floorMap[i][j][k] == spaceShip.getEmpty()) {
							coordinates = new int[]{i, j, k};
							isValidSpot = true;
							
							// Prevents from going out of bounds.
							if (spaceShip.getRows() - j > 10 && spaceShip.getCols() - k > 10) {
								//Checks if there is enough room for machinery 
								//from 1st empty spot found.
								for (int m = j; m < 10; m++) {
									for (int n = k + 1; n < 10; n++) {
										if (floorMap[i][m][n] != spaceShip.getEmpty()) {
											isValidSpot = false;
											break;
										}
									}
								}
								
								if (isValidSpot) {
									break;
								}
							}
						}
						
						
					}
					if (isValidSpot) {
						break;
					}
				}
				if (isValidSpot) {
					break;
				}
			}
		} else {
			coordinates = new int[]{-1, -1, -1};
		}
		return coordinates;
	}

	@Override
	public String getShipState() {
		return spaceShip != null? spaceShip.toString() : "";
	}

	@Override
	public int objectAt(int cabin, int row, int col) {
		if (spaceShip != null && cabin >= 0 && cabin < spaceShip.getCabins()
				&& row >= 0 && row < spaceShip.getRows() && 
				col >= 0 && col < spaceShip.getCols()) {
			return spaceShip.getFloorMap()[cabin][row][col];
		} else {
			return -1;
		}
	}

	public Spaceship getSpaceShip() {
		return spaceShip;
	}

}
