package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.Provider;
import pit.springproject.tables.service.provider.ProviderService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @RequestMapping("/provider")
    public List<Provider> showProvider() throws SQLException{
        return providerService.getAll();
    }
    @PostMapping("/provider/insert")
    Provider insertProvider(@RequestBody Provider provider) {
        return providerService.insertProvider(provider);
    }

    @GetMapping("/provider/delete")
    void deleteProvider(@RequestParam("id") int id) throws SQLException {
        providerService.deleteProvider(id);
    }
    @GetMapping("/provider/get")
    Provider getProviderById(@RequestParam("id") int id)throws SQLException
    {
        return providerService.getProvider(id);
    }
    @RequestMapping("/provider/update")
    Provider updateProvider(
            @RequestBody Provider provider,
            @RequestParam("id") int id) throws SQLException {
        provider.setId(id);
        return providerService.updateProvider(provider);
    }
}
