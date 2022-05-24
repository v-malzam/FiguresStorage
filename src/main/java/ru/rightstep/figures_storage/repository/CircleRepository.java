package ru.rightstep.figures_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.model.Color;

import java.util.List;

public interface CircleRepository extends JpaRepository<Circle, Integer> {

    List<Circle> findAllByColor(Color color);

}
