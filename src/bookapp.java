import java.sql.*;
import java.util.Scanner;
public class bookapp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bookDayCharge;
        String bookName, bookAuthor, bookLanguage, bookCategory;

        while (true) {
            System.out.println("Book Management App");
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search a book");
            System.out.println("4. Update a book");
            System.out.println("5. Delete a book");
            System.out.println("6. Search a book starting with a specific letter");
            System.out.println("7. Display total books in each category");
            System.out.println("8. View books in a specific category");
            System.out.println("9. Display the total amount in return date ");
            System.out.println("10. Exit");
            System.out.println("Enter the choice: ");
            int choice = input.nextInt();
        }
    }
}