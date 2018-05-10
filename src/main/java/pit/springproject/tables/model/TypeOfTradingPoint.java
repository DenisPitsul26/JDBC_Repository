package pit.springproject.tables.model;

import javax.persistence.*;

public class TypeOfTradingPoint {
    private int id;
    private String typeOfTypeOfTradingPoint;

    public TypeOfTradingPoint(int id, String typeOfTypeOfTradingPoint) {
        this.id = id;
        this.typeOfTypeOfTradingPoint = typeOfTypeOfTradingPoint;
    }

    public TypeOfTradingPoint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfTypeOfTradingPoint() {
        return typeOfTypeOfTradingPoint;
    }

    public void setTypeOfTypeOfTradingPoint(String typeOfTypeOfTradingPoint) {
        this.typeOfTypeOfTradingPoint = typeOfTypeOfTradingPoint;
    }
}
