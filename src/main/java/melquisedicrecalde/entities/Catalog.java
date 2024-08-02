package melquisedicrecalde.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalog {
    private List<CatalogItem> items;

    public Catalog() {
        this.items = new ArrayList<>();
    }

    // 1&2. METHODS add and remove
    public void addItem(CatalogItem item) {
        items.add(item);
    }

    public void removeItem(String code) {
        items.removeIf(item -> item.getCode().equals(code));
    }

    // 3. research by code
    public Optional<CatalogItem> findByCode(String code) {
        return items.stream()
                .filter(item -> item.getCode().equals(code))
                .findFirst();
    }

    // 4. research by pub. year
    public List<CatalogItem> findByPublicationYear(int year) {
        return items.stream()
                .filter(item -> item.getPublicationYear() == year)
                .toList();
    }

    // 5. research by author
    public List<Book> findByAuthor(String author) {
        return items.stream()
                .filter(item -> item instanceof Book && ((Book) item)
                        .getAuthor().equalsIgnoreCase(author))
                .map(item -> (Book) item)
                .toList();
    }

    // 6&7. save and load to disk
    public void saveToDisk(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromDisk(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            items = (List<CatalogItem>) ois.readObject();
        }
    }
}
