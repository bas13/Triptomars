/**
 * 
 */
package com.caseware.triptomars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caseware.triptomars.domains.Spaceship;
import com.caseware.triptomars.services.SpaceshipService;

@RestController
public class SpaceshipController {

	private SpaceshipService spaceshipService;
	
	@Autowired
	public void setSpaceshipService(SpaceshipService spaceshipService) {
		this.spaceshipService = spaceshipService;
	}
	
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String getShipState() {
		
		return spaceshipService.getShipState();
		//return new Spaceship().toString();
	}
}
