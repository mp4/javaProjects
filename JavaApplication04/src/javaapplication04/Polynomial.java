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
    int degree_;
    Node head;
    
    public Polynomial()
    {
        
    }
    int getCoefficient(int power)
    {
        
    }
    void setCoefficient(int coef, int power)
    {
        
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
