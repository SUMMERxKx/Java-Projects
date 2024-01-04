/* Samar Khajuria T00714740
 * COMP 1231 Assignment 2
 * This application keeps records of different products of different categories
 * and requires password access for any kind of change to the products. It
 * is also capable of getting the product with the lowest price.
 */
package FoodRecords;

public class Product implements Category,PasswordLockable,Comparable<Product> {
    private String productCode;
    private String description;
    private double price;
    private int category;
    private String password;
    private boolean productIsLocked;

    // Constructor
    public Product(String productCode, String description, double price, int category) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
        this.category = category;
        this.password = "";
        this.productIsLocked = false;
    }
    //accessor and mutator methods
    public String getProductCode() {
        return productCode;
    }
    // sets the product code if it's not locked.
    public void setProductCode(String productCode) {
        if (!productIsLocked){
            this.productCode = productCode;
        }
        else {
            System.out.println("Record is locked ...no update performed. ");
        }
    }
    public String getDescription(){
        return description;
    }
    // sets the product description if it's not locked.
    public void setDescription(String description){
        if (!productIsLocked){
            this.description = description;
        }
        else {
            System.out.println("Record is locked ...no update performed. ");
        }
    }

    public double getPrice() {
        return price;
    }
    //sets the product price if it's not locked.
    public void setPrice(double price) {
        if (!productIsLocked) {
            this.price = price;
        }
        else {
            System.out.println("Record is locked ...no update performed. ");
        }
    }

    @Override
    public int getCategory() {
        return category;
    }
    //sets the product category if it's not locked.
    @Override
    public void setCategory(int category) {
        if (!productIsLocked) {
            this.category = category;
        }
        else {
            System.out.println("Record is locked ...no update performed. ");
        }
    }
    // Converts the category number to text description.
    public String categoryToDescription() {
        switch (category) {
            case UNCLASSFIED:
                return "Unclassified";
            case Meat:
                return "Meat";
            case Dairy:
                return "Dairy";
            case Veggie:
                return "Veggie";
            default:
                return "Does not fall in any category";
        }
    }
    // Lock and unlock the product if the provided password matches the stored password.
    @Override
    public void setPassword(String password) {// setting password
        this.password = password;
    }

    @Override
    public void lock(String Password) {
        if (this.password.equals(Password)){// lock
            productIsLocked = true;
        }
        else {
            System.out.println("Wrong Password. Record remains locked");
        }
    }

    @Override
    public void unlock(String Password) { // unlock
        if (this.password.equals(Password)){
            productIsLocked = false;
        }
        else {
            System.out.println("Wrong Password. Records remains unlocked");
        }
    }

    @Override
    public boolean isLocked() { // checks if its locked
        return productIsLocked;
    }

    // Compares this product with another product based on their prices.
    @Override
    public int compareTo(Product Product2) {
        return Double.compare(this.price,Product2.price);
    }
    // String representation of the product.
    @Override
    public String toString() {
        return "Product Code: " + productCode +
                "\nDescription: " + description +
                "\nPrice: $ " + price +
                "\nCategory: " + categoryToDescription();
    }
}

