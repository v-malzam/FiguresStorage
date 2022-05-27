package ru.rightstep.figures_storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rightstep.figures_storage.model.Rectangle;
import ru.rightstep.figures_storage.service.IRectangleService;
import ru.rightstep.figures_storage.service.impl.RectangleService;

import java.util.List;

@RestController
@RequestMapping("rectangles")
public class RectangleController {
    private final IRectangleService rectangleService;

    public RectangleController(IRectangleService rectangleService) {
        this.rectangleService = rectangleService;
    }

    @GetMapping
    public List<Rectangle> getRectanglesOrderedByDiagonal() {
        return rectangleService.getRectanglesOrderedByDiagonal();
    }
}
