/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj11;

import java.util.ArrayList;

/**
 *
 * @author marsh
 */
public class SymbolTable {

    static final int EMPTY_ALWAYS = 0, FULL = 1, EMPTY_NOW = 2, SIZE = 1009, MAX_STEP = 14;

    class Node {

        String data;
        int status;

        public Node() {
            status = EMPTY_ALWAYS;
        }

        public Node(String item) {
            data = item;
            status = FULL;
        }
    }
    ArrayList<Node> symbols;

    public SymbolTable() {
        symbols = new ArrayList<>(SIZE);
    }

    private int hash1(String data) {
        return data.hashCode() % SIZE;
    }

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
                throw new IllegalAccessException("the status of the location is not valid");
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
}
