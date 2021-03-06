package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.GoodsOfTradingPoint;
import pit.springproject.tables.service.goodsOfTradingPoint.GoodsOfTradingPointService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GoodsOfTradingPointController {
    @Autowired
    private GoodsOfTradingPointService goodsOfTradingPointService;

    @RequestMapping("/goods_of_trading_point")
    public List<GoodsOfTradingPoint> showGoodsOfTradingPoint() throws SQLException {
        return goodsOfTradingPointService.getAll();
    }

    @PostMapping("/goods_of_trading_point/insert")
    GoodsOfTradingPoint insertGoodsOfTradingPoint(@RequestBody GoodsOfTradingPoint goodsOfTradingPoint) throws SQLException {
        return goodsOfTradingPointService.insertGoodsOfTradingPoint(goodsOfTradingPoint);
    }

    @GetMapping("/goods_of_trading_point/delete")
    void deleteGoodsOfTradingPoint(@RequestParam("id") int id) throws SQLException
    {
        goodsOfTradingPointService.deleteGoodsOfTradingPoint(id);
    }

    @GetMapping("/goods_of_trading_point/get")
    GoodsOfTradingPoint getGoodsOfTradingPointById(@RequestParam("id") int id) throws SQLException {
        return goodsOfTradingPointService.getGoodsOfTradingPoint(id);
    }

    @RequestMapping("/goods_of_trading_point/update")
    GoodsOfTradingPoint updateGoodsOfTradingPoint(@RequestBody GoodsOfTradingPoint goodsOfTradingPoint, @RequestParam("id") int id)throws SQLException
    {
        goodsOfTradingPoint.setId(id);
        return goodsOfTradingPointService.updateGoodsOfTradingPoint(goodsOfTradingPoint);
    }
}
