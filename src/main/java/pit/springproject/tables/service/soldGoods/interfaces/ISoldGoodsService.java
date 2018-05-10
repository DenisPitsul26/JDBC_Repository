package pit.springproject.tables.service.soldGoods.interfaces;

import pit.springproject.tables.model.SoldGoods;

import java.sql.SQLException;
import java.util.List;

public interface ISoldGoodsService {
    public SoldGoods insertSoldGoods(SoldGoods soldGoods);

    public SoldGoods getSoldGoods(int id);

    public SoldGoods updateSoldGoods(SoldGoods soldGoods) throws SQLException;

    public SoldGoods deleteSoldGoods(int id) throws SQLException;

    public List<SoldGoods> getAll() throws SQLException;
}
