package br.senac.projectlocadora.data.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Carro {

    @PrimaryKey
    private Long id;
    private String Modelo;

    public Carro(){
    }

    @Ignore
    public Carro(Long id, String modelo) {
        this.id = id;
        Modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return id.equals(carro.id) &&
                Modelo.equals(carro.Modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Modelo);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", Modelo='" + Modelo + '\'' +
                '}';
    }
}
