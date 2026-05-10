package com.unir.gestion_vehiculos.service.impl;

import com.unir.gestion_vehiculos.persistence.entity.EstadoVehiculo;
import com.unir.gestion_vehiculos.persistence.entity.Vehiculo;
import com.unir.gestion_vehiculos.persistence.repository.VehiculoRepository;
import com.unir.gestion_vehiculos.service.VehiculoService;

import java.util.List;
import java.util.Optional;

public class VehiculoServiceImpl implements VehiculoService {

    private VehiculoRepository repository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.repository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return repository.findAll();
    }

    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> getVehiculo(int id) {
        return repository.findById(id);
    }

    @Override
    public void deleteVehiculo(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Vehiculo> getVehiculosByMarca(String marca) {
        return repository.findByMarca(marca);
    }

    @Override
    public List<Vehiculo> getVehiculosByModelo(String modelo) {
        return repository.findByModelo(modelo);
    }

    @Override
    public List<Vehiculo> getVehiculosByPlaca(String placa) {
        return repository.findByPlaca(placa);
    }

    @Override
    public List<Vehiculo> getVehiculosByEstadoDelVehiculo(EstadoVehiculo estado) {
        return repository.findByEstado(estado);
    }
}
