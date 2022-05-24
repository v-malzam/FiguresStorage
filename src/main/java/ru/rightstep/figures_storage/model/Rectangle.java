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
@JsonPropertyOrder({"id", "color", "height", "width", "diagonal", "area", "perimeter"})
public class Rectangle extends Figure {

    private Integer height;
    private Integer width;

    public Rectangle(Integer id, Color color, Integer height, Integer width) {
        super(id, color);
        this.height = height;
        this.width = width;
    }

    @Override
    public BigDecimal getArea() {
        double area = height * width;
        BigDecimal result = new BigDecimal(area);
        return result.setScale(15, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getPerimeter() {
        double perimeter = 2 * (height + width);
        BigDecimal result = new BigDecimal(perimeter);
        return result.setScale(15, RoundingMode.HALF_UP);
    }

    public BigDecimal getDiagonal() {
        double diagonal = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
        BigDecimal result = new BigDecimal(diagonal);
        return result.setScale(15, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!Objects.equals(height, rectangle.height)) return false;
        if (!Objects.equals(width, rectangle.width)) return false;
        return super.getColor() == rectangle.getColor();
    }

    @Override
    public int hashCode() {
        int result = height != null ? height.hashCode() : 0;
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (super.getColor() != null ? super.getColor().hashCode() : 0);
        return result;
    }
}
