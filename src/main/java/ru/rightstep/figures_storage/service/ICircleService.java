package ru.rightstep.figures_storage.service;

import ru.rightstep.figures_storage.model.Circle;

import java.util.List;

public interface ICircleService {

    List<Circle> getCirclesOrderedByRadius();

}
