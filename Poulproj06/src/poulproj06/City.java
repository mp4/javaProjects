/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj06;

/**
 *
 * @author marsh
 */
public class City {
    private String name;
    public City(String name)
    {
        this.name = name;
    }
    
    @Override public boolean equals(Object o)
    {
        if(((City)o).name.equals(name))
            return true;
        return false;
    }
    
    @Override public String toString()
    {
        return name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
