package co.develhope.crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private long id;
    private String modelName;
    private String type;

    public Car() {
    }
    public Car(String modelName, String type) {
        this.modelName = modelName;
        this.type = type;
    }

    public long getId() {
        return id;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
