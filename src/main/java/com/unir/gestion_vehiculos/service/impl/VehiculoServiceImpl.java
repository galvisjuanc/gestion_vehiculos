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
        return this.guardadoVehiculo(vehiculoDTO);
    }

    @Override
    public Optional<Vehiculo> getVehiculoById(int id) {
        return repository.findById(id);
    }

    @Override
    public Boolean exists(int id) {
        return this.repository.existsById(id);
    }

    @Override
    public VehiculoDTO updateVehiculo(int id, VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculoUpdated = new Vehiculo(
                id,
                vehiculoDTO.marca(),
                vehiculoDTO.modelo(),
                vehiculoDTO.placa(),
                EstadoVehiculo.valueOf(vehiculoDTO.estado()));

        repository.save(vehiculoUpdated);
        return convertEntityToDTO(vehiculoUpdated);
    }

    public VehiculoDTO guardadoVehiculo(VehiculoDTO vehiculoDTO) {
        // 1. Convertir DTO a Entidad
        Vehiculo entidad = convertDTOToEntity(vehiculoDTO);

        // 2. Guardar en BD
        Vehiculo savedVehiculo = repository.save(entidad);

        // 3. Convertir Entidad a DTO para la respuesta
        return convertEntityToDTO(savedVehiculo);
    }

    public Vehiculo convertDTOToEntity(VehiculoDTO vehiculoDTO) {
        Vehiculo entidad = new Vehiculo();
        entidad.setMarca(vehiculoDTO.marca());
        entidad.setModelo(vehiculoDTO.modelo());
        entidad.setPlaca(vehiculoDTO.placa());
        entidad.setEstado(EstadoVehiculo.valueOf(vehiculoDTO.estado()));

        return entidad;
    }

    public VehiculoDTO convertEntityToDTO(Vehiculo vehiculo){
        return new VehiculoDTO(
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getPlaca(),
                vehiculo.getEstado().name()
        );
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