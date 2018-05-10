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
        return soldGoodsDAOJDBC.getAll();
    }
}
