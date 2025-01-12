package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        super.required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("minLength", o -> o > 0);
        return this;
    }

    public NumberSchema range(Integer from, Integer to) {
        addCheck("contains", o -> o >= from && o <= to);
        return this;
    }
}
