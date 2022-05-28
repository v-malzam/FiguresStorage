package ru.rightstep.figures_storage.dao;

import ru.rightstep.figures_storage.model.Rectangle;

import java.util.List;

public interface IRectangleDAO {

    List<Rectangle> findAll();

}
