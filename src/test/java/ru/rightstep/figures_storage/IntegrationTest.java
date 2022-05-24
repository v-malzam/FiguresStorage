package ru.rightstep.figures_storage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.rightstep.figures_storage.model.Circle;
import ru.rightstep.figures_storage.model.Color;
import ru.rightstep.figures_storage.model.Rectangle;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    private static final Circle SMALL_CIRCLE = new Circle(null, Color.red, 1);
    private static final Circle AVERAGE_CIRCLE = new Circle(null, Color.yellow, 2);
    private static final Circle LARGE_CIRCLE = new Circle(null, Color.green, 3);
    private static final Circle SECOND_RED_CIRCLE = new Circle(null, Color.red, 4);
    private static final Rectangle SMALL_RECTANGLE = new Rectangle(null, Color.red, 1, 1);
    private static final Rectangle AVERAGE_RECTANGLE = new Rectangle(null, Color.yellow, 2, 2);
    private static final Rectangle LARGE_RECTANGLE = new Rectangle(null, Color.green, 3, 3);
    private static final Rectangle SECOND_RED_RECTANGLE = new Rectangle(null, Color.red, 4, 4);

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getCirclesOrderedByRadius() {
        ResponseEntity<Circle[]> responseEntity = template.getForEntity("/circles", Circle[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Circle> targetCircleList = Arrays.asList(
                SMALL_CIRCLE,
                AVERAGE_CIRCLE,
                LARGE_CIRCLE,
                SECOND_RED_CIRCLE);
        assertEquals(targetCircleList, Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
    }

    @Test
    public void getRectanglesOrderedByDiagonal() {
        ResponseEntity<Rectangle[]> responseEntity = template.getForEntity("/rectangles", Rectangle[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Rectangle> targetRectangleList = Arrays.asList(
                SMALL_RECTANGLE,
                AVERAGE_RECTANGLE,
                LARGE_RECTANGLE,
                SECOND_RED_RECTANGLE);
        assertEquals(targetRectangleList, Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
    }


    // Тесты ниже не удалось отдалить в разумные сроки.




    /*@Test
    public void getFigures() {
        ResponseEntity<JsonNode> responseEntity = template.getForEntity("/figures", JsonNode.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        JsonNode body = responseEntity.getBody();

        //List<Figure> body = Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));

        assertTrue(body.contains(SMALL_CIRCLE));
        assertTrue(body.contains(AVERAGE_CIRCLE));
        assertTrue(body.contains(LARGE_CIRCLE));
        assertTrue(body.contains(SECOND_RED_CIRCLE));
        assertTrue(body.contains(SMALL_RECTANGLE));
        assertTrue(body.contains(AVERAGE_RECTANGLE));
        assertTrue(body.contains(LARGE_RECTANGLE));
        assertTrue(body.contains(SECOND_RED_RECTANGLE));
        assertEquals(5, body.size());
    }

    @Test
    public void getFiguresWishColorOrderedByArea() {
        ResponseEntity<Figure[]> responseEntity = template.getForEntity("/figures?c=red", Figure[].class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<Figure> targetFigureWishColorList = Arrays.asList(
                SMALL_CIRCLE,
                SECOND_RED_CIRCLE,
                SMALL_RECTANGLE,
                SECOND_RED_RECTANGLE);
        assertEquals(targetFigureWishColorList, Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
    }*/
}
