package pit.springproject.tables.model;

public class Goods {
    private int id;
    private String nameOfGoods;

    public Goods(int id, String nameOfGoods) {
        this.id = id;
        this.nameOfGoods = nameOfGoods;
    }

    public Goods() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfGoods() {
        return nameOfGoods;
    }

    public void setNameOfGoods(String nameOfGoods) {
        this.nameOfGoods = nameOfGoods;
    }
}
