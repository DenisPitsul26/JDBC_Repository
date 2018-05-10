package pit.springproject.tables.service.sectionOfTradingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.springproject.tables.DAO.sectionOfTradingPoint.SectionOfTradingPointDAOJDBC;
import pit.springproject.tables.model.SectionOfTradingPoint;
import pit.springproject.tables.service.sectionOfTradingPoint.interfaces.ISectionOfTradingPointService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SectionOfTradingPointService implements ISectionOfTradingPointService{

    @Autowired
    SectionOfTradingPointDAOJDBC sectionOfTradingPointDAOJDBC;

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
        return sectionOfTradingPointDAOJDBC.getAll();
    }
}
