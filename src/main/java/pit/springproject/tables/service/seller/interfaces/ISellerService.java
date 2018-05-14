package pit.springproject.tables.service.seller.interfaces;

import pit.springproject.tables.model.Seller;

import java.sql.SQLException;
import java.util.List;

public interface ISellerService {
    public Seller insertSeller(
            Seller seller) throws SQLException;

    public Seller getSeller(int id) throws SQLException;

    public Seller updateSeller(Seller seller) throws SQLException;

    public void deleteSeller(int id) throws SQLException;

    public List<Seller> getAll() throws SQLException;
}
