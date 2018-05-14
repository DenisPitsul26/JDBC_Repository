package pit.springproject.tables.DAO.seller.interfaces;

import pit.springproject.tables.model.GoodsOfTradingPoint;
import pit.springproject.tables.model.Seller;

import java.sql.SQLException;
import java.util.List;

public interface ISellerDAOJDBC {
    public Seller insertSeller(
            Seller seller) throws SQLException;

    public Seller getSeller(int id) throws SQLException;

    public Seller updateSeller(Seller seller) throws SQLException;

    public void deleteSeller(int id) throws SQLException;

    public List<Seller> getAll() throws SQLException;
}
