package pit.springproject.tables.model;

public class TradingPoint {
    private int id;
    private TypeOfTradingPoint typeOfTradingPoint;
    private String nameOfTradingPoint;
    private int numberOfHalls;
    private int sizeOfTheTradingPoint;
    private double leasePayments;
    private double utilities;
    private int numberOfCounters;

    public TradingPoint(int id, TypeOfTradingPoint typeOfTradingPoint, String nameOfTradingPoint,
                        int numberOfHalls, int sizeOfTheTradingPoint,
                        double leasePayments, double utilities, int numberOfCounters) {
        this.id = id;
        this.typeOfTradingPoint = typeOfTradingPoint;
        this.nameOfTradingPoint = nameOfTradingPoint;
        this.numberOfHalls = numberOfHalls;
        this.sizeOfTheTradingPoint = sizeOfTheTradingPoint;
        this.leasePayments = leasePayments;
        this.utilities = utilities;
        this.numberOfCounters = numberOfCounters;
    }

    public TradingPoint() {
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

    public String getNameOfTradingPoint() {
        return nameOfTradingPoint;
    }

    public void setNameOfTradingPoint(String nameOfTradingPoint) {
        this.nameOfTradingPoint = nameOfTradingPoint;
    }

    public int getNumberOfHalls() {
        return numberOfHalls;
    }

    public void setNumberOfHalls(int numberOfHalls) {
        this.numberOfHalls = numberOfHalls;
    }

    public int getSizeOfTheTradingPoint() {
        return sizeOfTheTradingPoint;
    }

    public void setSizeOfTheTradingPoint(int sizeOfTheTradingPoint) {
        this.sizeOfTheTradingPoint = sizeOfTheTradingPoint;
    }

    public double getLeasePayments() {
        return leasePayments;
    }

    public void setLeasePayments(double leasePayments) {
        this.leasePayments = leasePayments;
    }

    public double getUtilities() {
        return utilities;
    }

    public void setUtilities(double utilities) {
        this.utilities = utilities;
    }

    public int getNumberOfCounters() {
        return numberOfCounters;
    }

    public void setNumberOfCounters(int numberOfCounters) {
        this.numberOfCounters = numberOfCounters;
    }
}
