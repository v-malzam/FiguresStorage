package ru.rightstep.figures_storage.dao;

import org.springframework.stereotype.Repository;
import ru.rightstep.figures_storage.model.Circle;

import java.util.List;

@Repository
public class CircleDAO extends AbstractHibernateDao<Circle> implements ICircleDAO {

    @Override
    public List<Circle> findByOrderByRadius() {
        return getCurrentSession().createQuery("from Circle order by radius").list();
    }
}
