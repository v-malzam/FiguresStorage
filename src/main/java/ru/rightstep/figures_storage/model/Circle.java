package ru.rightstep.figures_storage.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"id", "color", "radius", "area", "perimeter"})
public class Circle extends Figure {

    private Integer radius;

    public Circle(Integer id, Color color, Integer radius) {
        super(id, color);
        this.radius = radius;
    }

    @Override
    public BigDecimal getArea() {
        double area = Math.pow(radius, 2) * Math.PI;
        BigDecimal result = new BigDecimal(area);
        return result.setScale(15, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getPerimeter() {
        double perimeter = 2 * radius * Math.PI;
        BigDecimal result = new BigDecimal(perimeter);
        return result.setScale(15, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (!Objects.equals(radius, circle.radius)) return false;
        return super.getColor() == circle.getColor();
    }

    @Override
    public int hashCode() {
        int result = radius != null ? radius.hashCode() : 0;
        result = 31 * result + (super.getColor() != null ? super.getColor().hashCode() : 0);
        return result;
    }
}
