package com.caseware.triptomars.services;

public interface SpaceshipService {

	int[][][] nextSpot(String objectType);
	
	String getShipState();
	
	String getShipStateByCabin(int cabin);
	
	int objectAt(int cabin, int row, int col);
	
	
}
