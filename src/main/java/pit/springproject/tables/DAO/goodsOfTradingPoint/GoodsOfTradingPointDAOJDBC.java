package pit.springproject.tables.DAO.goodsOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.goodsOfTradingPoint.interfaces.IGoodsOfTradingPointDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.GoodsOfTradingPoint;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.model.TypeOfTradingPoint;

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
    public GoodsOfTradingPoint insertGoodsOfTradingPoint(GoodsOfTradingPoint goodsOfTradingPoint) {
        return null;
    }

    @Override
    public GoodsOfTradingPoint getGoodsOfTradingPoint(int id) {
        return null;
    }

    @Override
    public GoodsOfTradingPoint updateGoodsOfTradingPoint(GoodsOfTradingPoint goodsOfTradingPoint) throws SQLException {
        return null;
    }

    @Override
    public GoodsOfTradingPoint deleteGoodsOfTradingPoint(int id) throws SQLException {
        return null;
    }

    @Override
    public List<GoodsOfTradingPoint> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM goods_of_trading_point " +
                        "JOIN goods ON goods_of_trading_point.goods_id = goods.id " +
                        "JOIN trading_point ON goods_of_trading_point.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON goods_of_trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                        "ORDER BY goods_of_trading_point.id");
        while(rs.next()){
            list.add(new GoodsOfTradingPoint(
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
