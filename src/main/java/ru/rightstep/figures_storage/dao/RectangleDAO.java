package ru.rightstep.figures_storage.dao;

import org.springframework.stereotype.Repository;
import ru.rightstep.figures_storage.model.Rectangle;

@Repository
public class RectangleDAO extends AbstractHibernateDao<Rectangle> implements IRectangleDAO {

}
