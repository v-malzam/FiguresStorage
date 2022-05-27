package ru.rightstep.figures_storage.service;

import ru.rightstep.figures_storage.model.Rectangle;

import java.util.List;

public interface RectangleService {

    List<Rectangle> getRectanglesOrderedByDiagonal();

}
