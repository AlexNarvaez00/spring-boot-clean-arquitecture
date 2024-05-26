package mx.edu.itoaxaca.apps.v1.shared;

public class TitleElement extends BaseElement implements HTMLElement {

    private String title;

    public TitleElement(String title) {
        super("title");
        this.title = title;
    }

    @Override
    public String render() {
        return (
            "<@tag " + this.parserAttributes() + ">" + title + "</@tag>"
        ).replace("@tag", this.getTagName());
    }
}
