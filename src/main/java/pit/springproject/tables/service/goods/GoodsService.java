package pit.springproject.tables.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.goods.GoodsDAOJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.service.goods.interfaces.IGoodsService;

import java.sql.SQLException;
import java.util.List;

@Service
public class GoodsService implements IGoodsService{
    @Autowired
    GoodsDAOJDBC goodsDAOJDBC;

    @Override
    public Goods insertGoods(Goods goods) {
        return goodsDAOJDBC.insertGoods(goods);
    }

    @Override
    public Goods getGoods(int id) throws SQLException {
        return goodsDAOJDBC.getGoods(id);
    }

    @Override
    public Goods updateGoods(Goods goods) throws SQLException {
        return goodsDAOJDBC.updateGoods(goods);
    }

    @Override
    public void deleteGoods(int id) throws SQLException {
        goodsDAOJDBC.deleteGoods(id);
    }

    @Override
    public List<Goods> getAll() throws SQLException {
        return goodsDAOJDBC.getAll();
    }
}
