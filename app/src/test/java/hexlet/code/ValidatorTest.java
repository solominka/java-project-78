package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ValidatorTest {
    @Test
    void testStringValidator() {
        var v = new Validator();

        var schema = v.string();

        // Пока не вызван метод required(), null и пустая строка считаются валидным
        Assertions.assertTrue(schema.isValid(""));
        Assertions.assertTrue(schema.isValid(null));

        schema.required();
        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertFalse(schema.isValid(""));

        Assertions.assertTrue(schema.isValid("what does the fox say"));
        Assertions.assertTrue(schema.isValid("hexlet"));

        Assertions.assertTrue(schema.contains("wh").isValid("what does the fox say"));
        Assertions.assertTrue(schema.contains("what").isValid("what does the fox say"));
        Assertions.assertFalse(schema.contains("whatthe").isValid("what does the fox say"));

        Assertions.assertFalse(schema.isValid("what does the fox say"));

        var schema1 = v.string();
        Assertions.assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet"));
    }

    @Test
    void testNumberValidator() {
        var v = new Validator();

        var schema = v.number();

        Assertions.assertTrue(schema.isValid(5));

        // Пока не вызван метод required(), null считается валидным
        Assertions.assertTrue(schema.isValid(null));
        Assertions.assertTrue(schema.positive().isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(10));

        // Потому что ранее мы вызвали метод positive()
        Assertions.assertFalse(schema.isValid(-10));
        //  Ноль — не положительное число
        Assertions.assertFalse(schema.isValid(0));

        schema.range(5, 10);

        Assertions.assertTrue(schema.isValid(5));
        Assertions.assertTrue(schema.isValid(10));
        Assertions.assertFalse(schema.isValid(4));
        Assertions.assertFalse(schema.isValid(11));
    }

    @Test
    void testMapValidator() {
        var v = new Validator();

        var schema = v.map();

        Assertions.assertTrue(schema.isValid(null));

        schema.required();

        Assertions.assertFalse(schema.isValid(null));
        Assertions.assertTrue(schema.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        Assertions.assertTrue(schema.isValid(data));

        schema.sizeof(2);

        Assertions.assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        Assertions.assertTrue(schema.isValid(data));
    }
}
