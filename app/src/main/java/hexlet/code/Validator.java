package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    private BaseSchema schema;

    public StringSchema string() {
        schema = new StringSchema();
        return (StringSchema) schema;
    }

    public NumberSchema number() {
        schema = new NumberSchema();
        return (NumberSchema) schema;
    }
}
