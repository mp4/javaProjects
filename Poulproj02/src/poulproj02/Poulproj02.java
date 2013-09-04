/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj02;

/**
 *
 * @author marsh poulson 9/02/2013
 */
public class Poulproj02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        c(4,2);
        rabbit(5);
    }
    private static int stackedRabbitCalls = 0;
    
    public static int c(int n, int k)
    {
        System.out.print("c(" + n +", " + k + ") = ");
        if((k == 0) || (k == n))
        {
            System.out.println("1");
            return 1;
        }
        else if(k > n)
        {
            System.out.println("0");
            return 0;
        }
        else
        {
            System.out.println("c(" + (n-1) + ", " + (k-1) + ") + c(" + (n-1) +
                    ", " + k + ");");
            return c(n-1, k-1) + c(n-1, k);
        }
    }
    public static int rabbit(int n)
    {
        int temp;
        
        for(int i=0; i< stackedRabbitCalls; i++)
        {
            System.out.print("\t");
        }
        
        System.out.println("Entering rabbit: n = " + n);
        stackedRabbitCalls++;
        if( n <= 2)
        {
            stackedRabbitCalls--;
            
            for(int i=0; i< stackedRabbitCalls; i++)
            {
                System.out.print("\t");
            }
        
            System.out.println("Leave rabbit: n = "+ n + "\tvalue = 1");
            return 1;
        }
        temp = rabbit(n-1) + rabbit(n-2);
        stackedRabbitCalls--;
        for(int i=0; i< stackedRabbitCalls; i++)
            {
                System.out.print("\t");
            }
        System.out.println("Leave rabbit: n = "+n + "\tvalue = " + temp);
        return temp;
    }
}
