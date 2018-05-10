package pit.springproject.tables.service.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.section.SectionDAOJDBC;
import pit.springproject.tables.model.Section;
import pit.springproject.tables.service.section.interfaces.ISectionService;

import java.sql.SQLException;
import java.util.List;


@Service
public class SectionService implements ISectionService{

    @Autowired
    SectionDAOJDBC sectionDAOJDBC;

    @Override
    public Section insertSection(Section section) {
        return sectionDAOJDBC.insertSection(section);
    }

    @Override
    public Section getSection(int id) throws SQLException {
        return sectionDAOJDBC.getSection(id);
    }

    @Override
    public Section updateSection(Section section) throws SQLException {
        return sectionDAOJDBC.updateSection(section);
    }

    @Override
    public void deleteSection(int id) throws SQLException {
        sectionDAOJDBC.deleteSection(id);
    }

    @Override
    public List<Section> getAll() throws SQLException {
        return sectionDAOJDBC.getAll();
    }
}
