package com.caseware.triptomars.services;


public interface SpaceshipService {

	int[] nextSpot(int objectType);
	
	String getShipState();

	int objectAt(int cabin, int row, int col);
	
	
}
