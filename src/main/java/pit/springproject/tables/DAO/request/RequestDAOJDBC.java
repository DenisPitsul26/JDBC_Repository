package pit.springproject.tables.DAO.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.request.interfaces.IRequestDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.*;

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
    public Request insertRequest(Request request) {
        return null;
    }

    @Override
    public Request getRequest(int id) {
        return null;
    }

    @Override
    public Request updateRequest(Request request) throws SQLException {
        return null;
    }

    @Override
    public Request deleteRequest(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Request> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM request JOIN provider ON request.provider_id = provider.id " +
                        "JOIN goods ON request.goods_id = goods.id " +
                        "JOIN trading_point ON request.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON request.type_of_trading_point_id = type_of_trading_point.id " +
                        "ORDER BY request.id");
        while (rs.next()) {
            list.add(new Request(
                            rs.getInt("id"),
                            rs.getInt("number_request"),
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
                            rs.getDate("date_of_request")
                    )
            );
        }
        return list;
    }
}
