package pit.springproject.tables.service.goodsOfTradingPoint.interfaces;

import pit.springproject.tables.model.GoodsOfTradingPoint;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsOfTradingPointService {
    public GoodsOfTradingPoint insertGoodsOfTradingPoint(
            GoodsOfTradingPoint goodsOfTradingPoint);

    public GoodsOfTradingPoint getGoodsOfTradingPoint(int id);

    public GoodsOfTradingPoint updateGoodsOfTradingPoint(
            GoodsOfTradingPoint goodsOfTradingPoint) throws SQLException;

    public GoodsOfTradingPoint deleteGoodsOfTradingPoint(int id) throws SQLException;

    public List<GoodsOfTradingPoint> getAll() throws SQLException;
}
