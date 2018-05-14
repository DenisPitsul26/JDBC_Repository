package pit.springproject.tables.service.request.interfaces;

import pit.springproject.tables.model.Request;

import java.sql.SQLException;
import java.util.List;

public interface IRequestService {
    public Request insertRequest(Request request) throws SQLException;

    public Request getRequest(int id) throws SQLException;

    public Request updateRequest(Request request) throws SQLException;

    public void deleteRequest(int id) throws SQLException;

    public List<Request> getAll() throws SQLException;
}
