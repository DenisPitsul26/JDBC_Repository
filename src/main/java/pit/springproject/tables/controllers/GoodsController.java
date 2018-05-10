package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.service.goods.GoodsService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods")
    public List<Goods> showGoods() throws SQLException {
        return goodsService.getAll();
    }
    @PostMapping("/goods/insert")
    Goods insertGoods(@RequestBody Goods goods) {
        return goodsService.insertGoods(goods);
    }
    @GetMapping("/goods/delete")
    void deleteGoods(@RequestParam("id") int id) throws SQLException {
        goodsService.deleteGoods(id);
    }
    @GetMapping("/goods/get")
    Goods getGoodsById(@RequestParam("id") int id)throws SQLException
    {
        return goodsService.getGoods(id);
    }
    @RequestMapping("/goods/update")
    Goods updateGoods(
            @RequestBody Goods goods,
            @RequestParam("id") int id) throws SQLException {
        goods.setId(id);
        return goodsService.updateGoods(goods);
    }
}
