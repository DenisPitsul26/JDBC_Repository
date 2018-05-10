package pit.springproject.tables.service.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.seller.SellerDAOJDBC;
import pit.springproject.tables.model.Seller;
import pit.springproject.tables.service.seller.interfaces.ISellerService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SellerService implements ISellerService{

    @Autowired
    SellerDAOJDBC sellerDAOJDBC;

    @Override
    public Seller insertSeller(Seller seller) {
        return null;
    }

    @Override
    public Seller getSeller(int id) {
        return null;
    }

    @Override
    public Seller updateSeller(Seller seller) throws SQLException {
        return null;
    }

    @Override
    public Seller deleteSeller(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Seller> getAll() throws SQLException {
        return sellerDAOJDBC.getAll();
    }
}
