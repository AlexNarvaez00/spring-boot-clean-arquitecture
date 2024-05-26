package mx.edu.itoaxaca.apps.v1.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class Layout {

    public List<HTMLElement> childrens;

    public Layout(String title) {
        this.childrens = new ArrayList<>();
        this.init(title);
    }

    private void init(String title) {
        this.childrens.add(() -> "<!DOCTYPE html>");
        var html = new HTMLTagElement();
        var head = new HeadElement();

        var meta = new MetaElement();
        meta.getAttributes().put("charset", "UTF-8");
        head.add(meta);

        var meta2 = new MetaElement();
        meta2.getAttributes().put("name", "viewport");
        meta2
            .getAttributes()
            .put("content", "width=device-width, initial-scale=1.0");
        head.add(meta2);

        var titleTag = new TitleElement(title);
        head.add(titleTag);

        html.add(head);
        var body = new BodyElement();
        html.add(body);
        this.childrens.forEach(element -> {
                body.add(element);
            });
        this.add(html);
    }

    public void add(HTMLElement element) {
        this.childrens.add(element);
    }

    @Override
    public String toString() {
        return this.childrens.stream()
            .map(element -> element.toString())
            .reduce("", (acum, current) -> acum + current);
    }
}
