/* Samar Khajuria T00714740
 * COMP 1231 Assignment 2
 * This is the Driver class of the application to display the results of the program.
 */
package FoodRecords;

public class ProductApp {
    public static void main(String[] args) {
        // Create an array to store Product objects.
        Product[] productList = new Product[4];
        // Initialize Product objects.
        productList[0] = new Product("XOO1","Unknown",0.0,Category.UNCLASSFIED);
        productList[1] = new Product("A001","Chicken",72.45,Category.Meat);
        productList[2] = new Product("B002","Ice Cream",20.0,Category.Dairy);
        productList[3] = new Product("COO3","Bread",6.99,Category.Veggie);

        // Display food product records
        System.out.println("Food product records \n");
        System.out.println(productList[0]);
        System.out.println("-------------");
        System.out.println(productList[1]);
        System.out.println("-------------");
        System.out.println(productList[2]);
        System.out.println("-------------");
        System.out.println(productList[3]);
        System.out.println("-------------");

        System.out.println();

        // Set up password and lock a product
        System.out.println("Setting up password and locking the product: \n");
        productList[0].setPassword("Hello");
        System.out.println("First product: " + productList[0]);
        productList[0].lock("Hello");
        System.out.println();

        // Attempt to update the product when it's locked
        System.out.println("Updating product when it's locked");
        productList[0].setDescription("Fish");
        System.out.println();

        //Attempt to open with a wrong password
        System.out.println("Opening with wrong Password");
        productList[0].unlock("Wrong");
        productList[0].setDescription("It won't work");
        System.out.println();

        // Update a product after unlocking
        System.out.println("Updating product after unlocking");
        productList[0].unlock("Hello");
        productList[0].setProductCode("A2D2");
        productList[0].setDescription("Starfish");
        productList[0].setPrice(9.99);
        productList[0].setCategory(1);
        System.out.println(productList[0]);
        System.out.println();

        // Find products with the lowest prices
        System.out.println("Products with the lowest prices:\n");
        Product lowestPrice = productList[0];

        for (int i = 0; i < productList.length; i++){
            if (productList[i].compareTo(lowestPrice) < 0){
                lowestPrice = productList[i];
            }
        }
        System.out.println("Product with lowest price");
        System.out.println("Product Code: " + lowestPrice.getProductCode());
        System.out.println("Product Description: " + lowestPrice.getDescription());
        System.out.println("Product Price: $ " + lowestPrice.getPrice());
        System.out.println("Product Category: " + lowestPrice.categoryToDescription());

    }

}
