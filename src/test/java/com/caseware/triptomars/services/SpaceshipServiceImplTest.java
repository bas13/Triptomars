package com.caseware.triptomars.services;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.caseware.triptomars.TriptomarsApplication;
import com.caseware.triptomars.domains.Spaceship;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TriptomarsApplication.class)
@WebAppConfiguration
public class SpaceshipServiceImplTest {

	private static final int CABINS = 4;
	private static final int ROWS = 50;
	private static final int COLS = 50;
	
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
	public void testNextSpotContainer() {
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);
		
		//Add a passenger object in both floor maps.
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				expectedFloormap[0][i][j] = CONTAINER;
				actualFloormap[0][i][j] = CONTAINER;
			}
		}
	
		assertNotNull(actualSs);
		assertNotNull(sss);
		expectedSs.setFloorMap(expectedFloormap);
		actualSs.setFloorMap(actualFloormap);
		sss.setSpaceship(actualSs);
		int[] expectedNextSpot = {0,0,3};
		assertTrue(Arrays.equals(expectedNextSpot, sss.nextSpot(CONTAINER)));
		
	}

	@Test
	public void testNextSpotPassenger() {
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);
		
		//Add a passenger object in both floor maps.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				expectedFloormap[0][i][j] = PASSENGER;
				actualFloormap[0][i][j] = PASSENGER;
			}
		}
	
		assertNotNull(actualSs);
		assertNotNull(sss);
		expectedSs.setFloorMap(expectedFloormap);
		actualSs.setFloorMap(actualFloormap);
		sss.setSpaceship(actualSs);
		int[] expectedNextSpot = {0,0,5};
		assertTrue(Arrays.equals(expectedNextSpot, sss.nextSpot(PASSENGER)));
		
	}
	
	@Test
	public void testNextSpotMachinery() {
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);
		
		//Add a passenger object in both floor maps.
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				expectedFloormap[0][i][j] = MACHINERY;
				actualFloormap[0][i][j] = MACHINERY;
			}
		}
	
		assertNotNull(actualSs);
		assertNotNull(sss);
		expectedSs.setFloorMap(expectedFloormap);
		actualSs.setFloorMap(actualFloormap);
		sss.setSpaceship(actualSs);
		int[] expectedNextSpot = {0,0,10};
		assertTrue(Arrays.equals(expectedNextSpot, sss.nextSpot(MACHINERY)));
		
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
	public void testObjectAtWithEmptySpace() {

		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		
		sss.setSpaceship(actualSs);
		assertTrue(expectedSs.getFloorMap()[0][0][0] == sss.objectAt(0, 0, 0));
		
	}
	
	@Test
	public void testObjectAtWithContainer() {
		
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);
		
		//Add a container object in both floor maps.
		expectedFloormap[1][1][1] = CONTAINER;
		actualFloormap[1][1][1] = CONTAINER;
		
		
		assertNotNull(actualSs);
		assertNotNull(sss);
		expectedSs.setFloorMap(expectedFloormap);
		actualSs.setFloorMap(actualFloormap);
		sss.setSpaceship(actualSs);
		assertTrue(sss.objectAt(1, 1, 1) == CONTAINER);
		
		
		
	}
	
	
	@Test
	public void testObjectAtWithPassenger() {
		
		SpaceshipServiceImpl sss = new SpaceshipServiceImpl();
		Spaceship actualSs = new Spaceship();
		Spaceship expectedSs = new Spaceship();
		int[][][] expectedFloormap = new int[CABINS][ROWS][COLS];
		int[][][] actualFloormap = new int[CABINS][ROWS][COLS];
		initializeFloormap(expectedFloormap);
		initializeFloormap(actualFloormap);
		
		//Add a passenger object in both floor maps.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				expectedFloormap[0][i][j] = PASSENGER;
				actualFloormap[0][i][j] = PASSENGER;
			}
		}
	
		assertNotNull(actualSs);
		assertNotNull(sss);
		expectedSs.setFloorMap(expectedFloormap);
		actualSs.setFloorMap(actualFloormap);
		sss.setSpaceship(actualSs);
		assertTrue(sss.objectAt(0, 2, 2) == PASSENGER);	
		
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
