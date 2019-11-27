package br.senac.go.data.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Carro {

    @PrimaryKey
    private Long id;
    private String modelo;

    public Carro(){
    }

    @Ignore
    public Carro(Long id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return id.equals(carro.id) &&
                modelo.equals(carro.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelo);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
