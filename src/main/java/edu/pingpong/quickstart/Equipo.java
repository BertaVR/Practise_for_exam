package edu.pingpong.quickstart;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table
@JsonPropertyOrder({"nombre", "liga"})
public class Equipo extends PanacheEntityBase {

    @NotBlank
    @NotEmpty
    @Id
    @Column
    public String nombre;
    
    @NotBlank
    @NotEmpty
    @Column
    public String liga;

    @JsonIgnore // esto es para que no coja el set en el Json
    @OneToMany(mappedBy = "equipo")
    public Set<Jugador> fruits = new HashSet<Jugador>();


    public Equipo() {
    }

    
    public Equipo(String nombre, String liga) {
        this.nombre = nombre;
        this.liga = liga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getliga() {
        return liga;
    }

    public void setliga(String liga) {
        this.liga = liga;
    }

    
    
}
