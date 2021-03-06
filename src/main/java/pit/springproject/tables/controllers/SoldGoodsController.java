package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.SoldGoods;
import pit.springproject.tables.service.soldGoods.SoldGoodsService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SoldGoodsController {
    @Autowired
    private SoldGoodsService soldGoodsService;

    @RequestMapping("/sold_goods")
    public List<SoldGoods> showSoldGoods() throws SQLException {
        return soldGoodsService.getAll();
    }

    @PostMapping("/sold_goods/insert")
    SoldGoods insertSoldGoods(@RequestBody SoldGoods soldGoods) throws SQLException {
        return soldGoodsService.insertSoldGoods(soldGoods);
    }

    @GetMapping("/sold_goods/delete")
    void deleteSoldGoods(@RequestParam("id") int id) throws SQLException
    {
        soldGoodsService.deleteSoldGoods(id);
    }

    @GetMapping("/sold_goods/get")
    SoldGoods getSoldGoodsById(@RequestParam("id") int id) throws SQLException {
        return soldGoodsService.getSoldGoods(id);
    }

    @RequestMapping("/sold_goods/update")
    SoldGoods updateSoldGoods(@RequestBody SoldGoods soldGoods, @RequestParam("id") int id)throws SQLException
    {
        soldGoods.setId(id);
        return soldGoodsService.updateSoldGoods(soldGoods);
    }
}
