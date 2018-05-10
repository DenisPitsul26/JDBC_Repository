package pit.springproject.tables.service.typeOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.typeOfTradingPoint.TypeOfTradingPointDAOJDBC;
import pit.springproject.tables.model.TypeOfTradingPoint;
import pit.springproject.tables.service.typeOfTradingPoint.interfaces.ITypeOfTradingPointService;

import java.sql.SQLException;
import java.util.List;

@Service
public class TypeOfTradingPointService implements ITypeOfTradingPointService{
    @Autowired
    TypeOfTradingPointDAOJDBC typeOfTradingPointDAOJDBC;

    @Override
    public TypeOfTradingPoint insertTypeOfTradingPoint(
            TypeOfTradingPoint typeOfTradingPoint) {
        return typeOfTradingPointDAOJDBC.insertTypeOfTradingPoint(typeOfTradingPoint);
    }

    @Override
    public TypeOfTradingPoint getTypeOfTradingPoint(int id) throws SQLException {
        return typeOfTradingPointDAOJDBC.getTypeOfTradingPoint(id);
    }

    @Override
    public TypeOfTradingPoint updateTypeOfTradingPoint(TypeOfTradingPoint typeOfTradingPoint) throws SQLException {
        return typeOfTradingPointDAOJDBC.updateTypeOfTradingPoint(typeOfTradingPoint);
    }

    @Override
    public void deleteTypeOfTradingPoint(int id) throws SQLException {
        typeOfTradingPointDAOJDBC.deleteTypeOfTradingPoint(id);
    }

    @Override
    public List<TypeOfTradingPoint> getAll() throws SQLException {
        return typeOfTradingPointDAOJDBC.getAll();
    }
}
