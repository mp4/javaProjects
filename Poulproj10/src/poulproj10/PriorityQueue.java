/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poulproj10;

import java.util.ArrayList;

/**
 *
 * @author marsh
 * @param <T>
 */
public class PriorityQueue<T>{
    class Node
    {
        T item;
        int priority;
        Node (T item_, int priority_)
        {
            item = item_;
            priority = priority_;
        }
    }
    ArrayList<Node> array;
    private int count;
    public PriorityQueue()
    {
        array = new ArrayList<>();
        count = 0;
    }
    public void Add(T item, int priority)
    {
        for(int i = 0; i < count; i++)
        {
            if(array.get(i).priority < priority) //check for less than operation
            {
                array.add(i, new Node(item, priority));
                count++;
                return;
            }
        }
        count++;
        array.add(count, new Node(item, priority));
    }
    public T Remove()
    {
        count--;
        Node temp = array.remove(count);
        return  temp.item;
    }
    public boolean isEmpty()
    {
        if(count >= 0)
            return true;
        return false;
    }
}