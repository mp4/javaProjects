/**
 * contains the polynomial and its associated node class
 *
 * @author marsh poulson 9/19/2013
 */
package Poulproj04;

import sun.security.util.Length;

public class Polynomial {

    int degree_;
    Node head;

    /*
     * creates an empty polynomial of degree 0
     */
    public Polynomial() {
        this.degree_ = 0;
    }

    /*
     * returns the coefficient of a given power 
     */
    public int getCoefficient(int power) {
        Node cur = head;
        while (cur != null && cur.power_ >= power) {
            if (cur.power_ == power) {
                return cur.coeff_;
            }
            cur = cur.next_;
        }
        return 0;
    }
    /*
     * returns the node with a given power returns null if not found
     */

    Node getCoefficientNode(int power) {
        Node cur = head;
        while (cur != null && cur.power_ >= power) {
            if (cur.power_ == power) {
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

    public void setCoefficient(int coef, int power) {
        //internal note if coef = 0 remove node
        Node cur, prev;
        prev = null;
        cur = head;

        if (coef == 0) {
            while (cur != null && cur.power_ >= power) {
                if (cur.power_ == power) {
                    break;
                }
                prev = cur;
                cur = cur.next_;
            }

            if (cur != null) {
                prev.next_ = cur.next_;
            }

            return;
        }
        //check against degree and set if necessary
        if (coef > degree_) {
            degree_ = coef;
        }
        if (getCoefficientNode(power) == null) {
            if (cur == null) {
                head = new Node(coef, power);
                return;
            }

            prev = cur;
            cur = cur.next_;
            while (cur != null) {

                //add item if
                if (prev.power_ < power) {
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

    @Override
    public String toString() {
        String returnMe = "";
        Node cur = head;
        while (cur != null) {
            returnMe = returnMe + cur.coeff_
                    + ((cur.power_ != 0) ? ("x^" + cur.power_ + " + ") : " + ");
            cur = cur.next_;
        }
        //check and trim off excessive + at the end if the expression does not 
        // end with a digit3
        if (returnMe.endsWith("+ ")) {
            returnMe = returnMe.substring(0, returnMe.length() - 3);
        }
        return returnMe;
    }
    /*
     * evaluates the polynomial at the value x and returns the value it 
     * evaluates to
     */

    public double evalute(double x) {
        double sum = 0.0;
        Node cur = head;
        while (cur != null) {
            sum += cur.coeff_ * Math.pow(x, cur.power_);
            cur = cur.next_;
        }
        return sum;
    }
    /*
     * adds two polynomials together and returns the result does not modify the 
     * original polynomial
     */

    public Polynomial add(Polynomial other) {
        Polynomial temp = new Polynomial();
        //two lazy loops some things may be done twice
        Node cur = head;
        while (cur != null) {
            temp.setCoefficient(cur.coeff_, cur.power_);
            cur = cur.next_;
        }
        cur = other.head;
        while (cur != null) {
            temp.setCoefficient(cur.coeff_ + getCoefficient(cur.power_), cur.power_);
            cur = cur.next_;
        }
        return temp;
    }
}
/*
 * the node class is used to store the nodes of a polynomial
 * will contain a power and a coefficient
 */

class Node {

    int coeff_;
    int power_;
    Node next_;
    /*
     * Initializes a node with a coefficient and a power
     * next will remain null
     */

    public Node(int coeff, int power) {
        coeff_ = coeff;
        power_ = power;
    }
    /*
     *Initializes a node with a coefficient a power and which node it refers to
     */

    public Node(int coeff, int power, Node next) {
        coeff_ = coeff;
        power_ = power;
        next_ = next;
    }
}
