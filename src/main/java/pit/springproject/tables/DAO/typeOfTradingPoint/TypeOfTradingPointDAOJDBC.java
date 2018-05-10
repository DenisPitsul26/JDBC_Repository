package pit.springproject.tables.DAO.typeOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.typeOfTradingPoint.interfaces.ITypeOfTradingPointDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.TypeOfTradingPoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeOfTradingPointDAOJDBC implements ITypeOfTradingPointDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<TypeOfTradingPoint> list = new ArrayList<>();


    @Override
    public TypeOfTradingPoint insertTypeOfTradingPoint(TypeOfTradingPoint typeOfTradingPoint) {
        try {
            String query = "insert into type_of_trading_point (id,type_of_type_of_trading_point) values ("
                    +typeOfTradingPoint.getId()+",'"
                    +typeOfTradingPoint.getTypeOfTypeOfTradingPoint()+"')";
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TypeOfTradingPoint getTypeOfTradingPoint(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM type_of_trading_point where id = "+id);
        rs.next();
        TypeOfTradingPoint typeOfTradingPoint = new TypeOfTradingPoint(
                rs.getInt("id"), rs.getString("type_of_type_of_trading_point"));
        return typeOfTradingPoint;
    }

    @Override
    public TypeOfTradingPoint updateTypeOfTradingPoint(TypeOfTradingPoint typeOfTradingPoint) throws SQLException {
        try {
            String query = "update type_of_trading_point set id="+typeOfTradingPoint.getId()+
                    ",type_of_type_of_trading_point = '"+ typeOfTradingPoint.getTypeOfTypeOfTradingPoint()+
                    "' where id ="+ typeOfTradingPoint.getId();
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteTypeOfTradingPoint(int id) throws SQLException {
        try {
            String query = "delete from type_of_trading_point where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TypeOfTradingPoint> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM type_of_trading_point");
        while(rs.next()){
            list.add(new TypeOfTradingPoint(
                            rs.getInt("id"),
                            rs.getString("type_of_type_of_trading_point")
                    )
            );
        }
        return list;
    }
}
