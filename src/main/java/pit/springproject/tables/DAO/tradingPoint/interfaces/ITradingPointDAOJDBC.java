package pit.springproject.tables.DAO.tradingPoint.interfaces;

import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.TradingPoint;

import java.sql.SQLException;
import java.util.List;

public interface ITradingPointDAOJDBC {
    public TradingPoint insertTradingPoint(TradingPoint tradingPoint);

    public TradingPoint getTradingPoint(int id) throws SQLException;

    public TradingPoint updateTradingPoint(TradingPoint tradingPoint) throws SQLException;

    public void deleteTradingPoint(int id) throws SQLException;

    public List<TradingPoint> getAll() throws SQLException;
}
