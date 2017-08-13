package com.caseware.triptomars.services;

public interface SpaceshipService {

	public int[][][] nextSpot(String objectType);
	
	public String getShipState();
	
	public String getShipStateByCabin(int cabin);
	
	public int objectAt(int cabin, int row, int col);
	
	
}
