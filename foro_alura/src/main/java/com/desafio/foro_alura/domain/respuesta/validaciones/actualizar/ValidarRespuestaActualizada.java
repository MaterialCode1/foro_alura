package com.desafio.foro_alura.domain.respuesta.validaciones.actualizar;

import com.desafio.foro_alura.domain.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}
