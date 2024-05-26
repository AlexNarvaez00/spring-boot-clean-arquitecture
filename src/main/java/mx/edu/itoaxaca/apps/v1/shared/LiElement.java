package mx.edu.itoaxaca.apps.v1.shared;

public class LiElement extends BaseElementNested implements HTMLElementNested {

    public LiElement() {
        super("li");
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
