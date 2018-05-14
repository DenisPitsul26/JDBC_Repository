package pit.springproject.tables.DAO.sectionOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.sectionOfTradingPoint.interfaces.ISectionOfTradingPointDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Section;
import pit.springproject.tables.model.SectionOfTradingPoint;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.model.TypeOfTradingPoint;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SectionOfTradingPointDAOJDBC implements ISectionOfTradingPointDAOJDBC{

    @Autowired
    DataStorageJDBC dataStorage;
    private List<SectionOfTradingPoint> list = new ArrayList<>();

    @Override
    public SectionOfTradingPoint insertSectionOfTradingPoint(SectionOfTradingPoint sectionOfTradingPoint) throws SQLException {
        String query = "INSERT INTO `section_of_trading_point` (`trading_point_id`, `section_id`, `number_of_halls`) VALUES (?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1, sectionOfTradingPoint.getTradingPoint().getId());
        statement.setInt(2, sectionOfTradingPoint.getSection().getId());
        statement.setInt(3, sectionOfTradingPoint.getNumberOfHalls());
        int countInsertedRows = statement.executeUpdate();
        statement.close();
        return sectionOfTradingPoint;
    }

    @Override
    public SectionOfTradingPoint getSectionOfTradingPoint(int id) throws SQLException {
        /*String query = "SELECT * FROM section_of_trading_point " +
                "JOIN trading_point ON section_of_trading_point.trading_point_id = trading_point.id " +
                "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                "JOIN section ON section_of_trading_point.section_id = section.id";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        SectionOfTradingPoint sectionOfTradingPoint = new SectionOfTradingPoint(
                rs.getInt("id"),
                new TradingPoint(
                        rs.getInt("id"),
                        new TypeOfTradingPoint(
                                rs.getInt("id"),
                                rs.getString("type_of_type_of_trading_point")
                        ),
                        rs.getString("name_of_trading_point"),
                        rs.getInt("number_of_halls"),
                        rs.getInt("size_of_the_trading_point"),
                        rs.getDouble("lease_payments"),
                        rs.getDouble("utilities"),
                        rs.getInt("number_of_counters")
                ),
                new Section(
                        rs.getInt("id"),
                        rs.getString("type_of_section")
                ),
                rs.getInt("number_of_halls")
        );
        return sectionOfTradingPoint;*/
        ResultSet rs = dataStorage.executeQuery("SELECT * FROM section_of_trading_point " +
                "JOIN trading_point ON section_of_trading_point.trading_point_id = trading_point.id " +
                "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                "JOIN section ON section_of_trading_point.section_id = section.id " +
                "where section_of_trading_point.id = "+id);
        rs.next();
        SectionOfTradingPoint sectionOfTradingPoint = new SectionOfTradingPoint(
                rs.getInt("id"),
                new TradingPoint(
                        rs.getInt("id"),
                        new TypeOfTradingPoint(
                                rs.getInt("id"),
                                rs.getString("type_of_type_of_trading_point")
                        ),
                        rs.getString("name_of_trading_point"),
                        rs.getInt("number_of_halls"),
                        rs.getInt("size_of_the_trading_point"),
                        rs.getDouble("lease_payments"),
                        rs.getDouble("utilities"),
                        rs.getInt("number_of_counters")
                ),
                new Section(
                        rs.getInt("id"),
                        rs.getString("type_of_section")
                ),
                rs.getInt("number_of_halls")
        );
        return sectionOfTradingPoint;
    }

    @Override
    public SectionOfTradingPoint updateSectionOfTradingPoint(SectionOfTradingPoint sectionOfTradingPoint) throws SQLException {
        /*try {
            String query = "update section_of_trading_point set id = "+sectionOfTradingPoint.getId()+
                    ",trading_point_id = " + sectionOfTradingPoint.getTradingPoint().getId()+
                    ",section_id = '" + sectionOfTradingPoint.getSection().getId()+
                    "',number_of_halls = " + sectionOfTradingPoint.getNumberOfHalls();
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;*/
        String query = "UPDATE `section_of_trading_point` SET `trading_point_id`=?, `section_id`=?, `number_of_halls`=? WHERE `id`=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(query);
        statement.setInt(1,sectionOfTradingPoint.getTradingPoint().getId());
        statement.setInt(2,sectionOfTradingPoint.getSection().getId());
        statement.setInt(3,sectionOfTradingPoint.getNumberOfHalls());
        statement.setInt(4,sectionOfTradingPoint.getId());
        int countUpdatedRows = statement.executeUpdate();
        statement.close();
        return sectionOfTradingPoint;
    }

    @Override
    public void deleteSectionOfTradingPoint(int id) throws SQLException {
        try {
            String query = "delete from section_of_trading_point where id = "+ id;
            dataStorage.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SectionOfTradingPoint> getAll() throws SQLException {
        list.clear();
        ResultSet rs = dataStorage.executeQuery(
                        "SELECT * FROM section_of_trading_point " +
                        "JOIN trading_point ON section_of_trading_point.trading_point_id = trading_point.id " +
                        "JOIN type_of_trading_point ON trading_point.type_of_trading_point_id = type_of_trading_point.id " +
                        "JOIN section ON section_of_trading_point.section_id = section.id " +
                        "ORDER BY section_of_trading_point.id");
        while(rs.next()){
            list.add(new SectionOfTradingPoint(
                    rs.getInt("id"),
                    new TradingPoint(
                            rs.getInt("id"),
                            new TypeOfTradingPoint(
                                    rs.getInt("id"),
                                    rs.getString("type_of_type_of_trading_point")
                            ),
                            rs.getString("name_of_trading_point"),
                            rs.getInt("number_of_halls"),
                            rs.getInt("size_of_the_trading_point"),
                            rs.getDouble("lease_payments"),
                            rs.getDouble("utilities"),
                            rs.getInt("number_of_counters")
                    ),
                    new Section(
                            rs.getInt("id"),
                            rs.getString("type_of_section")
                    ),
                    rs.getInt("number_of_halls")
                    )
            );
        }
        return list;
    }
}
