package pit.springproject.tables.service.goodsOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.goodsOfTradingPoint.GoodsOfTradingPointDAOJDBC;
import pit.springproject.tables.model.GoodsOfTradingPoint;
import pit.springproject.tables.service.goodsOfTradingPoint.interfaces.IGoodsOfTradingPointService;

import java.sql.SQLException;
import java.util.List;

@Service
public class GoodsOfTradingPointService implements IGoodsOfTradingPointService{

    @Autowired
    GoodsOfTradingPointDAOJDBC goodsOfTradingPointDAOJDBC;

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
        return goodsOfTradingPointDAOJDBC.getAll();
    }
}
