/*
    *CustomerRating.java
    * Date: November 5 2023
    * Samar Khajuria T00714740
    * This application reads customer information from the file,
    * stores and displays it, lets user add to more users to a certain limit,
    * and display it back to the terminal.

 */
package SatisfactionSurvey;
import java.io.*;
import java.util.Scanner;

public class CustomerRating {
    //attributes
    private static final String file = "rating.txt";
    private static final int maxRecord = 5;
    private Customer[] record = new Customer[maxRecord];
    private int count = 0;
    //Reads customer records from the data file and adds them to the array.
    public void readRecords() throws IOException{
        try (Scanner sc = new Scanner(new File(file))){
            while (sc.hasNextLine() && count < maxRecord) {
                String line = sc.nextLine();
                String[] data = line.split("\t");
                if (data.length == 2) {
                    int age = Integer.parseInt(data[0].trim());
                    double rating = Double.parseDouble(data[1].trim());
                    record[count++] = new Customer(age, rating);
                }
            }
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
            throw e;
        }

    }
    //Displays the customer records on the terminal.
    public void displayRecords() {
        System.out.println("Most updated list of customer ratings");
        System.out.println("------------------------------------------\n");
        System.out.printf(" %-10s %-10s\n", "Age", "Rating\n");
        System.out.println("-------------------------------------------\n");

        for (int i =0;i<maxRecord;i++){
            Customer customer = record[i];
            System.out.printf(" %-10d %-10.2f\n", customer.getAge(), customer.getRating());
        }
    }
    //Adds a new customer record to the array.
    public void addRecord(int age, double rating){
       try {
           if (count < maxRecord) {
               if (age>=0) { // Check if age is non-negative
                   record[count++] = new Customer(age, rating);
               }else {
                   System.out.println("Error. Age cannot be negative.");
               }
           } else {
               throw new ArrayIndexOutOfBoundsException("Array out of bound... Record not added.");

           }
       } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println(e.getMessage());
       }
    }
    //Saves the customer records back to the data file.
    public void saveRecords(){
        try (FileWriter writer = new FileWriter(file)){
            for (int i =0; i<count;i++) {
                Customer customer = record[i];
                writer.write(customer.getAge() + "\t" + customer.getRating() + "\n");
            }
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
    //Calculates the average age of the customer record.
    public double averageAge(){
        int totalAge = 0;
        for (int i = 0;i<count; i++){
            totalAge += record[i].getAge();
        }
        return (double) totalAge/count;
    }
    //Calculates the average rating of the customer record.
    public double averageRating(){
        double totalRating = 0;
        for (int i = 0;i<count; i++){
            totalRating += record[i].getRating();
        }
        return (totalRating/count);
    }


}
