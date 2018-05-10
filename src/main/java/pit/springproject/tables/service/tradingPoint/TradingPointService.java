package pit.springproject.tables.service.tradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.goods.GoodsDAOJDBC;
import pit.springproject.tables.DAO.tradingPoint.TradingPointDAOJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.service.tradingPoint.interfaces.ITradingPointService;

import java.sql.SQLException;
import java.util.List;

@Service
public class TradingPointService implements ITradingPointService{
    @Autowired
    TradingPointDAOJDBC tradingPointDAOJDBC;

    @Override
    public TradingPoint insertTradingPoint(TradingPoint tradingPoint) {
        return tradingPointDAOJDBC.insertTradingPoint(tradingPoint);
    }

    @Override
    public TradingPoint getTradingPoint(int id) throws SQLException {
        return tradingPointDAOJDBC.getTradingPoint(id);
    }

    @Override
    public TradingPoint updateTradingPoint(TradingPoint tradingPoint) throws SQLException {
        return tradingPointDAOJDBC.updateTradingPoint(tradingPoint);
    }

    @Override
    public void deleteTradingPoint(int id) throws SQLException {
        tradingPointDAOJDBC.deleteTradingPoint(id);
    }

    @Override
    public List<TradingPoint> getAll() throws SQLException {
        return tradingPointDAOJDBC.getAll();
    }
}
