package ru.rightstep.figures_storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Figure;

import java.util.List;

public interface FigureRepository extends JpaRepository<Figure, Integer> {

    @Query("from ru.rightstep.figures_storage.model.Figure")
    List<Figure> findAll();

    @Query("from ru.rightstep.figures_storage.model.Figure f where f.color = ?1")
    List<Figure> findAllByColor(Color color);

}
