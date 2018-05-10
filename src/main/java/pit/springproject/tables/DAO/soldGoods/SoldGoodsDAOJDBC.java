package pit.springproject.tables.DAO.soldGoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.soldGoods.interfaces.ISoldGoodsDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SoldGoodsDAOJDBC implements ISoldGoodsDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<SoldGoods> list = new ArrayList<>();

    @Override
    public SoldGoods insertSoldGoods(SoldGoods soldGoods) {
        return null;
    }

    @Override
    public SoldGoods getSoldGoods(int id) {
        return null;
    }

    @Override
    public SoldGoods updateSoldGoods(SoldGoods soldGoods) throws SQLException {
        return null;
    }

    @Override
    public SoldGoods deleteSoldGoods(int id) throws SQLException {
        return null;
    }

    @Override
    public List<SoldGoods> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM sold_goods JOIN seller ON sold_goods.seller_id = seller.id " +
                        "JOIN buyer ON sold_goods.buyer_id = buyer.id JOIN trading_point ON sold_goods.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON sold_goods.type_of_trading_point_id = type_of_trading_point.id " +
                        "JOIN goods_of_trading_point ON sold_goods.goods_of_trading_point_id = goods_of_trading_point.id " +
                        "JOIN goods ON goods_of_trading_point.goods_id = goods.id " +
                        "ORDER BY sold_goods.id");
        while (rs.next()) {
            list.add(new SoldGoods(
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
                            new Seller(
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
                            ),
                            new Buyer(
                                    rs.getInt("id"),
                                    rs.getString("name_of_buyer")
                            ),
                            new GoodsOfTradingPoint(
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
                            ),
                            rs.getInt("number"),
                            rs.getDate("date_of_sale"),
                            rs.getDouble("price")
                    )
            );
        }
        return list;
    }
}
