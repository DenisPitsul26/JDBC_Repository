package pit.springproject.tables.service.soldGoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.soldGoods.SoldGoodsDAOJDBC;
import pit.springproject.tables.model.SoldGoods;
import pit.springproject.tables.service.soldGoods.interfaces.ISoldGoodsService;

import java.sql.SQLException;
import java.util.List;

@Component
public class SoldGoodsService implements ISoldGoodsService{

    @Autowired
    SoldGoodsDAOJDBC soldGoodsDAOJDBC;

    @Override
    public SoldGoods insertSoldGoods(SoldGoods soldGoods) throws SQLException {
        return soldGoodsDAOJDBC.insertSoldGoods(soldGoods);
    }

    @Override
    public SoldGoods getSoldGoods(int id) throws SQLException {
        return soldGoodsDAOJDBC.getSoldGoods(id);
    }

    @Override
    public SoldGoods updateSoldGoods(SoldGoods soldGoods) throws SQLException {
        return soldGoodsDAOJDBC.updateSoldGoods(soldGoods);
    }

    @Override
    public void deleteSoldGoods(int id) throws SQLException {
        soldGoodsDAOJDBC.deleteSoldGoods(id);
    }

    @Override
    public List<SoldGoods> getAll() throws SQLException {
        return soldGoodsDAOJDBC.getAll();
    }
}
