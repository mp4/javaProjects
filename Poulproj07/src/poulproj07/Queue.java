/**
 *this file contains the queue class it is a reference based implementation
 * @author marsh poulson 10/19/2013
 */
package poulproj07;

/*
 * the queue class designed to hold a set of the objects denoted by T
 */
public class Queue<T> {
    /*
     * internal Node representation contains an item and the next node
     */
    class Node
    {
        T item;
        Node next;
        /*
         * constructs a Node with a given item next is null
         */
        public Node(T item)
        {
            this.item = item;
        }
    }
    
    Node head;
    Node tail;
    /*
     * returns whether or not the queue is empty
     */
    public boolean isEmpty()
    {
        if(head == null)
            return true;
        return false;
    }
    /*
     * adds the item itemToAdd to the queue
     */
    public void enqueue(T itemToAdd)
    {
        //tail will never be null so check head
        if(head == null)
        {
            head = tail = new Node(itemToAdd);
            return;
        }
        tail.next = new Node(itemToAdd);
    }
    /*
     * removes and returns an item from the queue throws an exception if the 
     * queue is empty
     */
    public T dequeue()
    {
        T returnMe;
        if(head == null)
        {
            throw new IllegalAccessError(
                    " queue is empty you cannot remove an item from an empty "+
                    "queue");
        }
        returnMe = head.item;
        head = head.next;
        return returnMe;
    }
    /*
     * returns an item from the queue throws an exception if the queue is empty
     */
    public T peek()
    {
        if(head == null)
        {
            throw new IllegalAccessError(
                    " queue is empty you cannot peek at no item");
        }
        return head.item;
    }   
}
