package ru.rightstep.figures_storage.service;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;
import ru.rightstep.figures_storage.repository.FigureRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class FigureService {
    private final FigureRepository figureRepository;

    public FigureService(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    public List<Figure> getFigures() {
        return figureRepository.findAll();
    }

    public List<Figure> getFiguresWishColorOrderedByArea(Color color) {
        List<Figure> figures = figureRepository.findAllByColor(color);
        figures.sort(Comparator.comparing(Figure::getArea));
        return figures;
    }
}
