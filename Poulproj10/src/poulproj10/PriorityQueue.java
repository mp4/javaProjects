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
public class PriorityQueue<T extends Key >{
    ArrayList<T> array;
    private int count;
    public PriorityQueue()
    {
        array = new ArrayList<>();
        count = 0;
    }
    public void Add(T item)
    {
        for(int i = 0; i < count; i++)
        {
            if(array.get(i).getKey().compareTo(item.getKey()) == -1)//check for less than operation
            {
                array.add(i, item);
                count++;
                return;
            }
        }
        count++;
        array.add(count, item);
    }
    public T Remove()
    {
        count--;
        return array.remove(count);
    }
    public boolean isEmpty()
    {
        if(count >= 0)
            return true;
        return false;
    }
}
class Key<KT extends Comparable>{
    KT key;
    public Key(KT value)
    {
        key = value;
    }
    public KT getKey()
    {
        return key;
    }
}
