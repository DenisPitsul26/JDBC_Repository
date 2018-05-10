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
    public Request insertRequest(Request request) {
        return null;
    }

    @Override
    public Request getRequest(int id) {
        return null;
    }

    @Override
    public Request updateRequest(Request request) throws SQLException {
        return null;
    }

    @Override
    public Request deleteRequest(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Request> getAll() throws SQLException {
        return requestDAOJDBC.getAll();
    }
}
