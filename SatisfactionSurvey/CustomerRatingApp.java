/*
    *CustomerRatingApp.java
    * Date: November 5 2023
    * Samar Khajuria T0071470
    *  This Java application allows users to store and manage the results of a customer satisfaction survey for a company's service.
 * It reads survey records from a text-based data file (rating.txt), displays them, allows users to add new records, and calculates and
 * displays the average customer age and rating. The application terminates when the user enters an exclamation mark ('!') and
 * saves the records to the data file.
 */
package SatisfactionSurvey;

import java.io.IOException;
import java.util.Scanner;

public class CustomerRatingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerRating customerRating = new CustomerRating();
        //Attempt to read existing records from the data file.
        try {
            customerRating.readRecords();
        }catch (IOException e){// Displaying an error msg if the file cannot be read.
            System.out.println("Can't read file! IOException: " + e.getMessage());
        }
        while(true){
            System.out.println("Enter age[integer], followed by ONE [tab] key, then rating[decimal number] (or type ! to exit");
            String input = sc.nextLine();
            //Checking if the user wants to exit the application.
            if (input.equals("!")){
                break;
            }
            //Checking if the input contains both age and rating
            String[] parts = input.split("\t");
            if (parts.length !=2){
                System.out.println("Error. Please enter age and rating separated by a tab");
                continue;
            }
            try {
                int age = Integer.parseInt(parts[0]);
                double rating = Double.parseDouble(parts[1]);
                //Attempt to add a new record.
                customerRating.addRecord(age,rating);
            } catch (NumberFormatException e){
                System.out.println("NumberFormatException: "+e.getMessage());
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array out of bound. You have reached the max amount of records that can be stored" + e.getMessage());
            }
        }
        // Display the most updated list of survey records.
        customerRating.displayRecords();
        //Calculate and display the average age and rating.
        System.out.printf("Average Age: %.2f\n", customerRating.averageAge());
        System.out.printf("Average Rating: %.2f\n", customerRating.averageRating());
        // Save the records back to the data file.
        customerRating.saveRecords();

    }

}
