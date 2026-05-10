package com.unir.gestion_vehiculos.service.impl;

import com.unir.gestion_vehiculos.dto.VehiculoDTO;
import com.unir.gestion_vehiculos.persistence.entity.EstadoVehiculo;
import com.unir.gestion_vehiculos.persistence.entity.Vehiculo;
import com.unir.gestion_vehiculos.persistence.repository.VehiculoRepository;
import com.unir.gestion_vehiculos.service.VehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository repository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.repository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return repository.findAll();
    }

    @Override
    public VehiculoDTO saveVehiculo(VehiculoDTO vehiculoDTO) {
        // 1. Convertir DTO a Entidad
        Vehiculo entidad = new Vehiculo();
        entidad.setMarca(vehiculoDTO.marca());
        entidad.setModelo(vehiculoDTO.modelo());
        entidad.setPlaca(vehiculoDTO.placa());
        entidad.setEstado(EstadoVehiculo.valueOf(vehiculoDTO.estado()));

        // 2. Guardar en BD
        Vehiculo savedVehiculo = repository.save(entidad);

        // 3. Convertir Entidad a DTO para la respuesta
        return new VehiculoDTO(
                savedVehiculo.getMarca(),
                savedVehiculo.getModelo(),
                savedVehiculo.getPlaca(),
                savedVehiculo.getEstado().name()
        );
    }

    @Override
    public Optional<Vehiculo> getVehiculoById(int id) {
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