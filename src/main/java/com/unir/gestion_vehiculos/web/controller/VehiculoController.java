package com.unir.gestion_vehiculos.web.controller;

import com.unir.gestion_vehiculos.dto.VehiculoDTO;
import com.unir.gestion_vehiculos.persistence.entity.EstadoVehiculo;
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
        return vehiculoService.getVehiculoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Vehiculo> actualizar(@RequestBody Vehiculo vehiculo) {
        if (Boolean.TRUE.equals(this.vehiculoService.exists(vehiculo.getId()))) {
            this.vehiculoService.updateVehiculo(vehiculo);
            return ResponseEntity.ok(vehiculo);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        vehiculoService.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/marca")
    public List<Vehiculo> porMarca(@RequestParam String marca) {
        return vehiculoService.getVehiculosByMarca(marca);
    }

    @GetMapping("/buscar/modelo")
    public List<Vehiculo> porModelo(@RequestParam String modelo) {
        return vehiculoService.getVehiculosByModelo(modelo);
    }

    @GetMapping("/buscar/placa")
    public List<Vehiculo> porPlaca(@RequestParam String placa) {
        return vehiculoService.getVehiculosByPlaca(placa);
    }

    @GetMapping("/buscar/estado")
    public List<Vehiculo> porEstado(@RequestParam String estado) {
        return vehiculoService.getVehiculosByEstadoDelVehiculo(EstadoVehiculo.valueOf(estado));
    }

}
