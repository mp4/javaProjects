/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication04;

/**
 *
 * @author marsh
 */
public class Polynomial {
    Integer degree_;
    Node head;
    
    public Polynomial()
    {
        
    }
    public int getCoefficient(int power)
    {
        Node cur = head;
        while(cur != null && cur.power_ <= power)
        {
            if(cur.power_ == power)
            {
                return cur.coeff_;
            }
            cur = cur.next_;
        }
    }
    public void setCoefficient(int coef, int power)
    {
        Node cur, prev;
    }
    @Override public String toString()
    {
        
    }
}
class Node
{
    int coeff_;
    int power_;
    Node next_;
    public Node(int coeff, int power)
    {
        coeff_ = coeff;
        power_ = power;
    }
    public Node(int coeff, int power, Node next)
    {
        coeff_ = coeff;
        power_ = power;
        next_ = next;
    }
}
