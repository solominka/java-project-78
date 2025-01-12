package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        addCheck("required", o -> (o != null && !o.isEmpty()));
        return this;
    }

    public StringSchema minLength(Integer length) {
        addCheck("minLength", o -> (o.length() >= length));
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", o -> (o.contains(substring)));
        return this;
    }
}
