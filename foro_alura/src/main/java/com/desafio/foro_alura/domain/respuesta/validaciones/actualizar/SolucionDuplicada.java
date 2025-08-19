package com.desafio.foro_alura.domain.respuesta.validaciones.actualizar;

import com.desafio.foro_alura.domain.respuesta.ActualizarRespuestaDTO;
import com.desafio.foro_alura.domain.respuesta.Respuesta;
import com.desafio.foro_alura.domain.respuesta.RespuestaRepository;
import com.desafio.foro_alura.domain.topico.Estado;
import com.desafio.foro_alura.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
       if (data.solucion()){
           Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
           var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
           if (topicoResuelto.getEstado() == Estado.CLOSED){
               throw new ValidationException("Este topico ya esta solucionado.");
           }
       }
    }
}


