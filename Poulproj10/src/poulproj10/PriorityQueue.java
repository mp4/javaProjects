/*
 * contains the priority queue class which is deigned to be array based and to
 * maintain the order of the items as they enter the priority queue
 * by marsh poulson 11/18/2013
 */

package poulproj10;

import java.util.ArrayList;

/**
 * class which represent a priority queue generic type T is the data the queue
 * stores all of the priorities will be integers
 */
public class PriorityQueue<T>{
    /*
     * Node class used internally to represent each of the priority items
     */
    class Node
    {
        T item;
        int priority;
        /*
         * initializes the Node with a Priority and an item 
         */
        Node (T item_, int priority_)
        {
            item = item_;
            priority = priority_;
        }
    }
    ArrayList<Node> array;
    private int count;
    /*
     * intializes the priority queue
    */
    public PriorityQueue()
    {
        array = new ArrayList<>();
        count = 0;
    }
    /*
     * add the given item to the priority queue with its priority
    */
    public void Add(T item, int priority)
    {
        for(int i = 0; i < count; i++)
        {
            if(array.get(i).priority > priority) //check for less than operation
            {
                array.add(i, new Node(item, priority));
                count++;
                return;
            }
        }
        
        array.add(count, new Node(item, priority));
        count++;
    }
    /*
     * removes and returns the item of the highest priority from the queue
     * and returns it if empty returns null
     */
    public T Remove()
    {
        try
        {
            count--;
            Node temp = array.remove(count);
            return  temp.item;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            count = 0;
            return null;
        }
    }
    /*
     * returns whether or not the priority queue is empty 
     */
    public boolean isEmpty()
    {
        if(count <= 0)
            return true;
        return false;
    }
}