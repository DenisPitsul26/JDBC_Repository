package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.service.tradingPoint.TradingPointService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TradingPointController {
    @Autowired
    private TradingPointService tradingPointService;

    @RequestMapping("/trading_point")
    public List<TradingPoint> showTradingPoint() throws SQLException{
        return tradingPointService.getAll();
    }

    @PostMapping("/trading_point/insert")
    TradingPoint insertTradingPoint(@RequestBody TradingPoint tradingPoint) {
        return tradingPointService.insertTradingPoint(tradingPoint);
    }

    @GetMapping("/trading_point/delete")
    void deleteTradingPoint(@RequestParam("id") int id) throws SQLException
    {
        tradingPointService.deleteTradingPoint(id);
    }

    @GetMapping("/trading_point/get")
    TradingPoint getTradingPointById(@RequestParam("id") int id)throws SQLException
    {
        return tradingPointService.getTradingPoint(id);
    }

    @RequestMapping("/trading_point/update")
    TradingPoint updateTradingPoint(@RequestBody TradingPoint tradingPoint, @RequestParam("id") int id)throws SQLException
    {
        tradingPoint.setId(id);
        return tradingPointService.updateTradingPoint(tradingPoint);
    }
}
