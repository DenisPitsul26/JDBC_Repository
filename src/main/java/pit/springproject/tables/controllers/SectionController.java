package pit.springproject.tables.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.springproject.tables.model.Section;
import pit.springproject.tables.service.section.SectionService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @RequestMapping("/section")
    public List<Section> showSection() throws SQLException {
        return sectionService.getAll();
    }
    @PostMapping("/section/insert")
    Section insertSection(@RequestBody Section section) {
        return sectionService.insertSection(section);
    }

    @GetMapping("/section/delete")
    void deleteSection(@RequestParam("id") int id) throws SQLException {
        sectionService.deleteSection(id);
    }
    @GetMapping("/section/get")
    Section getSectionById(@RequestParam("id") int id)throws SQLException
    {
        return sectionService.getSection(id);
    }
    @RequestMapping("/section/update")
    Section updateSection(
            @RequestBody Section section,
            @RequestParam("id") int id) throws SQLException {
        section.setId(id);
        return sectionService.updateSection(section);
    }
}
