package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", o -> o > 0);
        return this;
    }

    public NumberSchema range(Integer from, Integer to) {
        addCheck("range", o -> o >= from && o <= to);
        return this;
    }
}
