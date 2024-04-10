package mx.edu.itoaxaca.api.v1.departament.domain;

import lombok.Data;

@Data
public class DepartamentRequest {
    public String name;

    public Departament asDepartament(){
        return new Departament(this.name);
    }
}
