package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.Seller;
import pit.springproject.tables.service.seller.SellerService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping("/seller")
    public List<Seller> showSeller() throws SQLException {
        return sellerService.getAll();
    }

    @PostMapping("/seller/insert")
    Seller insertSeller(@RequestBody Seller seller) throws SQLException {
        return sellerService.insertSeller(seller);
    }

    @GetMapping("/seller/delete")
    void deleteSeller(@RequestParam("id") int id) throws SQLException
    {
        sellerService.deleteSeller(id);
    }

    @GetMapping("/seller/get")
    Seller getSellerById(@RequestParam("id") int id) throws SQLException {
        return sellerService.getSeller(id);
    }

    @RequestMapping("/seller/update")
    Seller updateSeller(@RequestBody Seller seller, @RequestParam("id") int id)throws SQLException
    {
        seller.setId(id);
        return sellerService.updateSeller(seller);
    }
}
