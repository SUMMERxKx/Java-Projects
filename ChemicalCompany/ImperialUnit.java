/****
 * Name: Samar Khajuria
 * Student Number: T00714740
 * Assignment Number: 1
 * Program Description: This class represents the chemical products measured in pounds and ounces and volume in cm3
  to check the density of the products.
 ****/
package ChemicalCompany;
import java.text.DecimalFormat;
public class ImperialUnit extends Product{
    private double pound;
    private double ounce;
    double density;

    //default constructor
    public ImperialUnit(){
        super();
        pound = 0.0;
        ounce = 0.0;
    }
    // parameterized constructor
    public ImperialUnit(String productId, double pound, double ounce, double productVolCm3 ){
        super(productId, productVolCm3);
        this.pound = pound;
        this.ounce = ounce;
    }
    //accessor
    public double getPound(){
        return pound;
    }
    //accessor
    public double getOunce(){
        return ounce;
    }
    //mutator
    public void setPound(double pound) {
        this.pound = pound;
    }
    //mutator
    public void setOunce(double ounce) {
        this.ounce = ounce;
    }

    @Override
    public double massToGrams() {
        return getPound() * 16 + getOunce() * 28.35;
    }

    @Override
    public double calculateDensity() {//method to calculate density
        return massToGrams() / getProductVolCm3();
    }
    //method that checks density
    @Override
    public String checkDensity(){
     density = calculateDensity();
     if(density < 1.25){
         return "Too thin";
     }else if (density > 1.55){
         return "Too thick";
     }else {
         return "Acceptable";
     }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");// format numbers to 2 decimal places
        //displays the output text
        return super.toString() + "\n Mass (lb/oz): " + df.format(getPound()) + " lb " + df.format(getOunce()) + " oz" ;
    }
}
