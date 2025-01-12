package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    private boolean required = false;

    protected final void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
        if (Objects.equals(name, "required")) {
            required = true;
        }
    }

    public final boolean isValid(T obj) {
        if (obj == null) {
            return !required;
        }

        for (var validate : checks.values()) {
            if (!validate.test(obj)) {
                return false;
            }
        }

        return true;
    }

}
