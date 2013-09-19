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
        return 0;
    }
    Node getCoefficientNode(int power)
    {
        Node cur = head;
        while(cur != null && cur.power_ <= power)
        {
            if(cur.power_ == power)
            {
                return cur;
            }
            cur = cur.next_;
        }
        return null;
    }
    public void setCoefficient(int coef, int power)
    {
        Node cur, prev;
        cur = head;
        if(getCoeffricentNode(power) == null)
        {
                 if(cur == null)
            {
                head = new Node(coef, power);
                return;
            }
            while(cur != null)
            {
                //add item if
                if(cur.power_ > power)
                {
                    prev.next_ = new Node(coef, power, cur);
                    return;
                }
                prev = cur;
                cur = cur.next_;
            }
            prev.next_ = new Node(coef, power);
            return;
        }
        
        getCoeffricentNode(power).coeff_ = coef;
    }
    @Override public String toString()
    {
        String returnMe = "";
        Node cur = head;
        while(cur != null)
        {
            returnMe = returnMe + cur.coeff_ +"x^" + cur.power_;
            cur = cur.next_;
        }
        return returnMe;
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
