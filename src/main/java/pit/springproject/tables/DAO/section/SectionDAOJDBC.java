package pit.springproject.tables.DAO.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.section.interfaces.ISectionDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Goods;
import pit.springproject.tables.model.Section;
import pit.springproject.tables.model.SectionOfTradingPoint;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SectionDAOJDBC implements ISectionDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<Section> list = new ArrayList<>();

    @Override
    public Section insertSection(Section section) {
        try {
            String query = "insert into section (id,type_of_section) values ("
                    +section.getId()+",'"
                    +section.getTypeOfSection()+"')";
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Section getSection(int id) throws SQLException {
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM section where id = "+id);
        rs.next();
        Section section = new Section(rs.getInt("id"), rs.getString("type_of_section"));
        return section;
    }

    @Override
    public Section updateSection(Section section) throws SQLException {
        try {
            String query = "update section set id="+section.getId()+
                            ",type_of_section = '" + section.getTypeOfSection()+
                            "' where id ="+ section.getId();
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteSection(int id) throws SQLException {
        try {
            String query = "delete from section where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Section> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM section");
        while(rs.next()){
            list.add(new Section(
                            rs.getInt("id"),
                            rs.getString("type_of_section")
                    )
            );
        }
        return list;
    }
}
