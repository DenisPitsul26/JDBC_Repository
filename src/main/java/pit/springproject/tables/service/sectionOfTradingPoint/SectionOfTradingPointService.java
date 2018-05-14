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
    public SectionOfTradingPoint insertSectionOfTradingPoint(SectionOfTradingPoint sectionOfTradingPoint) throws SQLException {
        return sectionOfTradingPointDAOJDBC.insertSectionOfTradingPoint(sectionOfTradingPoint);
    }

    @Override
    public SectionOfTradingPoint getSectionOfTradingPoint(int id) throws SQLException {
        return sectionOfTradingPointDAOJDBC.getSectionOfTradingPoint(id);
    }

    @Override
    public SectionOfTradingPoint updateSectionOfTradingPoint(SectionOfTradingPoint sectionOfTradingPoint) throws SQLException {
        return sectionOfTradingPointDAOJDBC.updateSectionOfTradingPoint(sectionOfTradingPoint);
    }

    @Override
    public void deleteSectionOfTradingPoint(int id) throws SQLException {
        sectionOfTradingPointDAOJDBC.deleteSectionOfTradingPoint(id);
    }

    @Override
    public List<SectionOfTradingPoint> getAll() throws SQLException {
        return sectionOfTradingPointDAOJDBC.getAll();
    }
}
