package pit.springproject.tables.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.provider.ProviderDAOJDBC;
import pit.springproject.tables.model.Provider;
import pit.springproject.tables.service.provider.interfaces.IProviderService;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProviderService implements IProviderService{

    @Autowired
    ProviderDAOJDBC providerDAOJDBC;

    @Override
    public Provider insertProvider(Provider provider) {
        return providerDAOJDBC.insertProvider(provider);
    }

    @Override
    public Provider getProvider(int id) throws SQLException {
        return providerDAOJDBC.getProvider(id);
    }

    @Override
    public Provider updateProvider(Provider provider) throws SQLException {
        return providerDAOJDBC.updateProvider(provider);
    }

    @Override
    public void deleteProvider(int id) throws SQLException {
        providerDAOJDBC.deleteProvider(id);
    }

    @Override
    public List<Provider> getAll() throws SQLException {
        return providerDAOJDBC.getAll();
    }
}
