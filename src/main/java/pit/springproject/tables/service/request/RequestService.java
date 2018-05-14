package pit.springproject.tables.service.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.request.RequestDAOJDBC;
import pit.springproject.tables.model.Request;
import pit.springproject.tables.service.request.interfaces.IRequestService;

import java.sql.SQLException;
import java.util.List;

@Service
public class RequestService implements IRequestService{

    @Autowired
    RequestDAOJDBC requestDAOJDBC;

    @Override
    public Request insertRequest(Request request) throws SQLException {
        return requestDAOJDBC.insertRequest(request);
    }

    @Override
    public Request getRequest(int id) throws SQLException {
        return requestDAOJDBC.getRequest(id);
    }

    @Override
    public Request updateRequest(Request request) throws SQLException {
        return requestDAOJDBC.updateRequest(request);
    }

    @Override
    public void deleteRequest(int id) throws SQLException {
        requestDAOJDBC.deleteRequest(id);
    }

    @Override
    public List<Request> getAll() throws SQLException {
        return requestDAOJDBC.getAll();
    }
}
