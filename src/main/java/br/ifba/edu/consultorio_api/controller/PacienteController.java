package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.PacienteDTO;
import br.ifba.edu.consultorio_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> listaDePacientes() {
        return pacienteService.listarTodosPacientes();
    }

}
