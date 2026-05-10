package com.unir.gestion_vehiculos.persistence.entity;

import jakarta.persistence.*;

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String marca;
    private String modelo;
    private String placa;

    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado;

    public Vehiculo(int id, String marca, String modelo, String placa, EstadoVehiculo estado) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.estado = estado;
    }

    public Vehiculo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }
}
