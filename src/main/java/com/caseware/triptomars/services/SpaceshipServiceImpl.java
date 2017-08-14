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
	
	@Override
	public int[][][] nextSpot(String objectType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShipState() {
		// TODO Auto-generated method stub
		return spaceShip.toString();
	}

	@Override
	public String getShipStateByCabin(int cabin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int objectAt(int cabin, int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Spaceship getSpaceShip() {
		return spaceShip;
	}

}
