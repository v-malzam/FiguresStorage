package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.repository.CircleRepository;
import ru.rightstep.figures_storage.service.CircleService;

import java.util.List;

@Service
public class CircleServiceImpl implements CircleService {
    private final CircleRepository circleRepository;

    public CircleServiceImpl(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    @Override
    public List<Circle> getCirclesOrderedByRadius() {
        return circleRepository.findByOrderByRadiusAsc();
    }
}
