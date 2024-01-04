/* Samar Khajuria T00714740
 * COMP 1231 Assignment 2
 * The PasswordLockable interface defines methods for managing the
 * lock state of an object using a password.
 */
package FoodRecords;

public interface PasswordLockable {
     void setPassword(String Password);
     // Sets the password for locking and unlocking an object.
    void lock(String Password);
    // Locks an object using the provided password.
    void unlock(String Password);
    // Unlocks an object using the provided password.
    boolean isLocked();
    //Checks if the object is currently locked.

}
