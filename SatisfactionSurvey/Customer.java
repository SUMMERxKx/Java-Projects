package SatisfactionSurvey;
/*Customer.java
 * Date: November 5 2023
 *Samar Khajuria T00714740
    * Storage for the customer attributes.
 */

public class Customer {
    //attributes
    private int age;
    private double rating;
    //constructor
    public Customer(int age,double rating){
        this.age = age;
        this.rating = rating;
    }
    //accessor methods
    public int getAge() {
        return age;
    }

    public double getRating() {
        return rating;
    }


}
