/****
 * Name: Samar Khajuria
 * Student Number: T00714740
 * Assignment Number: 1
 * Program Description: This is the abstract class for the chemical product. It is the parent class of the application
  which checks the density of certain products and determines if it's too thin, too thick or acceptable.
 ****/
package ChemicalCompany;
import java.text.DecimalFormat;
 abstract public class Product {
     private String productId;
     private double productVolCm3;

     //Default Constructor
     public Product(){
                this.productId = "";
                this.productVolCm3 = 0;
     }
     //Parameterized Constructor
     public Product(String productId, double productVolCm3){
         this.productId = productId;
         this.productVolCm3 = productVolCm3;
     }
     //accessor
     public String getProductId() {
         return productId;
     }
     //accessor
     public double getProductVolCm3() {
         return productVolCm3;
     }
     //mutator
     public void setProductId(String productId) {
         this.productId = productId;
     }
     //mutator
     public void setProductVolCm3(double productVolCm3) {
         this.productVolCm3 = productVolCm3;
     }
     public abstract double massToGrams();//abstract method
     public abstract double calculateDensity();//abstract method
     public abstract String checkDensity();//abstract method

     @Override
     public String toString() {
         DecimalFormat df = new DecimalFormat("0.00");//Decimal Formatter to display numbers till 2 decimals.
         return "Product ID: " + productId + "\n Volume (cm3): " + df.format(productVolCm3);//Displays the output text
     }
 }
