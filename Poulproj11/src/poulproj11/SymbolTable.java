/*
 * contains the Symbol table class which is designed to represent a java 
 * compliers symbol table
 * by marsh poulson 12/04/2013 
 */
package poulproj11;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 * represents a java compilers symbol table 
 */
public class SymbolTable {

    static final int EMPTY_ALWAYS = 0, FULL = 1, EMPTY_NOW = 2, SIZE = 1009, MAX_STEP = 14;

    /*
     * the Node class to store all of the links in the hash table
     */
    class Node {

        String data;
        int status;

        /*
         * constructs a node with a status of empty
         */
        public Node() {
            status = EMPTY_ALWAYS;
        }

        /*
         * constructs a node with the item in it and a status of full
         */
        public Node(String item) {
            data = item;
            status = FULL;
        }
    }
    ArrayList<Node> symbols;

    /*
     * constructs a new symbol 
     */
    public SymbolTable() {
        symbols = new ArrayList<>(SIZE);
        //should be unnecessary
        for(int i =0; i< SIZE; i++)
        {
            symbols.add(new Node());
        }
    }

    /*
     * the first hash funtion to calculate the initial position of an item
     */
    private int hash1(String data) {
        return abs(data.hashCode() % SIZE);
    }

    /*
     * the second rehashing function to calculate the offset based on the 
     * string
     */
    private int hash2(String data) {
        return MAX_STEP - (data.hashCode() % (MAX_STEP - 1));
    }
    
    /*
     * returns wheter or not a string is a valid java identifier
     */
    static boolean validJavaIdentifier(String identifier) {
        //exclude reserved words
        if (identifier.equals("abstract") || identifier.equals("continue")
                || identifier.equals("for") || identifier.equals("new")
                || identifier.equals("switch") || identifier.equals("assert")
                || identifier.equals("default") || identifier.equals("goto")
                || identifier.equals("package")
                || identifier.equals("synchronized")
                || identifier.equals("boolean")
                || identifier.equals("do") || identifier.equals("if")
                || identifier.equals("private") || identifier.equals("this")
                || identifier.equals("break") || identifier.equals("double")
                || identifier.equals("implements")
                || identifier.equals("protected")
                || identifier.equals("throw")
                || identifier.equals("byte") || identifier.equals("else")
                || identifier.equals("import") || identifier.equals("public")
                || identifier.equals("throws") || identifier.equals("case")
                || identifier.equals("enum") || identifier.equals("instanceof")
                || identifier.equals("return") || identifier.equals("transient")
                || identifier.equals("catch") || identifier.equals("extends")
                || identifier.equals("int") || identifier.equals("short")
                || identifier.equals("try")
                || identifier.equals("char") || identifier.equals("final")
                || identifier.equals("interface") || identifier.equals("static")
                || identifier.equals("void")
                || identifier.equals("class") || identifier.equals("finally")
                || identifier.equals("long") || identifier.equals("strictfp")
                || identifier.equals("volatile")
                || identifier.equals("const") || identifier.equals("float")
                || identifier.equals("native") || identifier.equals("super")
                || identifier.equals("while") || identifier.isEmpty()) {
            return false;
        }
        //checck start of string
        if (!Character.isJavaIdentifierStart(identifier.charAt(0))) {
            return false;
        }
        //review the rest of the string
        for (int i = 1; i < identifier.length(); i++) {
            if (!Character.isJavaIdentifierPart(identifier.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /*
     * adds an item to the symbol table if it does not already exist throws an 
     * exception if the symbol table is full also throws an exception if the
     * item is not a valid java identifier
     */

    public void Add(String item) throws IllegalAccessException {

        if(!validJavaIdentifier(item))
        {
            throw new IllegalArgumentException(
                    "item must be a valid java identifier");
        }
        if(inTable(item))
        {
            return;
        }
        switch (symbols.get(hash1(item)).status) {
            case EMPTY_ALWAYS:
                symbols.add(hash1(item), new Node(item));
                break;
            case EMPTY_NOW:
                symbols.add(hash1(item), new Node(item));
                break;
            case FULL:
                //march with double hashing until it reaches an empty location
                int nextStatus = FULL;
                int index = hash1(item);
                if (symbols.get(index).data.equals(item)) {
                    return;
                }
                while (nextStatus == FULL) {
                    index += hash2(item);
                    index = index % SIZE;
                    nextStatus = symbols.get(index).status;
                    if (index == hash1(item)) {
                        throw new ArrayStoreException("hash table is full");
                    }
                    if (symbols.get(index).data.equals(item)) {
                        return;
                    }
                }
                symbols.add(index, new Node(item));
                break;
            default:
                throw new IllegalAccessException(
                        "the status of the location is not valid");
        }

    }
    /*
     * outputs all of the symbols currently in the symbol table to the user
     */

    public void outputAllSymbols() {
        for (int i = 0; i < SIZE; i++) {
            if (symbols.get(i).status == FULL) {
                System.out.println(symbols.get(i).data);
            }
        }
    }
    /*
     * deletes a given symbol from the symbol table
    */
    public void deleteSymbol(String symbol)
    {
        int hash = hash1(symbol);
        int index = hash;
        int offset = hash2(symbol);
        
        while(symbols.get(hash).status != EMPTY_ALWAYS)
        {
            if(symbols.get(hash).data.equals(symbol) && 
                    symbols.get(hash).status != EMPTY_NOW)
            {
                symbols.get(hash).status = EMPTY_NOW;
                symbols.get(hash).data = null;
                return;
            }
            if(hash == index)
            {
                throw new ArrayIndexOutOfBoundsException(
                        "the item was not found to delete");
            }
            
            hash += offset;
        }
        throw new ArrayIndexOutOfBoundsException(
                "the item was not found to delete");
    }
    /*
     * returns whether or not a given identifier is in the symbol table
     */
    public boolean inTable(String identifier)
    {
        int hash = hash1(identifier);
        int step = hash2(identifier);
        int index = hash;
        
        while(symbols.get(index).status != EMPTY_ALWAYS)
        {
            if(symbols.get(index).status == FULL && 
                    symbols.get(index).data.equals(identifier))
            {
                return true;
            }
            if(index == hash)
            {
                return false;
            }
            index += step;
        }
        return false;
    }
}
