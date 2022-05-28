package ru.rightstep.figures_storage.dao;

import org.springframework.stereotype.Repository;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;

import java.util.List;

@Repository
public class FigureDAO extends AbstractHibernateDao<Figure> implements IFigureDAO {

    @Override
    public List<Figure> findAll() {
        return getCurrentSession().createQuery("from ru.rightstep.figures_storage.model.Figure").list();
    }

    @Override
    public List<Figure> findAllByColor(Color color) {
        return getCurrentSession().createQuery("from ru.rightstep.figures_storage.model.Figure f where f.color = ?1").list();
    }
}
