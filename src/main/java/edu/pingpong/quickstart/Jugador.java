package edu.pingpong.quickstart;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;



@Entity
@Table(name = "Jugador")
@JsonPropertyOrder({"numero_dorsal", "nombre", "equipo"})
public class Jugador extends PanacheEntityBase{

    @Id
    @NotBlank
    @Column(unique = true)
    public Integer numero_dorsal;
    
    @NotEmpty
    @Column
    public String nombre;

    @NotEmpty
    @JoinColumn(name= "nombre_equipo")
    public String equipo;




    public Jugador() {
    }
    
    public Jugador(Integer numero, String nombre) {
        this.numero_dorsal = numero;

        this.nombre = nombre;

    }

    public String getNombre() {
        return this.nombre;
    }
    public void setName(String nombre) {
        this.nombre = nombre;
    }
}