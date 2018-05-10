package pit.springproject.tables.service.sectionOfTradingPoint.interfaces;

import pit.springproject.tables.model.SectionOfTradingPoint;

import java.sql.SQLException;
import java.util.List;

public interface ISectionOfTradingPointService {
    public SectionOfTradingPoint insertSectionOfTradingPoint(
            SectionOfTradingPoint sectionOfTradingPoint);

    public SectionOfTradingPoint getSectionOfTradingPoint(int id);

    public SectionOfTradingPoint updateSectionOfTradingPoint(
            SectionOfTradingPoint sectionOfTradingPoint) throws SQLException;

    public SectionOfTradingPoint deleteSectionOfTradingPoint(int id) throws SQLException;

    public List<SectionOfTradingPoint> getAll() throws SQLException;
}
