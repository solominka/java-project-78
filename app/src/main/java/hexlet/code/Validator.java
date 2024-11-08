package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Validator {
    private StringSchema schema;

    public StringSchema string() {
        schema = new StringSchema();
        return schema;
    }
}
