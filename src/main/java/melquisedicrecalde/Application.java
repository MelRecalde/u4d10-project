package melquisedicrecalde;

import melquisedicrecalde.entities.Book;
import melquisedicrecalde.entities.Catalog;
import melquisedicrecalde.entities.Magazine;
import melquisedicrecalde.enums.Periodicity;

import java.util.Scanner;

public class Application {

    private static Catalog catalog = new Catalog();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add element");
            System.out.println("2. Remove element");
            System.out.println("3. Search by code");
            System.out.println("4. Search by publication year");
            System.out.println("5. Search by author");
            System.out.println("6. Save catalog to disk");
            System.out.println("7. Load catalog from disk");
            System.out.println("8. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    searchByUniqueCode();
                    break;
                case 4:
                    searchByPublicationYear();
                    break;
                case 5:
                    searchByAuthor();
                    break;
                case 6:
                    saveCatalog();
                    break;
                case 7:
                    loadCatalog();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addItem() {
        System.out.println("1. Book");
        System.out.println("2. Magazine");

        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Code: ");
        String code = scanner.nextLine();
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Publication Year: ");
        int publicationYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Page Count: ");
        int pageCount = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.println("Author: ");
            String author = scanner.nextLine();
            System.out.println("Genre: ");
            String genre = scanner.nextLine();

            catalog.addItem(new Book(code, title, publicationYear, pageCount, author, genre));
        } else if (choice == 2) {
            System.out.println("Periodicity (WEEKLY, MONTHLY, HALF-YEAR");
            Periodicity periodicity = Periodicity.valueOf(scanner.nextLine().toUpperCase());

            catalog.addItem(new Magazine(code, title, publicationYear, pageCount, periodicity));
        } else {
            System.out.println("Invalid choice");
        }
    }

    private static void removeItem() {
        System.out.println("Code: ");
        String code = scanner.nextLine();
        catalog.removeItem(code);
    }
}
