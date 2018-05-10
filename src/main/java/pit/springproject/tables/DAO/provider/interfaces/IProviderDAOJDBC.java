package pit.springproject.tables.DAO.provider.interfaces;

import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.Provider;

import java.sql.SQLException;
import java.util.List;

public interface IProviderDAOJDBC {
    public Provider insertProvider(Provider provider);

    public Provider getProvider(int id) throws SQLException;

    public Provider updateProvider(Provider provider) throws SQLException;

    public void deleteProvider(int id) throws SQLException;

    public List<Provider> getAll() throws SQLException;
}
