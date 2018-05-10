package pit.springproject.tables.model;

import java.util.Date;

public class Seller {
    private int id;
    private TypeOfTradingPoint typeOfTradingPoint;
    private TradingPoint tradingPoint;
    private String nameOfSeller;
    private double sallary;
    private Date dateStarOfWork;

    public Seller(int id, TypeOfTradingPoint typeOfTradingPoint,
                  TradingPoint tradingPoint, String nameOfSeller, double sallary,
                  Date dateStarOfWork) {
        this.id = id;
        this.typeOfTradingPoint = typeOfTradingPoint;
        this.tradingPoint = tradingPoint;
        this.nameOfSeller = nameOfSeller;
        this.sallary = sallary;
        this.dateStarOfWork = dateStarOfWork;
    }

    public Seller() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeOfTradingPoint getTypeOfTradingPoint() {
        return typeOfTradingPoint;
    }

    public void setTypeOfTradingPoint(TypeOfTradingPoint typeOfTradingPoint) {
        this.typeOfTradingPoint = typeOfTradingPoint;
    }

    public TradingPoint getTradingPoint() {
        return tradingPoint;
    }

    public void setTradingPoint(TradingPoint tradingPoint) {
        this.tradingPoint = tradingPoint;
    }

    public String getNameOfSeller() {
        return nameOfSeller;
    }

    public void setNameOfSeller(String nameOfSeller) {
        this.nameOfSeller = nameOfSeller;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public Date getDateStarOfWork() {
        return dateStarOfWork;
    }

    public void setDateStarOfWork(Date dateStarOfWork) {
        this.dateStarOfWork = dateStarOfWork;
    }
}