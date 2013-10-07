/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

import java.lang.*;
import java.util.LinkedList;

public class FlightMap
{
	LinkedList<City>[] adjacencyList;
	private final int MAXSIZE = 20;
	public FlightMap()
	{
		adjacencyList = new LinkedList<City>[MAXSIZE];
	}
	
	public void readInFlightMap(String cityFileName, String flightFileName)
	{
		
	}
	
	public void displayAllCities()
	{
		for(int i=0; i< MAXSIZE; i++)
		{
			System.out.println(adjacencyList[i][0]);
		}
	}
	public void displayAdjacentCities(City aCity)
	{
		for(int i=1; i < adjacencyList[findIndex(aCity)].count ; i++)
		{
			adjacencyList[findIndex(aCity)][i];
		}
	}
	public void markVisited(City aCity)
	{
		
	}
	public void unVisitAll()
	{
		
	}
	
	public boolean isVisited(City aCity)
	{
		return false;
	}
	public void insertAdjacentCity(City aCity, City adjactentCity)
	{
		
	}
	public City getNextCity( City fromCity)
	{
		return null;
	}
	public boolean isPath(City origen, City destinationCity)
	{
		return false;
	}
	private int findIndex(City city)
	{
		
	}
}

