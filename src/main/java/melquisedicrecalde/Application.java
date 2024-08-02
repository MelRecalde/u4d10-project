package melquisedicrecalde;

import melquisedicrecalde.entities.Book;
import melquisedicrecalde.entities.Catalog;
import melquisedicrecalde.entities.CatalogItem;
import melquisedicrecalde.entities.Magazine;
import melquisedicrecalde.enums.Periodicity;

import java.io.IOException;
import java.util.List;
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
                    searchByCode();
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

    private static void searchByCode() {
        System.out.println("Code: ");
        String code = scanner.nextLine();
        catalog.findByCode(code).ifPresentOrElse(
                item -> System.out.println("Item found: " + item.getTitle()),
                () -> System.out.println("Item not found.")
        );
    }

    private static void searchByPublicationYear() {
        System.out.println("Publication Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        List<CatalogItem> results = catalog.findByPublicationYear(year);
        if (results.isEmpty()) {
            System.out.println("No items found.");
        } else {
            results.forEach(item -> System.out.println("Item found: " + item.getTitle()));
        }
    }

    private static void searchByAuthor() {
        String author = scanner.nextLine();
        List<Book> results = catalog.findByAuthor(author);
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            results.forEach(book -> System.out.println("Book found: " + book.getTitle()));
        }
    }

    private static void saveCatalog() {
        System.out.println("File path: ");
        String filePath = scanner.nextLine();
        try {
            catalog.saveToDisk(filePath);
            System.out.println("Catalog saved successfully.");
        } catch (IOException error) {
            System.out.println("Error saving catalog.");
            error.printStackTrace();
        }
    }

    private static void loadCatalog() {
        System.out.println("File path: ");
        String filePath = scanner.nextLine();
        try {
            catalog.loadFromDisk(filePath);
            System.out.println("Catalog loaded successfully.");
        } catch (IOException | ClassNotFoundException error) {
            System.out.println("Error loading catalog.");
            error.printStackTrace();
        }
    }

}
