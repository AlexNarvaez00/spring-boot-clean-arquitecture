package mx.edu.itoaxaca.apps.v1.shared;

import java.util.HashMap;
import lombok.Getter;

public abstract class BaseElement {

    @Getter
    private HashMap<String, String> attributes;

    @Getter
    private String tagName;

    public BaseElement(String tagName) {
        this.tagName = tagName;
        this.attributes = new HashMap<>();
    }

    public String parserAttributes() {
        var atributes = (this.getAttributes().size() > 0)
            ? this.getAttributes()
                .entrySet()
                .stream()
                .map(row -> row.getKey() + "=\"" + row.getValue() + "\"")
                .reduce("", (accu, current) -> accu + current)
            : "";
            return atributes;
    }
}
