package com.caseware.triptomars.services;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.caseware.triptomars.TriptomarsApplication;
import com.caseware.triptomars.domains.Spaceship;

//@RunWith(SpringRunner.class) //used late in development.
@SpringBootTest(classes = TriptomarsApplication.class)
@WebAppConfiguration	//Double check proper usage.
public class SpaceshipServiceImplTest {

	private static final int CABINS = 4;
	private static final int ROWS = 5;
	private static final int COLS = 5;
	
	private static final int EMPTY = 0;
	private static final int PASSENGER = 1;
	private static final int MACHINERY = 2;
	private static final int CONTAINER = 3;
	
	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNextSpot() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetShipStateInitialize() {
		
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
/*		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);*/
		
		assertNotNull(actualSs);
		assertNotNull(sss);
		sss.setSpaceship(actualSs);
		//assertTrue(Arrays.deepEquals(expectedFloormap, ss.getFloorMap()));
		assertTrue(expectedSs.toString().equals(sss.getShipState()));
		
		
	}
	
	@Test
	public void testGetShipStatewithObject() {
		
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);
		
		//Add a container object in both floor maps.
		expectedFloormap[0][0][0] = CONTAINER;
		actualFloormap[0][0][0] = CONTAINER;
		
		
		assertNotNull(actualSs);
		assertNotNull(sss);
		expectedSs.setFloorMap(expectedFloormap);
		actualSs.setFloorMap(actualFloormap);
		sss.setSpaceship(actualSs);
		assertTrue(expectedSs.toString().equals(sss.getShipState()));
		
		
	}

	@Test
	public void testGetShipStateByCabin() {
		//fail("Not yet implemented");
	}

	@Test
	public void testObjectAtEmptySpace() {

		
	}
	
	
	/**
	 * Helper method to initialize the floor map.
	 */
	private void initializeFloormap(int[][][] floorMap) {
		//Initialize the floor map.
		for (int i = 0; i < CABINS; i++) {
			for (int j = 0; j < ROWS; j++) {
				for (int k = 0; k < COLS; k++) {
					floorMap[i][j][k] = EMPTY;
				}
			}
		}
	}

}
