package pit.springproject.tables.service.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.buyer.BuyerDAOJDBC;
import pit.springproject.tables.model.Buyer;
import pit.springproject.tables.service.buyer.interfaces.IBuyerService;

import java.sql.SQLException;
import java.util.List;

@Service
public class BuyerService implements IBuyerService{

    @Autowired
    BuyerDAOJDBC buyerDAOJDBC;

    @Override
    public Buyer insertBuyer(Buyer buyer) {
        return buyerDAOJDBC.insertBuyer(buyer);
    }

    @Override
    public Buyer getBuyer(int id) throws SQLException {
        System.out.println(buyerDAOJDBC.getBuyer(1));
        return buyerDAOJDBC.getBuyer(id);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) throws SQLException {
        return buyerDAOJDBC.updateBuyer(buyer);
    }

    @Override
    public void deleteBuyer(int id) throws SQLException {
        buyerDAOJDBC.deleteBuyer(id);
    }

    @Override
    public List<Buyer> getAll() throws SQLException {
        return buyerDAOJDBC.getAll();
    }
}
