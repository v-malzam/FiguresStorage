package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.repository.CircleRepository;
import ru.rightstep.figures_storage.service.ICircleService;

import java.util.Comparator;
import java.util.List;

@Service
public class CircleService implements ICircleService {
    private final CircleRepository circleRepository;

    public CircleService(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    @Override
    public List<Circle> getCirclesOrderedByRadius() {
        List<Circle> circles = circleRepository.findAll();
        circles.sort(Comparator.comparing(Circle::getRadius));
        return circles;
    }
}
