package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Rectangle;
import ru.rightstep.figures_storage.repository.RectangleRepository;
import ru.rightstep.figures_storage.service.IRectangleService;

import java.util.Comparator;
import java.util.List;

@Service
public class RectangleService implements IRectangleService {
    private final RectangleRepository rectangleRepository;

    public RectangleService(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
    }

    @Override
    public List<Rectangle> getRectanglesOrderedByDiagonal() {
        List<Rectangle> rectangles = rectangleRepository.findAll();
        rectangles.sort(Comparator.comparing(Rectangle::getDiagonal));
        return rectangles;
    }
}
