package ru.rightstep.figures_storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;
import ru.rightstep.figures_storage.service.IFigureService;
import ru.rightstep.figures_storage.service.impl.FigureService;

import java.util.List;

@RestController
@RequestMapping("figures")
public class FigureController {
    private final IFigureService figureService;

    public FigureController(IFigureService figureService) {
        this.figureService = figureService;
    }

    @GetMapping()
    public List<Figure> getFigures() {
        return figureService.getFigures();
    }

    @GetMapping(params = "c")
    public List<Figure> getFiguresWishColorOrderedByArea(@RequestParam String c) {
        Color color = Color.valueOf(c);
        return figureService.getFiguresWishColorOrderedByArea(color);
    }
}
