/****
 * Name: Samar Khajuria
 * Student Number: T00714740
 * Assignment Number: 1
 * Program Description: This is the driver class. It creates instances of Products, ImperialUnit and metric unit
 ****/
package ChemicalCompany;
import java.text.DecimalFormat;
public class ProductApp {
    public static void main(String[] args) {

        Product[] productList = new Product[6];//new array

        productList[0] = new ImperialUnit("A1122", 1, 3, 603.33);
        productList[1] = new ImperialUnit("B2468", 2, 32, 400.00);
        productList[2] = new ImperialUnit("C1234", 1, 3, 398.87);

        productList[3] = new MetricUnit("X2345",0.55,411.00);
        productList[4] = new MetricUnit("Y6213",0.90,498.00);
        productList[5] = new MetricUnit("Z1098",0.25,234.50);

        //for each loop to display the products
        for (Product product: productList){
            DecimalFormat df = new DecimalFormat("0.00");// formatting numbers to 2 decimal placessn
            System.out.println(product + "\nDensity: " + df.format(product.calculateDensity()) + "\nDensity Check: " + product.checkDensity());
            System.out.println("---------------------------------");//line to divide the data
        }
    }
}
