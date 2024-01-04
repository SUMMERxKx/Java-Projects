/****
 * Name: Samar Khajuria
 * Student Number: T00714740
 * Assignment Number: 1
 * Program Description: The purpose of this is to represent the chemical product measured in kilograms.
   and check their density.
 ****/
package ChemicalCompany;
import java.text.DecimalFormat;

public class
    MetricUnit extends Product {
    private double kilogram;
    double density;

    //default constructor
    public MetricUnit(){
        super();
        kilogram = 0;
    }
    //parametrized constructor
    public MetricUnit(String productId,double kilogram,double productVolCm3){
        super(productId,productVolCm3);
        this.kilogram = kilogram;
    }
    //accessor
    public double getKilogram() {
        return kilogram;
    }
    //mutator
    public void setKilogram(double kilogram) {
        this.kilogram = kilogram;
    }

    @Override
    public double massToGrams() {
        return getKilogram() * 1000;
    }

    @Override
    public double calculateDensity() { //method to calculate density
        return massToGrams() / getProductVolCm3();
    }

    @Override
    public String checkDensity() {//method to check density
        if (density < 1.25){
         return "Too thin";
        } else if (density > 1.55) {
            return "Too thick";
        } else{
            return "Acceptable";
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");//formats to displays until 2 decimal places
        return super.toString() + "\n Mass (kg): " + df.format(getKilogram());//displays the output text
    }
}
