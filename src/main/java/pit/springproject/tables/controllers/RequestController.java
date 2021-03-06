package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.Request;
import pit.springproject.tables.service.request.RequestService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @RequestMapping("/request")
    public List<Request> showRequest() throws SQLException {
        return requestService.getAll();
    }

    @PostMapping("/request/insert")
    Request insertRequest(@RequestBody Request request) throws SQLException {
        return requestService.insertRequest(request);
    }

    @GetMapping("/request/delete")
    void deleteRequest(@RequestParam("id") int id) throws SQLException
    {
        requestService.deleteRequest(id);
    }

    @GetMapping("/request/get")
    Request getRequestById(@RequestParam("id") int id) throws SQLException {
        return requestService.getRequest(id);
    }

    @RequestMapping("/request/update")
    Request updateRequest(@RequestBody Request request, @RequestParam("id") int id)throws SQLException
    {
        request.setId(id);
        return requestService.updateRequest(request);
    }
}
