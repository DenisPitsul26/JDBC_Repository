package pit.springproject.tables.DAO.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.request.interfaces.IRequestDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RequestDAOJDBC implements IRequestDAOJDBC{
    @Autowired
    DataStorageJDBC dataStorage;
    private List<Request> list = new ArrayList<>();

    @Override
    public Request insertRequest(Request request) throws SQLException {
        String query = "INSERT INTO `request` (`number_request`, `trading_point_id`, `provider_id`, " +
                "`goods_id`, `number_of_goods`, `price`, `date_of_request`) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1, request.getNumberRequest());
        statement.setInt(2, request.getTradingPoint().getId());
        statement.setInt(3, request.getProvider().getId());
        statement.setInt(4, request.getGoods().getId());
        statement.setInt(5, request.getNumberOfGoods());
        statement.setDouble(6, request.getPrice());
        statement.setDate(7, java.sql.Date.valueOf(request.getDateOfRequest()));
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return request;
    }

    @Override
    public Request getRequest(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM request " +
                "JOIN provider ON request.provider_id = provider.id " +
                "JOIN goods ON request.goods_id = goods.id " +
                "JOIN trading_point ON request.trading_point_id = trading_point.id " +
                "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                "where request.id = "+id);
        rs.next();
        Request request = new Request(
                rs.getInt("id"),
                rs.getInt("number_request"),
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
                new Provider(
                        rs.getInt("id"),
                        rs.getString("name_of_provider"),
                        rs.getString("phone")
                ),
                new Goods(
                        rs.getInt("id"),
                        rs.getString("name_of_goods")
                ),
                rs.getInt("number_of_goods"),
                rs.getDouble("price"),
                rs.getDate("date_of_request").toLocalDate()
        );
        return request;
    }

    @Override
    public Request updateRequest(Request request) throws SQLException {
        String query = "UPDATE `request` SET `number_request`=?, `trading_point_id`=?, `provider_id`=?,`goods_id`=?, `number_of_goods`=?, `price`=?, `date_of_request`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1, request.getNumberRequest());
        statement.setInt(2, request.getTradingPoint().getId());
        statement.setInt(3, request.getProvider().getId());
        statement.setInt(4, request.getGoods().getId());
        statement.setInt(5, request.getNumberOfGoods());
        statement.setDouble(6, request.getPrice());
        statement.setDate(7, java.sql.Date.valueOf(request.getDateOfRequest()));
        statement.setInt(8, request.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return request;
    }

    @Override
    public void deleteRequest(int id) throws SQLException {
        try {
            String query = "delete from request where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM request JOIN provider ON request.provider_id = provider.id " +
                        "JOIN goods ON request.goods_id = goods.id " +
                        "JOIN trading_point ON request.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                        "ORDER BY request.id");
        while (rs.next()) {
            list.add(new Request(
                            rs.getInt("id"),
                            rs.getInt("number_request"),
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
                            new Provider(
                                    rs.getInt("id"),
                                    rs.getString("name_of_provider"),
                                    rs.getString("phone")
                            ),
                            new Goods(
                                    rs.getInt("id"),
                                    rs.getString("name_of_goods")
                            ),
                            rs.getInt("number_of_goods"),
                            rs.getDouble("price"),
                            rs.getDate("date_of_request").toLocalDate()
                    )
            );
        }
        return list;
    }
}
