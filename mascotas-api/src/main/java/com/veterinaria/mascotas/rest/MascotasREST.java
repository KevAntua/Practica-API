package com.veterinaria.mascotas.rest;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.mascotas.dao.MascotasDAO;
import com.veterinaria.mascotas.entitys.Mascota;

@RestController //Indica que será un servicio REST
@RequestMapping("mascotas") //Indica la dirección URL donde sse expondran los servicios
public class MascotasREST {

	@Autowired
	private MascotasDAO mascotaDAO; 

	//@GetMapping //Estara exponiendose en localhost:8080
    //@RequestMapping(value="hello",method=RequestMethod.GET )
	
	@GetMapping
	public ResponseEntity<List<Mascota>> getMascota(){
		List<Mascota> mascotas = mascotaDAO.findAll();
		return ResponseEntity.ok(mascotas);
	}
	
	@RequestMapping(value="{codigoRegistro}",method=RequestMethod.GET )
	public ResponseEntity<Mascota> getMascotaById(@PathVariable("codigoRegistro") Integer codigoRegistro){
		Optional<Mascota> existenciaMascota = mascotaDAO.findById(codigoRegistro);
		
		if(existenciaMascota.isPresent()){
			return ResponseEntity.ok(existenciaMascota.get());	
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Mascota> nuevoRegistroMascota(@RequestBody Mascota mascota){
		Mascota nuevaMascota = mascotaDAO.save(mascota);
		return ResponseEntity.ok(nuevaMascota);
	}
	
	@DeleteMapping(value="{codigoRegistro}")
	public ResponseEntity<Void> eliminarRegistroMascota(@PathVariable("codigoRegistro") Integer codigoRegistro){
		mascotaDAO.deleteById(codigoRegistro);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Mascota> actualizarRegistroMascota(@RequestBody Mascota mascota){
			Optional<Mascota> existenciaMascota = mascotaDAO.findById(mascota.getCodigoRegistro());
			
			if(existenciaMascota.isPresent()){
				Mascota actualizarMascota = existenciaMascota.get();
				actualizarMascota.setNombreMascota(mascota.getNombreMascota());
				actualizarMascota.setTipoMascota(mascota.getTipoMascota());
				actualizarMascota.setEdadMascota(mascota.getEdadMascota());
				actualizarMascota.setNombreDueño(mascota.getNombreDueño());
				mascotaDAO.save(actualizarMascota);
				return ResponseEntity.ok(actualizarMascota);	
			}else {
				return ResponseEntity.notFound().build();
			}	
	}
}
