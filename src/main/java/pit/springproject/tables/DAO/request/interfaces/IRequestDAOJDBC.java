package pit.springproject.tables.DAO.request.interfaces;

import pit.springproject.tables.model.Request;

import java.sql.SQLException;
import java.util.List;

public interface IRequestDAOJDBC {
    public Request insertRequest(Request request);

    public Request getRequest(int id);

    public Request updateRequest(Request request) throws SQLException;

    public Request deleteRequest(int id) throws SQLException;

    public List<Request> getAll() throws SQLException;
}
