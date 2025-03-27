package com.SalvadorICAI.intercambios.Controller;

import com.SalvadorICAI.intercambios.Modelo.ModeloMensaje;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")

@RestController
public class ControladorRest {
    private final Map<Long, ModeloMensaje> mensajes = new HashMap<>();

    //Tengo que hacer que cada mensaje que se cree tenga un id único para luego poder buscarlo.
    private long idActual = 1;

    @PostMapping("/api/mensajes")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloMensaje crearMensaje(@Valid @RequestBody ModeloMensaje mensajeSinId) { // el @Valid se pone en la query que te llega
        ModeloMensaje mensajeConId = new ModeloMensaje(idActual, mensajeSinId.correo(),mensajeSinId.contenido());
        mensajes.put(idActual,mensajeConId);
        idActual ++;
        return mensajeConId;
    }

    //voy a hacer dos tipos de get: que te coja un mensaje en concreto, y que te coja todos los mensajes

    //1º: Le voy a poner que este tipo de get solo lo pueda hacer un usuario con permisos espciales de ADMIN
    @GetMapping("/api/mensajes")
    public List<ModeloMensaje> listarMensajes() {
        return new ArrayList<>(mensajes.values());
    }
    //2º:buscar yn mensaje por id
    @GetMapping("/api/mensajes/{id}")
    public ModeloMensaje obtenerMensaje(@PathVariable Long id) {

        return mensajes.get(id);
    }

    @PutMapping("/api/mensajes/{id}")
    public ModeloMensaje actualizarMensaje(@PathVariable Long id,
                                     @RequestBody ModeloMensaje datosActualizados) {
        if(mensajes.containsKey(id)){
            ModeloMensaje actualizado = new ModeloMensaje(id, datosActualizados.correo(),datosActualizados.contenido());
            mensajes.put(id,actualizado);
            return actualizado;
        }
        return null;
    }
    @DeleteMapping("/api/mensajes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarMensaje(@PathVariable Long id){
        mensajes.remove(id);
    }

}
