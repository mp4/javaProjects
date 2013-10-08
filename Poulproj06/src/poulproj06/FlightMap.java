/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

import java.lang.*;
import java.util.LinkedList;

public class FlightMap
{
    /*
     * the adjacency list stores all citys the city in the first element of the
     * linkedList is next to
     */
	LinkedList<City>[] adjacencyList;
        boolean[] visitedList;
	private final int MAXSIZE = 20;
	public FlightMap()
	{
		adjacencyList = new LinkedList[MAXSIZE];
                visitedList = new boolean[MAXSIZE];
	}
	
	public void readInFlightMap(String cityFileName, String flightFileName)
	{
		
	}
	
	public void displayAllCities()
	{
		for(int i=0; i< MAXSIZE; i++)
		{
                    if(adjacencyList[i] != null)
			System.out.println(adjacencyList[i].get(0));
		}
	}
	public void displayAdjacentCities(City aCity)
	{
		for(int i=1; i < adjacencyList[findIndex(aCity)].size() ; i++)
		{
                    System.out.println(adjacencyList[findIndex(aCity)].get(i));
		}
	}
	public void markVisited(City aCity)
	{
		int index  = findIndex(aCity);
                if(index == -1)
                {
                    throw new IllegalArgumentException("aCity not found");
                }
                visitedList[index] = true;
	}
	public void unVisitAll()
	{
		visitedList = new boolean[MAXSIZE];
	}
	
	public boolean isVisited(City aCity)
	{
		return false;
	}
	public void insertAdjacentCity(City aCity, City adjactentCity)
	{
		int index = findIndex(aCity);
                if(index == -1)
                {
                    throw new IllegalArgumentException("aCity not found");
                }
                adjacencyList[index].addLast(aCity);
	}
	public City getNextCity( City fromCity)
	{
		return null;
	}
	public boolean isPath(City origen, City destinationCity)
	{
		return false;
	}
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

