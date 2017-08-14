/**
 * 
 */
package com.caseware.triptomars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caseware.triptomars.services.SpaceshipService;

@RestController
public class SpaceshipController {

	private SpaceshipService spaceshipService;
	
	@Autowired
	public void setSpaceshipService(SpaceshipService spaceshipService) {
		this.spaceshipService = spaceshipService;
	}
	
	@RequestMapping(value = "/next/spot/{o}", method = RequestMethod.GET)
	public int[] nextSpot(@PathVariable int o) {
		return spaceshipService.nextSpot(o);
	}
	
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String getShipState() {
		
		return spaceshipService.getShipState();
	}
	
	@RequestMapping(value = "/object/at/{i}/{j}/{k}", method = RequestMethod.GET)
	public int objectAt(@PathVariable int i, @PathVariable int j, @PathVariable int k) {
		return spaceshipService.objectAt(i, j, k);
	}
}
