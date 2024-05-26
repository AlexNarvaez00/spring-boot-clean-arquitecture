package mx.edu.itoaxaca.apps.v1.shared;

public class MetaElement extends BaseElement implements HTMLElement {

    public MetaElement() {
        super("meta");
    }

    @Override
    public String render() {
        return (
            "<@tag " +
            this.parserAttributes() +
            "  >".replace("@tag", this.getTagName())
        );
    }
}
