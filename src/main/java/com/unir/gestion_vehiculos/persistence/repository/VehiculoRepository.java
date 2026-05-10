package com.unir.gestion_vehiculos.persistence.repository;

import com.unir.gestion_vehiculos.persistence.entity.EstadoVehiculo;
import com.unir.gestion_vehiculos.persistence.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    List<Vehiculo> findByMarca(String marca);
    List<Vehiculo> findByModelo(String modelo);
    List<Vehiculo> findByEstado(EstadoVehiculo estado);
}
