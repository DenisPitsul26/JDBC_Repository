package pit.springproject.tables.model;

import java.time.LocalDate;
import java.util.Date;

public class Seller {
    private int id;
    private TradingPoint tradingPoint;
    private String nameOfSeller;
    private double sallary;
    private LocalDate dateStarOfWork;

    public Seller(int id, TradingPoint tradingPoint, String nameOfSeller, double sallary, LocalDate dateStarOfWork) {
        this.id = id;
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

    public LocalDate getDateStarOfWork() {
        return dateStarOfWork;
    }

    public void setDateStarOfWork(LocalDate dateStarOfWork) {
        this.dateStarOfWork = dateStarOfWork;
    }
}
