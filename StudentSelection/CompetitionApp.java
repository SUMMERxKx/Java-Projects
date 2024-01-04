/*
 * Student.java
 * Date: November 17 2023
 * Samar Khajuria T00714740
 * This application demonstrates the use of the Team and Student classes to manage a list of students
 * and select candidates based on their cumulative GPA for a competition.

 */
package StudentSelection;

import java.util.Collection;
import java.util.Collections;

public class CompetitionApp{
    public static void main(String[] args) {
        //Create a team of students
        Team<Student> studentList = new Team<>();
        //Create a standard student
        Student standard = new Student("Standard Student", 3.67);
        //Add students to the team
        studentList.addToTeam(new Student("Gary", 3.66));
        studentList.addToTeam(new Student("Jenny", 4.0));
        studentList.addToTeam(new Student("Patrick", 3.33));
        studentList.addToTeam(new Student("Danny", 3.0));
        studentList.addToTeam(new Student("Priscilla", 4.33));
        studentList.addToTeam(new Student("Betty", 3.12));
        studentList.addToTeam(new Student("June", 3.99));
        studentList.addToTeam(new Student("Nick", 3.67));

        //Print the total list
        System.out.println("The following students want to join the competition team:");
        System.out.println(studentList);

        System.out.println("Total number of students = " + studentList.getNumberOfMembers());
        //Form a candidate list
        Team<Student> candidateList = new Team<>();
        Team<Student> notFulfilledList = new Team<>();
        for (int i = 0; i < studentList.getNumberOfMembers(); i++){
            Student student = studentList.getMembersList().get(i);
            if (student.compareTo(standard)>=0){
                candidateList.addToTeam(student);
            } else {
                notFulfilledList.addToTeam(student);
            }

        }
        //Students who didn't fulfil the requirement
        System.out.println("\nStudents who didn't fulfill the cumulative GPA requirement (3.67):");
        for (Student student : notFulfilledList.getMembersList()){
            System.out.println("Remove: " + student);
        }
        // Remove the last candidate
        try {//try catch block to catch the Index Out of bound exception
            Student removedStudent = candidateList.getMembersList().get(candidateList.getNumberOfMembers() - 1);
            candidateList.removeFromTeam();
            System.out.println();
            //Print the list of members removed
            System.out.println("The following candidate who submitted the application in the last has been removed from the list:");
            System.out.println("Remove: " + removedStudent);
            System.out.println();
        }   catch (IndexOutOfBoundsException e){
            System.out.println("No candidate has been selected!");
        }

        // Print the final list of candidates
        finally {
            System.out.println("\nThe candidates are sorted in a descending order based on their cumulative GPA :");
            Collections.sort(candidateList.getMembersList(), Collections.reverseOrder());
            if (candidateList.hasNoMembers()) {
                System.out.println("No candidate in the lists.");
            } else {
                System.out.println("Final list of candidates");
                System.out.println(candidateList);
            }
        }
    }
}