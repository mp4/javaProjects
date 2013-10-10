/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.LinkedList;
import java.util.Stack;

public class FlightMap
{
    /*
     * the adjacency list stores all citys the city in the first element of the
     * linkedList is next to
     */
	LinkedList<City>[] adjacencyList;
        boolean[] visitedList;
	private final int MAXSIZE = 20;
	/*
	 * creates a new instance of a flightmap initializes the proper internal variables
	 */
	public FlightMap()
	{
		adjacencyList = new LinkedList[MAXSIZE];
                visitedList = new boolean[MAXSIZE];
	}
	/*
	 * reads in a cityfile which is alist of all the cites that will be serviced 
	 * and the reads in a list of all the flights associated with given pairs of
	 * cities
	 */
	public void readInFlightMap(String cityFileName, String flightFileName) 
                throws FileNotFoundException, IOException
	{
            BufferedReader fileIn = new BufferedReader(
                    new FileReader(cityFileName));
            try
            {
            	int i = 0;
            	while(true)
            	{
            		String line = fileIn.readLine();
            		adjacencyList[i] = (LinkedList<City>)new LinkedList();
            		adjacencyList[i].add(new City(line));
            		i++;
            	}
            	
            }
            catch(Exception e)
            {
            	//maybe change to eof error we are done with the loop
            	;
            }
            
            fileIn.close();
            
            fileIn = new BufferedReader(new FileReader(flightFileName));
            try
            {
            	int i = 0;
            	while(true)
            	{
            		String line = fileIn.readLine();
            		String[] cites = line.split(",");
            		//add code to find and add city to proper place
            		
            		i++;
            	}
            }
            catch(Exception e)
            {
            	
            }
            fileIn.close();
	}
	/*
	 * outputs to the user all the cities serviced by hpair
	 */
	public void displayAllCities()
	{
		for(int i=0; i< MAXSIZE; i++)
		{
                    if(adjacencyList[i] != null)
			System.out.println(adjacencyList[i].get(0));
		}
	}
	/*
	 * outputs to the user all the cities that are adjacent to a given city
	 */
	public void displayAdjacentCities(City aCity)
	{
		for(int i=1; i < adjacencyList[findIndex(aCity)].size() ; i++)
		{
                    System.out.println(adjacencyList[findIndex(aCity)].get(i));
		}
	}
	/*
	 * marks a given city as visited
	 */
	public void markVisited(City aCity)
	{
		int index  = findIndex(aCity);
                if(index == -1)
                {
                    throw new IllegalArgumentException("aCity not found");
                }
                visitedList[index] = true;
	}
	/*
	 * unvisits all the cities that currently have been marked as visited
	 */
	public void unVisitAll()
	{
		visitedList = new boolean[MAXSIZE];
	}
	/*
	 * returns whether or not a city has been visited yet
	 */
	public boolean isVisited(City aCity)
	{
		return visitedList[findIndex(aCity)];
	}
	/*
	 * inserts the adjacent city into the list of cities serviced by aCity
	 */
	public void insertAdjacentCity(City aCity, City adjactentCity)
	{
		int index = findIndex(aCity);
                if(index == -1)
                {
                    throw new IllegalArgumentException("aCity not found");
                }
                adjacencyList[index].addLast(aCity);
	}
	/*
	 * returns the next unvisited city from the fromCity specified
	 */
	public City getNextCity( City fromCity)
	{
		return null;
	}
	public boolean isPath(City originCity,
               City destinationCity) {
	// ---------------------------------------------------
	// Determines whether a sequence of flights between two cities
	// exists. Nonrecursive stack version.
	// Precondition: originCity and destinationCity are the origin
	// and destination cities, respectively.
	// Postcondition: Returns true if a sequence of flights exists
	// from originCity to destinationCity, otherwise returns
	// false. Cities visited during the search are marked as
	// visited in the flight map.
	// Implementation notes: Uses a stack for the cities of a
	// potential path. Calls unvisitAll, markVisited, and
	// getNextCity.
	// ---------------------------------------------------
	  Stack stack = new Stack();
	
	  City topCity, nextCity;
	  unVisitAll();  // clear marks on all cities
	
	  // push origin city onto stack, mark it visited
	  stack.push(originCity);
	  markVisited(originCity);
	
	  topCity = (City)(stack.peek());
	  while (!stack.empty() &&
	         (topCity.equals(destinationCity))) {
	    // loop invariant: stack contains a directed path
	    // from the origin city at the bottom of the stack
	    // to the city at the top of the stack
	
	    // find an unvisited city adjacent to the city on
	    // the top of the stack
	    nextCity = getNextCity(topCity);
	
	    if (nextCity == null) {
	      stack.pop();  // no city found; backtrack
	    }
	    else {                  // visit city
	      stack.push(nextCity);
	      markVisited(nextCity);
	    }  // end if
	    topCity = (City)stack.peek();
	  }  // end while
	  if (stack.isEmpty()) {
	    return false;  // no path exists
	  }
	  else {
	    return true;   // path exists
	  }  // end if
	}  // end isPath

        /*
         * this method searches for a selected city in the array and returns its
         * index returns -1 if the city is not found relys on city.equals
         */
	private int findIndex(City city)
	{
		for(int i=0; i < adjacencyList.length; i++)
                {
                    if(city.equals(adjacencyList[i].get(0)))
                    {
                        return i;
                    }
                }
                return -1;
	}
}

