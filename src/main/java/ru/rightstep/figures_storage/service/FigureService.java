package ru.rightstep.figures_storage.service;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;
import ru.rightstep.figures_storage.repository.CircleRepository;
import ru.rightstep.figures_storage.repository.RectangleRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FigureService {
    private final CircleRepository circleRepository;
    private final RectangleRepository rectangleRepository;

    public FigureService(CircleRepository circleRepository, RectangleRepository rectangleRepository) {
        this.circleRepository = circleRepository;
        this.rectangleRepository = rectangleRepository;
    }

    public List<Figure> getFigures() {
        List<Figure> figures = new ArrayList<>();
        figures.addAll(circleRepository.findAll());
        figures.addAll(rectangleRepository.findAll());
        return figures;
    }

    public List<Figure> getFiguresWishColorOrderedByArea(Color color) {
        List<Figure> figures = new ArrayList<>();
        figures.addAll(circleRepository.findAllByColor(color));
        figures.addAll(rectangleRepository.findAllByColor(color));
        figures.sort(Comparator.comparing(Figure::getArea));
        return figures;
    }
}
