/*
 * Student.java
 * Date: November 17 2023
 * Samar Khajuria T00714740
 * This application has the attributes and uses the comparable interface to
 * compare the GPA of the 2 students.
 */
package StudentSelection;

public class Student implements Comparable<Student> {
    private String name;
    private double cGPA;
    public Student(String name, double cGPA){
        this.name = name;
        this.cGPA = cGPA;
    }

    public String getName() {
        return name;
    }
    public double getcGPA(){
        return cGPA;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.cGPA, other.cGPA);

    }

    @Override
    public String toString() {
        return "Name: " + name + ";" + " Cumulative GPA=" +cGPA  ;
    }
}
