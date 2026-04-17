package com.example.mascota;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository repo;

    public MascotaService(MascotaRepository repo) {
        this.repo = repo;
    }

    public List<Mascota> listar() {
        return repo.findAll();
    }

    public Mascota guardar(Mascota mascota) {
        return repo.save(mascota);
    }

    public Mascota buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}