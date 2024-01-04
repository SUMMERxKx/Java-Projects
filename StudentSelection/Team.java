/*
 * Student.java
 * Date: November 17 2023
 * Samar Khajuria T00714740
 * This class represents a team and provides methods to manage a list of members.
 */
package StudentSelection;

import java.util.ArrayList;

public class Team <T>{
    //ArrayList to store team members
    private  ArrayList<T> aList;
    //Constructor
    public Team(){
        this.aList = new ArrayList<>();
    }
    // Method to Add a member to the team
    public void addToTeam(T member){
        aList.add(member);
    }
    //Method to remove the last member from the team
    public void removeFromTeam(){
        // Check if the team is not empty before removing
        if (!aList.isEmpty()) {
            aList.remove(aList.size() - 1);
        }
    }
    //Method to remove a specific member from the team
    public void removeFromTeam(T member){
        aList.remove(member);
    }
    // Method to get the number of member in the team
    public int getNumberOfMembers(){
        return aList.size();
    }
    // Method to check if the team has no members
    public  boolean hasNoMembers(){
        return aList.isEmpty();
    }

    public ArrayList<T> getMembersList() {
        return aList;// Directly return the ArrayList
    }
    //Override the toString() method to provide a string representation of the team
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(T member: aList){
            result.append(member.toString()).append("\n");
        }
        return  result.toString();
    }
}
