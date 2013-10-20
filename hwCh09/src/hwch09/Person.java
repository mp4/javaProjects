/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hwch09;

/**
 *
 * @author marsh
 */
public abstract class Person {
    private String name;
    private String address;
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }    
}
class Student extends Person
{
    private int creditsCompleted;
    private int studentId;
    private double gpa;
    private String collegeAddress;

    /**
     * @return the creditsCompleted
     */
    public int getCreditsCompleted() {
        return creditsCompleted;
    }

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @return the collegeAddress
     */
    public String getCollegeAddress() {
        return collegeAddress;
    }

    /**
     * @param collegeAddress the collegeAddress to set
     */
    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }
    
}
class UgradStudent extends Student
{
    private String degree;
    private String major;

    /**
     * @return the degree
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }
    
}