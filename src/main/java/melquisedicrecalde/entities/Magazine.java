package melquisedicrecalde.entities;

import melquisedicrecalde.enums.Periodicity;

public class Magazine extends CatalogItem {
    private Periodicity periodicity;

    public Magazine(String code, String title, int publicationYear, int pageCount, Periodicity periodicity) {
        super(code, title, publicationYear, pageCount);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine {" +
                " periodicity= " + periodicity +
                '}' + super.toString();
    }
}