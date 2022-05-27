package ru.rightstep.figures_storage.service;

import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;

import java.util.List;

public interface FigureService {

    List<Figure> getFigures();

    List<Figure> getFiguresWishColorOrderedByArea(Color color);

}
