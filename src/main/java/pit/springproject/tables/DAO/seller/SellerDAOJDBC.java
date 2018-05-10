package pit.springproject.tables.DAO.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.seller.interfaces.ISellerDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SellerDAOJDBC implements ISellerDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<Seller> list = new ArrayList<>();

    @Override
    public Seller insertSeller(Seller seller) {
        return null;
    }

    @Override
    public Seller getSeller(int id) {
        return null;
    }

    @Override
    public Seller updateSeller(Seller seller) throws SQLException {
        return null;
    }

    @Override
    public Seller deleteSeller(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM seller " +
                        "JOIN trading_point ON seller.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON seller.type_of_trading_point_id = type_of_trading_point.id"
        );
        while(rs.next()){
            list.add(new Seller(
                            rs.getInt("id"),
                            new TypeOfTradingPoint(
                                    rs.getInt("id"),
                                    rs.getString("type_of_type_of_trading_point")
                            ),
                            new TradingPoint(
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
                            ),
                            rs.getString("name_of_seller"),
                            rs.getDouble("sallary"),
                            rs.getDate("date_start_of_work")
                    )
            );
        }
        return list;
    }
}
