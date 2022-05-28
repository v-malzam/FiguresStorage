package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.dao.IFigureDAO;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;
import ru.rightstep.figures_storage.service.FigureService;

import java.util.Comparator;
import java.util.List;

@Service
public class FigureServiceImpl implements FigureService {
    private final IFigureDAO figureDAO;

    public FigureServiceImpl(IFigureDAO figureDAO) {
        this.figureDAO = figureDAO;
    }

    @Override
    public List<Figure> getFigures() {
        return figureDAO.findAll();
    }

    @Override
    public List<Figure> getFiguresWishColorOrderedByArea(Color color) {
        List<Figure> figures = figureDAO.findAllByColor(color);
        figures.sort(Comparator.comparing(Figure::getArea));
        return figures;
    }
}
