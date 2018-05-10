package pit.springproject.tables.DAO.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.goods.interfaces.IGoodsDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Buyer;
import pit.springproject.tables.model.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoodsDAOJDBC implements IGoodsDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<Goods> list = new ArrayList<>();

    @Override
    public Goods insertGoods(Goods goods) {
        try {
            String query = "insert into goods (id,name_of_goods) values ("
                    +goods.getId()+",'"
                    +goods.getNameOfGoods()+"')";
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Goods getGoods(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM goods where id = "+id);
        Goods goods = new Goods(rs.getInt("id"), rs.getString("name_of_goods"));
        return goods;
    }

    @Override
    public Goods updateGoods(Goods goods) throws SQLException {
        try {
            String query = "update goods set id="+goods.getId()+",name_of_goods = '" + goods.getNameOfGoods()+"' where id ="+ goods.getId();
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteGoods(int id) throws SQLException {
        try {
            String query = "delete from goods where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Goods> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM goods");
        while(rs.next()){
            list.add(new Goods(
                            rs.getInt("id"),
                            rs.getString("name_of_goods")
                    )
            );
        }
        return list;
    }
}
