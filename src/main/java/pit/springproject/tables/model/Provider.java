package pit.springproject.tables.model;

public class Provider {
    private int id;
    private String nameOfProvider;
    private String phone;

    public Provider(int id, String nameOfProvider, String phone) {
        this.id = id;
        this.nameOfProvider = nameOfProvider;
        this.phone = phone;
    }

    public Provider() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfProvider() {
        return nameOfProvider;
    }

    public void setNameOfProvider(String nameOfProvider) {
        this.nameOfProvider = nameOfProvider;
    }
}
