package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.dao.IRectangleDAO;
import ru.rightstep.figures_storage.model.Rectangle;
import ru.rightstep.figures_storage.service.RectangleService;

import java.util.Comparator;
import java.util.List;

@Service
public class RectangleServiceImpl implements RectangleService {
    private final IRectangleDAO rectangleDAO;

    public RectangleServiceImpl(IRectangleDAO rectangleDAO) {
        this.rectangleDAO = rectangleDAO;
    }

    @Override
    public List<Rectangle> getRectanglesOrderedByDiagonal() {
        List<Rectangle> rectangles = rectangleDAO.findAll();
        rectangles.sort(Comparator.comparing(Rectangle::getDiagonal));
        return rectangles;
    }
}
