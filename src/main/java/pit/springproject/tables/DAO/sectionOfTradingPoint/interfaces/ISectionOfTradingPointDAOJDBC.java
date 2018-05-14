package pit.springproject.tables.DAO.sectionOfTradingPoint.interfaces;

import pit.springproject.tables.model.SectionOfTradingPoint;

import java.sql.SQLException;
import java.util.List;

public interface ISectionOfTradingPointDAOJDBC {
    public SectionOfTradingPoint insertSectionOfTradingPoint(
            SectionOfTradingPoint sectionOfTradingPoint) throws SQLException;

    public SectionOfTradingPoint getSectionOfTradingPoint(int id) throws SQLException;

    public SectionOfTradingPoint updateSectionOfTradingPoint(
            SectionOfTradingPoint sectionOfTradingPoint) throws SQLException;

    public void deleteSectionOfTradingPoint(int id) throws SQLException;

    public List<SectionOfTradingPoint> getAll() throws SQLException;
}
