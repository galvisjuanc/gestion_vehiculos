package com.unir.gestion_vehiculos.service;

import com.unir.gestion_vehiculos.dto.VehiculoDTO;
import com.unir.gestion_vehiculos.persistence.entity.EstadoVehiculo;
import com.unir.gestion_vehiculos.persistence.entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VehiculoService {

    List<Vehiculo> getVehiculos();

    VehiculoDTO saveVehiculo(VehiculoDTO vehiculoDTO);

    Optional<Vehiculo> getVehiculo(int id);

    void deleteVehiculo(int id);

    List<Vehiculo> getVehiculosByMarca(String marca);

    List<Vehiculo> getVehiculosByModelo(String modelo);

    List<Vehiculo> getVehiculosByPlaca(String placa);

    List<Vehiculo> getVehiculosByEstadoDelVehiculo(EstadoVehiculo estado);
}
