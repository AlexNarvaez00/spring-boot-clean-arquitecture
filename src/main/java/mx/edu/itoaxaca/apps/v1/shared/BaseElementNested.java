package mx.edu.itoaxaca.apps.v1.shared;

import java.util.List;

import lombok.Getter;

public abstract class BaseElementNested extends BaseElement{

    @Getter
    private List<HTMLElement> childrens;
    
    public BaseElementNested(String tagName) {
        super(tagName);
    }

    public String renderChildrens(){
        String childrens = (this.childrens.size() > 0)
            ? this.childrens.stream()
                .map(element -> element.render())
                .reduce("", (accu, current) -> accu + current)
            : "";
        
        return childrens;
    }

}