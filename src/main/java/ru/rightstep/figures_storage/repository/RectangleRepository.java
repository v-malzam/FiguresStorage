package ru.rightstep.figures_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Rectangle;

import java.util.List;

public interface RectangleRepository extends JpaRepository<Rectangle, Integer> {

    List<Rectangle> findAllByColor(Color color);

}
