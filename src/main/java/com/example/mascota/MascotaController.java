package com.example.mascota;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mascota> listar() {
        return service.listar();
    }

    @PostMapping
    public Mascota guardar(@RequestBody Mascota mascota) {
        return service.guardar(mascota);
    }

    @GetMapping("/{id}")
    public Mascota buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public Mascota actualizar(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        return service.guardar(mascota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}