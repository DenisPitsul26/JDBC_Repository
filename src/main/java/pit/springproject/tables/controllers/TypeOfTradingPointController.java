package pit.springproject.tables.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.TypeOfTradingPoint;
import pit.springproject.tables.service.typeOfTradingPoint.TypeOfTradingPointService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfTradingPointController {
    @Autowired
    TypeOfTradingPointService typeOfTradingPointService;

    @RequestMapping("/type_of_trading_point")
    public List<TypeOfTradingPoint> showTypeOfTradingPoint() throws SQLException {
        return typeOfTradingPointService.getAll();
    }
    @PostMapping("/type_of_trading_point/insert")
    TypeOfTradingPoint insertTypeOfTradingPoint(
            @RequestBody TypeOfTradingPoint typeOfTradingPoint) {
        return typeOfTradingPointService.insertTypeOfTradingPoint(typeOfTradingPoint);
    }
    @GetMapping("/type_of_trading_point/get")
    TypeOfTradingPoint getTypeOfTradingPointById(@RequestParam("id") int id) throws SQLException {
        return typeOfTradingPointService.getTypeOfTradingPoint(id);
    }
    @GetMapping("/type_of_trading_point/delete")
    void deleteTypeOfTradingPoint(@RequestParam("id") int id) throws SQLException {
        typeOfTradingPointService.deleteTypeOfTradingPoint(id);
    }
    @RequestMapping("/type_of_trading_point/update")
    TypeOfTradingPoint updateTypeOfTradingPoint(
            @RequestBody TypeOfTradingPoint typeOfTradingPoint,
            @RequestParam("id") int id) throws SQLException {
        typeOfTradingPoint.setId(id);
        return typeOfTradingPointService.updateTypeOfTradingPoint(typeOfTradingPoint);
    }
}
