package com.unir.gestion_vehiculos.web.controller;

import com.unir.gestion_vehiculos.dto.VehiculoDTO;
import com.unir.gestion_vehiculos.persistence.entity.Vehiculo;
import com.unir.gestion_vehiculos.service.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping
    public ResponseEntity<VehiculoDTO> save(@RequestBody VehiculoDTO vehiculoDTO) {
        return ResponseEntity.ok(vehiculoService.saveVehiculo(vehiculoDTO));
    }

    @GetMapping
    public List<Vehiculo> listarTodos() {
        return vehiculoService.getVehiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> buscarVehiculoPorId(@PathVariable int id) {
        return vehiculoService.getVehiculo(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
