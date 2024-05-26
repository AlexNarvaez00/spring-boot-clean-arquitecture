package mx.edu.itoaxaca.apps.v1.shared;

public class HTMLTagElement
    extends BaseElementNested
    implements HTMLElementNested {

    public HTMLTagElement() {
        super("html");
    }

    @Override
    public String render() {
        return (
            "<@tag " +
            this.parserAttributes() +
            ">" +
            this.renderChildrens() +
            "</@tag>"
        ).replace("@tag", this.getTagName());
    }

    @Override
    public void add(HTMLElement childre) {
        this.getChildrens().add(childre);
    }
}
