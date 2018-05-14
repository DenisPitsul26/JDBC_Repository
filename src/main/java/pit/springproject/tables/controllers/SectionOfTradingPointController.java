package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.SectionOfTradingPoint;
import pit.springproject.tables.service.sectionOfTradingPoint.SectionOfTradingPointService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SectionOfTradingPointController {
    @Autowired
    private SectionOfTradingPointService sectionOfTradingPointService;

    @RequestMapping("/section_of_trading_point")
    public List<SectionOfTradingPoint> showSectionOfTradingPoint() throws SQLException {
        return sectionOfTradingPointService.getAll();
    }

    @PostMapping("/section_of_trading_point/insert")
    SectionOfTradingPoint insertSectionOfTradingPoint(@RequestBody SectionOfTradingPoint sectionOfTradingPoint) throws SQLException {
        return sectionOfTradingPointService.insertSectionOfTradingPoint(sectionOfTradingPoint);
    }

    @GetMapping("/section_of_trading_point/delete")
    void deleteSectionOfTradingPoint(@RequestParam("id") int id) throws SQLException
    {
        sectionOfTradingPointService.deleteSectionOfTradingPoint(id);
    }

    @GetMapping("/section_of_trading_point/get")
    SectionOfTradingPoint getSectionOfTradingPointById(@RequestParam("id") int id)throws SQLException
    {
        return sectionOfTradingPointService.getSectionOfTradingPoint(id);
    }

    @RequestMapping("/section_of_trading_point/update")
    SectionOfTradingPoint updateSectionOfTradingPoint(@RequestBody SectionOfTradingPoint sectionOfTradingPoint, @RequestParam("id") int id)throws SQLException
    {
        sectionOfTradingPoint.setId(id);
        return sectionOfTradingPointService.updateSectionOfTradingPoint(sectionOfTradingPoint);
    }
}
