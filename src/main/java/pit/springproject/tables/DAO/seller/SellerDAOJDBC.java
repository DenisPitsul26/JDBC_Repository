package pit.springproject.tables.DAO.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.seller.interfaces.ISellerDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
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
    public Seller insertSeller(Seller seller) throws SQLException {
        /*try {
            String query = "insert into seller (id, trading_point_id, name_of_seller, sallary, date_start_of_work) values ("
                    +seller.getId()+","
                    +seller.getTradingPoint().getId()+",'"
                    +seller.getNameOfSeller()+"',"
                    +seller.getSallary()+",'"
                    +seller.getDateStarOfWork()+"')";
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
        String query = "INSERT INTO `seller` (`trading_point_id`, `name_of_seller`, `sallary`, `date_start_of_work`) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1,seller.getTradingPoint().getId());
        statement.setString(2,seller.getNameOfSeller());
        statement.setDouble(3,seller.getSallary());
        statement.setDate(4, java.sql.Date.valueOf(seller.getDateStarOfWork()));
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return seller;
    }

    @Override
    public Seller getSeller(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM seller " +
                        "JOIN trading_point ON seller.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id "+
                        "where id = "+id);
        rs.next();
        Seller seller = new Seller(
                rs.getInt("id"),
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
                rs.getDate("date_start_of_work").toLocalDate());
        return seller;
    }

    @Override
    public Seller updateSeller(Seller seller) throws SQLException {
        String query = "UPDATE `seller` SET `trading_point_id`=?, `name_of_seller`=?, `sallary`=?, `date_start_of_work`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1,seller.getTradingPoint().getId());
        statement.setString(2,seller.getNameOfSeller());
        statement.setDouble(3,seller.getSallary());
        statement.setDate(4,java.sql.Date.valueOf(seller.getDateStarOfWork()));
        statement.setInt(5,seller.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return seller;
    }

    @Override
    public void deleteSeller(int id) throws SQLException {
        try {
            String query = "delete from seller where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM seller " +
                        "JOIN trading_point ON seller.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id "+
                                "order by seller.id"
        );
        while(rs.next()){
            list.add(new Seller(
                            rs.getInt("id"),
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
                            rs.getDate("date_start_of_work").toLocalDate()
                    )
            );
        }
        return list;
    }
}
