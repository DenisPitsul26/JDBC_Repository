package pit.springproject.tables.service.typeOfTradingPoint.interfaces;

import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.TypeOfTradingPoint;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfTradingPointService {
    public TypeOfTradingPoint insertTypeOfTradingPoint(
            TypeOfTradingPoint typeOfTradingPoint);

    public TypeOfTradingPoint getTypeOfTradingPoint(int id) throws SQLException;

    public TypeOfTradingPoint updateTypeOfTradingPoint(
            TypeOfTradingPoint typeOfTradingPoint) throws SQLException;

    public void deleteTypeOfTradingPoint(int id) throws SQLException;

    public List<TypeOfTradingPoint> getAll() throws SQLException;
}
