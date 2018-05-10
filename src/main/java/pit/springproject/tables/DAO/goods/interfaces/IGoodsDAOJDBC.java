package pit.springproject.tables.DAO.goods.interfaces;

import pit.springproject.tables.model.Goods;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsDAOJDBC {
    public Goods insertGoods(Goods goods);

    public Goods getGoods(int id) throws SQLException;

    public Goods updateGoods(Goods goods) throws SQLException;

    public void deleteGoods(int id) throws SQLException;

    public List<Goods> getAll() throws SQLException;
}
