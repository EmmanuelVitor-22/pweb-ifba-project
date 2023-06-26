package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.request.ConsultaDTO;
import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<?> agendarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        try {
            consultaService.agendarConsulta(consultaDTO.paciente().getId(), consultaDTO.medico().getId(),consultaDTO.data_hora());
            return ResponseEntity.ok("Consulta agendada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
