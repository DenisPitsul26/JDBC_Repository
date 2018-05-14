package pit.springproject.tables.DAO.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.buyer.interfaces.IBuyerDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Buyer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuyerDAOJDBC implements IBuyerDAOJDBC{
    @Autowired
    DataStorageJDBC dataStorage;
    private List<Buyer> list = new ArrayList<>();


    @Override
    public Buyer insertBuyer(Buyer buyer) {
        try {
            String query = "insert into buyer (id,name_of_buyer) values ("
                    +buyer.getId()+",'"
                    +buyer.getNameOfBuyer()+"')";
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Buyer getBuyer(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM buyer where id = "+id);
        rs.next();
        Buyer buyer = new Buyer(rs.getInt("id"), rs.getString("name_of_buyer"));
        return buyer;
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) throws SQLException {
        try {
            String query = "update buyer set id="+buyer.getId()+",name_of_buyer = '" + buyer.getNameOfBuyer()+"' where id ="+ buyer.getId();
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteBuyer(int id) throws SQLException {
        try {
            String query = "delete from buyer where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Buyer> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM buyer");
        while(rs.next()){
            list.add(new Buyer(
                            rs.getInt("id"),
                            rs.getString("name_of_buyer")
                    )
            );
        }
        return list;
    }
}
