package melquisedicrecalde.entities;

public abstract class CatalogItem {
    private String code;
    private String title;
    private int publicationYear;
    private int pageCount;

    public CatalogItem(String code, String title, int publicationYear, int pageCount) {
        this.code = code;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
