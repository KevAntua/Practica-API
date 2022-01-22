package com.veterinaria.mascotas.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaria.mascotas.entitys.Mascota;

public interface MascotasDAO extends JpaRepository<Mascota, Integer>{

}
