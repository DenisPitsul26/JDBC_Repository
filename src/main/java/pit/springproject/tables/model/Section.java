package pit.springproject.tables.model;

public class Section {
    private int id;
    private String typeOfSection;

    public Section(int id, String typeOfSection) {
        this.id = id;
        this.typeOfSection = typeOfSection;
    }

    public Section() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfSection() {
        return typeOfSection;
    }

    public void setTypeOfSection(String typeOfSection) {
        this.typeOfSection = typeOfSection;
    }
}
