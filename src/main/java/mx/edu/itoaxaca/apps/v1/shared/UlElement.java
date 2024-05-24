package mx.edu.itoaxaca.apps.v1.shared;

public class UlElement extends BaseElementNested implements HTMLElementNested {

    public UlElement() {
        super("ul");
    }

    @Override
    public String render() {
        return (
            "<@tag " + this.parserAttributes() + ">" + this.renderChildrens() + "</@tag>"
        ).replace("@tag", this.getTagName());
    }

    @Override
    public void add(HTMLElement children) {
        this.getChildrens().add(children);
    }
}
