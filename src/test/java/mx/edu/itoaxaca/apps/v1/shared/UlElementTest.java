package mx.edu.itoaxaca.apps.v1.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UlElementTest {

    @Test
    void testAdd() {
        var ul = new UlElement();
        ul.add(() -> "Text");
        ul.getAttributes().put("class", "bg-grey-500");
        var tag = "<ul class=\"bg-grey-500\">Text</ul>";
        assertEquals(ul.render(), tag);
    }

    @Test
    void testRender() {
        var ul = new UlElement();
        var tag = "<ul ></ul>";
        assertEquals(ul.render(), tag);
    }
}
