package pit.springproject.tables.DAO.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.provider.interfaces.IProviderDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Provider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderDAOJDBC implements IProviderDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorageJDBC;
    private List<Provider> list = new ArrayList<>();

    @Override
    public Provider insertProvider(Provider provider) {
        try {
            String query = "insert into provider (id, name_of_provider, phone) values ("
                            +provider.getId()+",'"
                            +provider.getNameOfProvider()+"','"
                            +provider.getPhone()+"')";
            dataStorageJDBC.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Provider getProvider(int id) throws SQLException{
        ResultSet rs = dataStorageJDBC.executeQuery("SELECT * FROM provider where id = "+id);
        rs.next();
        Provider provider = new Provider(
                rs.getInt("id"),
                rs.getString("name_of_provider"),
                rs.getString("phone"));
        return provider;
    }

    @Override
    public Provider updateProvider(Provider provider) throws SQLException {
        try {
            String query = "update provider set id="+provider.getId()+
                    ",name_of_provider = '" + provider.getNameOfProvider()+
                    "',phone = '" + provider.getPhone()+
                    "' where id ="+ provider.getId();
            dataStorageJDBC.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteProvider(int id) throws SQLException {
        try {
            String query = "delete from provider where id = "+ id;
            dataStorageJDBC.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Provider> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorageJDBC.executeQuery("SELECT * FROM provider");
        while (rs.next()){
            list.add(new Provider(
                            rs.getInt("id"),
                            rs.getString("name_of_provider"),
                            rs.getString("phone")
                    )
            );
        }
        return list;
    }
}
