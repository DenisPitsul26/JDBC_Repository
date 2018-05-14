package pit.springproject.tables.DAO.tradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.tradingPoint.interfaces.ITradingPointDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.model.TypeOfTradingPoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TradingPointDAOJDBC implements ITradingPointDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<TradingPoint> list = new ArrayList<>();

    @Override
    public TradingPoint insertTradingPoint(TradingPoint tradingPoint) {
        try {
            String query = "insert into trading_point (id,type_of_trading_point_id,name_of_trading_point,number_of_halls,size_of_the_trading_point,lease_payments,utilities,number_of_counters) values ("
                    +tradingPoint.getId()+","
                    +tradingPoint.getTypeOfTradingPoint().getId()+",'"
                    +tradingPoint.getNameOfTradingPoint()+"',"
                    +tradingPoint.getNumberOfHalls()+","
                    +tradingPoint.getSizeOfTheTradingPoint()+","
                    +tradingPoint.getLeasePayments()+","
                    +tradingPoint.getUtilities()+","
                    +tradingPoint.getNumberOfCounters()+")";
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TradingPoint getTradingPoint(int id) throws SQLException {
        /*//String query = ""
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM trading_point " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                        "where trading_point.id = "+id);
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        TradingPoint tradingPoint = new TradingPoint(
                rs.getInt("id"),
                new TypeOfTradingPoint(
                        rs.getInt("id"),
                        rs.getString("type_of_type_of_trading_point")
                ),
                rs.getString("name_of_trading_point"),
                rs.getInt("number_of_halls"),
                rs.getInt("size_of_the_trading_point"),
                rs.getDouble("lease_payments"),
                rs.getDouble("utilities"),
                rs.getInt("number_of_counters"));
        return tradingPoint;*/
        String query = "SELECT * FROM trading_point JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id where trading_point.id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1,id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        TradingPoint tradingPoint = new TradingPoint(
                rs.getInt("id"),
                new TypeOfTradingPoint(
                        rs.getInt("id"),
                        rs.getString("type_of_type_of_trading_point")
                ),
                rs.getString("name_of_trading_point"),
                rs.getInt("number_of_halls"),
                rs.getInt("size_of_the_trading_point"),
                rs.getDouble("lease_payments"),
                rs.getDouble("utilities"),
                rs.getInt("number_of_counters"));
        return tradingPoint;
    }

    @Override
    public TradingPoint updateTradingPoint(TradingPoint tradingPoint) throws SQLException {
        try {
            String query = "update trading_point set id = "+tradingPoint.getId()+
                    ",type_of_trading_point_id = " + tradingPoint.getTypeOfTradingPoint().getId()+
                    ",name_of_trading_point = '" + tradingPoint.getNameOfTradingPoint()+
                    "',number_of_halls = " + tradingPoint.getNumberOfHalls()+
                    ",size_of_the_trading_point = " + tradingPoint.getSizeOfTheTradingPoint()+
                    ",lease_payments = " + tradingPoint.getLeasePayments()+
                    ",utilities = " + tradingPoint.getUtilities()+
                    ",number_of_counters = " + tradingPoint.getNumberOfCounters()+
                    " where id = "+ tradingPoint.getId();
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void deleteTradingPoint(int id) throws SQLException {
        try {
            String query = "delete from trading_point where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TradingPoint> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM trading_point " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                                "ORDER BY trading_point.id");
        while(rs.next()){
            list.add(new TradingPoint(
                            rs.getInt("id"),
                            new TypeOfTradingPoint(
                                    rs.getInt("id"),
                                    rs.getString("type_of_type_of_trading_point")
                            ),
                            rs.getString("name_of_trading_point"),
                            rs.getInt("number_of_halls"),
                            rs.getInt("size_of_the_trading_point"),
                            rs.getDouble("lease_payments"),
                            rs.getDouble("utilities"),
                            rs.getInt("number_of_counters")
                    )
            );
        }
        return list;
    }
}
