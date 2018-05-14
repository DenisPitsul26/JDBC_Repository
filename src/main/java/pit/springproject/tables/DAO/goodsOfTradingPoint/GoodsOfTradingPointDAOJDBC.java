package pit.springproject.tables.DAO.goodsOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.goodsOfTradingPoint.interfaces.IGoodsOfTradingPointDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.GoodsOfTradingPoint;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.model.TypeOfTradingPoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoodsOfTradingPointDAOJDBC implements IGoodsOfTradingPointDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<GoodsOfTradingPoint> list = new ArrayList<>();

    @Override
    public GoodsOfTradingPoint insertGoodsOfTradingPoint(GoodsOfTradingPoint goodsOfTradingPoint) throws SQLException {
        String query = "INSERT INTO `goods_of_trading_point` (`trading_point_id`, `goods_id`, `price`, `number_of_goods`) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1, goodsOfTradingPoint.getTradingPoint().getId());
        statement.setInt(2, goodsOfTradingPoint.getGoods().getId());
        statement.setDouble(3, goodsOfTradingPoint.getPrice());
        statement.setInt(4, goodsOfTradingPoint.getNumberOfGoods());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return goodsOfTradingPoint;
    }

    @Override
    public GoodsOfTradingPoint getGoodsOfTradingPoint(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM goods_of_trading_point " +
                "JOIN goods ON goods_of_trading_point.goods_id = goods.id " +
                "JOIN trading_point ON goods_of_trading_point.trading_point_id = trading_point.id " +
                "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                "where goods_of_trading_point.id = "+id);
        rs.next();
        GoodsOfTradingPoint goodsOfTradingPoint = new GoodsOfTradingPoint(
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
                new Goods(
                        rs.getInt("id"),
                        rs.getString("name_of_goods")
                ),
                rs.getDouble("price"),
                rs.getInt("number_of_goods")
        );
        return goodsOfTradingPoint;
    }

    @Override
    public GoodsOfTradingPoint updateGoodsOfTradingPoint(GoodsOfTradingPoint goodsOfTradingPoint) throws SQLException {
        String query = "UPDATE `goods_of_trading_point` SET `trading_point_id`=?, `goods_id`=?, `price`=?, `number_of_goods`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1,goodsOfTradingPoint.getTradingPoint().getId());
        statement.setInt(2,goodsOfTradingPoint.getGoods().getId());
        statement.setDouble(3,goodsOfTradingPoint.getPrice());
        statement.setInt(4,goodsOfTradingPoint.getNumberOfGoods());
        statement.setInt(5,goodsOfTradingPoint.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return goodsOfTradingPoint;
    }

    @Override
    public void deleteGoodsOfTradingPoint(int id) throws SQLException {
        try {
            String query = "delete from goods_of_trading_point where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GoodsOfTradingPoint> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM goods_of_trading_point " +
                        "JOIN goods ON goods_of_trading_point.goods_id = goods.id " +
                        "JOIN trading_point ON goods_of_trading_point.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                        "ORDER BY goods_of_trading_point.id");
        while(rs.next()){
            list.add(new GoodsOfTradingPoint(
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
                            new Goods(
                                    rs.getInt("id"),
                                    rs.getString("name_of_goods")
                            ),
                            rs.getDouble("price"),
                            rs.getInt("number_of_goods")
                    )
            );
        }
        return list;
    }
}
