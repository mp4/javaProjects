/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marsh
 */
public class FlightMapTest {
    
    public FlightMapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readInFlightMap method, of class FlightMap.
     */
    @Test
    public void testReadInFlightMap() {
        System.out.println("readInFlightMap");
        String cityFileName = "";
        String flightFileName = "";
        FlightMap instance = new FlightMap();
        instance.readInFlightMap(cityFileName, flightFileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAllCities method, of class FlightMap.
     */
    @Test
    public void testDisplayAllCities() {
        System.out.println("displayAllCities");
        FlightMap instance = new FlightMap();
        instance.displayAllCities();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayAdjacentCities method, of class FlightMap.
     */
    @Test
    public void testDisplayAdjacentCities() {
        System.out.println("displayAdjacentCities");
        City aCity = null;
        FlightMap instance = new FlightMap();
        instance.displayAdjacentCities(aCity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markVisited method, of class FlightMap.
     */
    @Test
    public void testMarkVisited() {
        System.out.println("markVisited");
        City aCity = null;
        FlightMap instance = new FlightMap();
        instance.markVisited(aCity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unVisitAll method, of class FlightMap.
     */
    @Test
    public void testUnVisitAll() {
        System.out.println("unVisitAll");
        FlightMap instance = new FlightMap();
        instance.unVisitAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVisited method, of class FlightMap.
     */
    @Test
    public void testIsVisited() {
        System.out.println("isVisited");
        City aCity = null;
        FlightMap instance = new FlightMap();
        boolean expResult = false;
        boolean result = instance.isVisited(aCity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertAdjacentCity method, of class FlightMap.
     */
    @Test
    public void testInsertAdjacentCity() {
        System.out.println("insertAdjacentCity");
        City aCity = null;
        City adjactentCity = null;
        FlightMap instance = new FlightMap();
        instance.insertAdjacentCity(aCity, adjactentCity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextCity method, of class FlightMap.
     */
    @Test
    public void testGetNextCity() {
        System.out.println("getNextCity");
        City fromCity = null;
        FlightMap instance = new FlightMap();
        City expResult = null;
        City result = instance.getNextCity(fromCity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPath method, of class FlightMap.
     */
    @Test
    public void testIsPath() {
        System.out.println("isPath");
        City origen = null;
        City destinationCity = null;
        FlightMap instance = new FlightMap();
        boolean expResult = false;
        boolean result = instance.isPath(origen, destinationCity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}