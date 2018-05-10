package pit.springproject.tables.DAO.sectionOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pit.springproject.tables.DAO.sectionOfTradingPoint.interfaces.ISectionOfTradingPointDAOJDBC;
import pit.springproject.tables.datastorage.DataStorageJDBC;
import pit.springproject.tables.model.Section;
import pit.springproject.tables.model.SectionOfTradingPoint;
import pit.springproject.tables.model.TradingPoint;
import pit.springproject.tables.model.TypeOfTradingPoint;

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
    public SectionOfTradingPoint insertSectionOfTradingPoint(SectionOfTradingPoint sectionOfTradingPoint) {
        return null;
    }

    @Override
    public SectionOfTradingPoint getSectionOfTradingPoint(int id) {
        return null;
    }

    @Override
    public SectionOfTradingPoint updateSectionOfTradingPoint(SectionOfTradingPoint sectionOfTradingPoint) throws SQLException {
        return null;
    }

    @Override
    public SectionOfTradingPoint deleteSectionOfTradingPoint(int id) throws SQLException {
        return null;
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
                    rs.getInt("number_of_hall")
                    )
            );
        }
        return list;
    }
}
