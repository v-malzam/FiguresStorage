package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;
import ru.rightstep.figures_storage.repository.FigureRepository;
import ru.rightstep.figures_storage.service.FigureService;

import java.util.Comparator;
import java.util.List;

@Service
public class FigureServiceImpl implements FigureService {
    private final FigureRepository figureRepository;

    public FigureServiceImpl(FigureRepository figureRepository) {
        this.figureRepository = figureRepository;
    }

    @Override
    public List<Figure> getFigures() {
        return figureRepository.findAll();
    }

    @Override
    public List<Figure> getFiguresWishColorOrderedByArea(Color color) {
        List<Figure> figures = figureRepository.findAllByColor(color);
        figures.sort(Comparator.comparing(Figure::getArea));
        return figures;
    }
}
