/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poulproj11;

import java.math.BigInteger;
import java.util.ArrayList;
/**
 *
 * @author marsh
 */
public class SymbolTable {
    static final int EMPTY_ALWAYS=0, FULL=1, EMPTY_NOW=2;
    class Node{
        String data;
        int status;
    }
    ArrayList<String> symbols;
    public SymbolTable(int size)
    {
       symbols = new ArrayList<>();
    }
    /*
     * returns wheter or not a string is a valid java identifier
     */
    static boolean validJavaIdentifier(String identifier)
    {
        //exclude reserved words
        if(identifier.equals("abstract") || identifier.equals("continue") ||
                identifier.equals("for")|| 	identifier.equals("new") ||
                identifier.equals("switch")||identifier.equals("assert")||
                identifier.equals("default")||	identifier.equals("goto")||
                identifier.equals("package")||
                identifier.equals("synchronized")||
                identifier.equals("boolean")||
                identifier.equals("do")|| 	identifier.equals("if")||
                identifier.equals("private")|| 	identifier.equals("this")||
                identifier.equals("break")|| 	identifier.equals("double")||
                identifier.equals("implements")||
                identifier.equals("protected")||
                identifier.equals("throw")||
                identifier.equals("byte")|| 	identifier.equals("else")||
                identifier.equals("import") ||	identifier.equals("public")||
                identifier.equals("throws")|| identifier.equals("case")||
                identifier.equals("enum") || identifier.equals("instanceof")||
                identifier.equals("return") || identifier.equals("transient")||
                identifier.equals("catch")|| 	identifier.equals("extends")||
                identifier.equals("int") || 	identifier.equals("short")||
                identifier.equals("try")||
                identifier.equals("char")|| 	identifier.equals("final")|| 	
                identifier.equals("interface")|| identifier.equals("static")|| 	
                identifier.equals("void")||
                identifier.equals("class")|| 	identifier.equals("finally")||
                identifier.equals("long")|| 	identifier.equals("strictfp")||
                identifier.equals("volatile")||
                identifier.equals("const")|| 	identifier.equals("float")||
                identifier.equals("native")|| 	identifier.equals("super")||
                identifier.equals("while") || identifier.isEmpty())
        {
            return false;
        }
        //checck start of string
        if(!Character.isJavaIdentifierStart(identifier.charAt(0)))
        {
            return false;
        }
        //review the rest of the string
        for(int i=1; i < identifier.length(); i++)
        {
            if(!Character.isJavaIdentifierPart(identifier.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
