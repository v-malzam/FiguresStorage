package ru.rightstep.figures_storage.service;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.repository.CircleRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class CircleService {
    private final CircleRepository circleRepository;

    public CircleService(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    public List<Circle> getCirclesOrderedByRadius() {
        List<Circle> circles = circleRepository.findAll();
        circles.sort(Comparator.comparing(Circle::getRadius));
        return circles;
    }
}
