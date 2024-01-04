/* Samar Khajuria T00714740
 * COMP 1231 Assignment 2
 * The Category interface defines constants for food product categories
 * and methods to set and get the category.
 */
package FoodRecords;

public interface Category {
    // Constants for food product categories
    int UNCLASSFIED = 0;
    int Meat = 1;
    int Dairy = 2;
    int Veggie =3;

    void setCategory(int Category);
    // Sets the category
    int getCategory();
    // Gets the category of food product.
}
