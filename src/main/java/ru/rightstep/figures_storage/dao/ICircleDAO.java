package ru.rightstep.figures_storage.dao;

import ru.rightstep.figures_storage.model.Circle;

import java.util.List;

public interface ICircleDAO {

    List<Circle> findByOrderByRadius();

}
