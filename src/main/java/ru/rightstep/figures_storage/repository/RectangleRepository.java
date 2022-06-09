package ru.rightstep.figures_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rightstep.figures_storage.model.Rectangle;

public interface RectangleRepository extends JpaRepository<Rectangle, Integer> {

}
