package pit.springproject.tables.model;

public class GoodsOfTradingPoint {
    private int id;
    private TradingPoint tradingPoint;
    private Goods goods;
    private double price;
    private int numberOfGoods;

    public GoodsOfTradingPoint(int id, TradingPoint tradingPoint, Goods goods, double price, int numberOfGoods) {
        this.id = id;
        this.tradingPoint = tradingPoint;
        this.goods = goods;
        this.price = price;
        this.numberOfGoods = numberOfGoods;
    }

    public GoodsOfTradingPoint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TradingPoint getTradingPoint() {
        return tradingPoint;
    }

    public void setTradingPoint(TradingPoint tradingPoint) {
        this.tradingPoint = tradingPoint;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(int numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }
}
