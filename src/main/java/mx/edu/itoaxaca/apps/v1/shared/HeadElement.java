package mx.edu.itoaxaca.apps.v1.shared;

public class HeadElement
    extends BaseElementNested
    implements HTMLElementNested {

    public HeadElement() {
        super("head");
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
