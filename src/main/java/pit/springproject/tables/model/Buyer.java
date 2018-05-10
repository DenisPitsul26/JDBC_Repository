package pit.springproject.tables.model;

public class Buyer {
    private int id;
    private String nameOfBuyer;

    public Buyer(int id, String nameOfBuyer) {
        this.id = id;
        this.nameOfBuyer = nameOfBuyer;
    }

    public Buyer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBuyer() {
        return nameOfBuyer;
    }

    public void setNameOfBuyer(String nameOfBuyer) {
        this.nameOfBuyer = nameOfBuyer;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", nameOfBuyer='" + nameOfBuyer + '\'' +
                '}';
    }
}
