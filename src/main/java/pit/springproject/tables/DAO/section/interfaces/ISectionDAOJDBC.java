package pit.springproject.tables.DAO.section.interfaces;

import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.Section;

import java.sql.SQLException;
import java.util.List;

public interface ISectionDAOJDBC {
    public Section insertSection(Section section);

    public Section getSection(int id) throws SQLException;

    public Section updateSection(Section section) throws SQLException;

    public void deleteSection(int id) throws SQLException;

    public List<Section> getAll() throws SQLException;
}
