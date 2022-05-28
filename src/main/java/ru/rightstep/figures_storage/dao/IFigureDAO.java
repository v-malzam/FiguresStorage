package ru.rightstep.figures_storage.dao;

import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;

import java.util.List;

public interface IFigureDAO {

    List<Figure> findAll();

    List<Figure> findAllByColor(Color color);

}
