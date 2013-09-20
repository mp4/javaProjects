/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Poulproj04;

/**
 * contains the polynomial and its associated node class
 * @author marsh poulson 9/19/2013
 */
public class Polynomial {
    Integer degree_;
    Node head;
    
    public Polynomial()
    {
        
    }
    /*
     * returns the coefficient of a given power 
     */
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
    /*
     * returns the node with a given power returns null if not found
     */
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
    /*
     * sets the coeficient of a term given by the power if a node is set to
     * coefficent 0 it will not be printed
     */
    public void setCoefficient(int coef, int power)
    {
        //internal note if coef = 0 remove node
        Node cur, prev;
        prev = null;
        cur = head;
        
        if(coef == 0)
        {
            while(cur != null && cur.power_ <= power)
            {
                if(cur.power_ == power)
                {
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }
            
            if(cur != null)
            {
                prev.next_ = cur.next_;
            }
            
            return;
        }
        
        if(getCoefficientNode(power) == null)
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
        
        getCoefficientNode(power).coeff_ = coef;
    }
    /*
     * returns the polynomial in a string representation elements set to zero
     * will not be printed
     */
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
/*
 * the node class is used to store the nodes of a polynomial
 * will contain a power and a coefficient
 */
class Node
{
    int coeff_;
    int power_;
    Node next_;
    /*
     * Initializes a node with a coefficient and a power
     * next will remain null
     */
    public Node(int coeff, int power)
    {
        coeff_ = coeff;
        power_ = power;
    }
    /*
     *Initializes a node with a coefficient a power and which node it refers to
     */
    public Node(int coeff, int power, Node next)
    {
        coeff_ = coeff;
        power_ = power;
        next_ = next;
    }
}
