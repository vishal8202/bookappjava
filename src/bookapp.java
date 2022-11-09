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
            switch (choice) {
                case 1:
                    System.out.println("Add Books");

                    System.out.println("Enter the Book Name: ");
                    bookName = input.next();
                    System.out.println("Enter the Author Name: ");
                    bookAuthor = input.next();

                    System.out.println("Enter the Books Category: ");
                    bookCategory = input.next();
                    System.out.println("Enter the Books charge per day: ");
                    bookDayCharge = input.nextInt();


                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
                        String sql = "INSERT INTO `books`(`bookname`, `bookauthor`, `bookcategory`, `book_rentprice`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, bookName);
                        stmt.setString(2, bookAuthor);

                        stmt.setString(3, bookCategory);
                        stmt.setInt(4, bookDayCharge);
                        stmt.executeUpdate();


                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                case 2:
                    System.out.println("View all Book");

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                        String sql ="SELECT `bookname`, `bookauthor`,  `bookcategory`, `book_rentprice` FROM `books` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            String fetchBookName = rs.getString("bookname");
                            String fetchBookAuthor = rs.getString("bookauthor");
                            // String fetchBookLanguage = rs.getString("language");
                            String fetchBookCategory = rs.getString("bookcategory");
                            String fetchBookDayCharge = rs.getString("book_rentprice");

                            System.out.println("Book Name: "+fetchBookName);
                            System.out.println("Author : "+fetchBookAuthor);
                            //System.out.println("Book Language : "+fetchBookLanguage);
                            System.out.println("Category: "+fetchBookCategory);
                            System.out.println("Books charge/day : "+fetchBookDayCharge+"\n");


                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }

                    break;