/*
 * 
 */
package poulproj09;

import java.util.Scanner;
import BinaryTree.BinaryTree;
/**
 *
 * @author marsh
 */
public class Poulproj09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        treeOfKnowledge = new BinaryTree<>("is it a monocot?",
                new BinaryTree("green bean plant"), 
                new BinaryTree<>("corn plant"));
        
        menu(keyboard);
    }
    
    static BinaryTree<String> treeOfKnowledge;
    /*
     * returns  the boolean value contained in a given string throws an 
     * exception if one is not found
     */
    static boolean isYes(String string)
    {
        if(string.equals("YES") || string.equals("y"))
        {
            return true;
        }
        else if(string.equals("NO") || string.equals("n"))
        {
            return false;
        }
        else
        {
            throw  new IllegalArgumentException("string must be YES or NO");
        }
    }
    
       /*
     * this function accepts a scanner which should already be directed to the 
     * standard input device it will output a menu and then call the 
     * appropraiate functions including itself
     */
    public static void menu(Scanner keyboard)
    {
        boolean cont;
        System.out.println("\nthink of a plant and I will guess it.");
        
        parseTreeByUser(keyboard, treeOfKnowledge);
        
        
        cont = getValidBool(keyboard, "Continue? ");
        if(cont)
        {
            menu(keyboard);
        }

    }
    /*
     * prompts the user to answer yes or no to questions until it reachs 
     * the end of the tree and then guesses wha they are thinking and if 
     * it is a new object prompts the user to enter it and a question and adds
     * it in the correct position to the tree, tree must have at least a root 
     * node a right node and a left node
     */
    static BinaryTree<String> parseTreeByUser(Scanner keyboard,
            BinaryTree<String>  tree)
    {
        BinaryTree<String> right, left;
        boolean value;
        right = tree.detachRightSubtree();
        left = tree.detachLeftSubtree();
        if(left.isEmpty() && right.isEmpty())
        {
            //check if correct
            System.out.println("Is it a " + tree.getRootItem() + "?");
            value = getValidBool(keyboard, "");
            
            if(!value)
            {
                System.out.println("I give up what is it?");
                String unknown = keyboard.nextLine();
                System.out.println("Please type a question whose answer is "+
                        "yes for " + unknown + " and no for " + 
                        tree.getRootItem()+ ":");
                
                String  question = keyboard.nextLine();
                
                left = tree;
                right = new BinaryTree<>(unknown);
                tree = new BinaryTree<>(question);
            }
            else
            {
                System.out.print("I win! ");
            }
        }
        else
        {
            //move to correct section of tree
            System.out.println(tree.getRootItem());
            value = getValidBool(keyboard, "");
            
            if(value == true)
            {
                right = parseTreeByUser(keyboard, right);
            }
            else
            {
                left = parseTreeByUser(keyboard, left);
            }
        }
        
        //rebuild tree
        tree.attachLeftSubtree(left);
        tree.attachRightSubtree(right);
        return tree;
    }
    /*
     * prompts the user to enter a valid boolean  with the message
     * repeats until it gets one
     */
    public static boolean getValidBool(Scanner keyboard, String message)
    {
        try
        {
            boolean value;
            System.out.print(message);
            value = isYes(keyboard.nextLine());
            return value;
        }
        catch(Exception e)
        {
            System.out.println("please enter YES or NO");
            return getValidBool(keyboard, message);
        }
    }
}
