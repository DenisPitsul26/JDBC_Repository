package pit.springproject.tables.service.provider.interfaces;

import pit.springproject.tables.model.Provider;

import java.sql.SQLException;
import java.util.List;

public interface IProviderService {
    public Provider insertProvider(Provider provider);

    public Provider getProvider(int id) throws SQLException;

    public Provider updateProvider(Provider provider) throws SQLException;

    public void deleteProvider(int id) throws SQLException;

    public List<Provider> getAll() throws SQLException;
}
