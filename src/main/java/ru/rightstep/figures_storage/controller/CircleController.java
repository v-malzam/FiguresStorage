package ru.rightstep.figures_storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.service.CircleService;

import java.util.List;

@RestController
@RequestMapping("circles")
public class CircleController {
    private final CircleService circleService;

    public CircleController(CircleService circleService) {
        this.circleService = circleService;
    }

    @GetMapping
    public List<Circle> getCirclesOrderedByRadius() {
        return circleService.getCirclesOrderedByRadius();
    }
}
