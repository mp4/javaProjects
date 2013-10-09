/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

import java.util.LinkedList;
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
        instance.adjacencyList[0] = (LinkedList<City>)new LinkedList();
        instance.adjacencyList[0].add(new City("someCity"));
        instance.displayAllCities();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displayAdjacentCities method, of class FlightMap.
     */
    @Test
    public void testDisplayAdjacentCities() {
        System.out.println("displayAdjacentCities");
        City aCity = new City("someCity");
        FlightMap instance = new FlightMap();
        instance.adjacencyList[0] = (LinkedList<City>)new LinkedList();
        instance.adjacencyList[0].add(new City("someCity"));
        instance.adjacencyList[0].add(new City("second City"));
        instance.adjacencyList[0].add(new City("third City"));
        instance.displayAdjacentCities(aCity);
        System.out.println("");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of markVisited method, of class FlightMap.
     */
    @Test
    public void testMarkVisited() {
        System.out.println("markVisited");
        City aCity = new City("test");
        FlightMap instance = new FlightMap();
        instance.adjacencyList[0] = (LinkedList<City>)new LinkedList();
        instance.adjacencyList[0].add(new City("test"));
        
        instance.markVisited(aCity);
        if(visitedList[0] == false)
        // TODO review the generated test code and remove the default call to fail.
            fail("The test failed");
    }

    /**
     * Test of unVisitAll method, of class FlightMap.
     */
    @Test
    public void testUnVisitAll() {
        System.out.println("unVisitAll");
        FlightMap instance = new FlightMap();
        instance.visitedList[0] = true;
        instance.unVisitAll();
        if(instance.visitedList[0] == true)
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
        City aCity = new City("someCity");
        City adjactentCity = new City("ThirdCity");
        FlightMap instance = new FlightMap();
        instance.adjacencyList[0] = (LinkedList<City>)new LinkedList();
        instance.adjacencyList[0].addFirst(new City("someCity"));
        instance.adjacencyList[0].addLast(new City("second City"));
        instance.insertAdjacentCity(aCity, adjactentCity);
        instance.displayAdjacentCities(aCity);
        if(!instance.adjacencyList[0].get(2).equals(adjactentCity))
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
