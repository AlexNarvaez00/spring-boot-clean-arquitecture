package mx.edu.itoaxaca.apps.v1.shared;

public class BodyElement
    extends BaseElementNested
    implements HTMLElementNested {

    public BodyElement() {
        super("body");
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
