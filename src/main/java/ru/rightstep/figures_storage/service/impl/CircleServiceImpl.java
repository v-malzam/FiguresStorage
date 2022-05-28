package ru.rightstep.figures_storage.service.impl;

import org.springframework.stereotype.Service;
import ru.rightstep.figures_storage.dao.ICircleDAO;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.service.CircleService;

import java.util.List;

@Service
public class CircleServiceImpl implements CircleService {
    private final ICircleDAO circleDAO;

    public CircleServiceImpl(ICircleDAO circleDAO) {
        this.circleDAO = circleDAO;
    }

    @Override
    public List<Circle> getCirclesOrderedByRadius() {
        return circleDAO.findByOrderByRadius();
    }
}
