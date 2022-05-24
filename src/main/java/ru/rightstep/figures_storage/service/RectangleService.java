package ru.rightstep.figures_storage.service;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Rectangle;
import ru.rightstep.figures_storage.repository.RectangleRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class RectangleService {
    private final RectangleRepository rectangleRepository;

    public RectangleService(RectangleRepository rectangleRepository) {
        this.rectangleRepository = rectangleRepository;
    }

    public List<Rectangle> getRectanglesOrderedByDiagonal() {
        List<Rectangle> rectangles = rectangleRepository.findAll();
        rectangles.sort(Comparator.comparing(Rectangle::getDiagonal));
        return rectangles;
    }
}
