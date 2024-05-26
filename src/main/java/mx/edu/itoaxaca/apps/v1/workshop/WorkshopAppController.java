package mx.edu.itoaxaca.apps.v1.workshop;

import mx.edu.itoaxaca.apps.v1.shared.Layout;
import mx.edu.itoaxaca.apps.v1.workshop.views.IndexWorkshop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "workshop")
public class WorkshopAppController {

    @GetMapping(value = "")
    public Layout index() {
        return new IndexWorkshop("Workshops");
    }
}
