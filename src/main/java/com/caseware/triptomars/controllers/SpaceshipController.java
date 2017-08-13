/**
 * 
 */
package com.caseware.triptomars.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caseware.triptomars.domains.Spaceship;

@RestController
public class SpaceshipController {

	
	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String getShipState() {
		
		return new Spaceship().toString();
	}
}
