package br.ifba.edu.consultorio_api.controller;
import br.ifba.edu.consultorio_api.dto.request.cancel.ConsultaCancelDTO;
import br.ifba.edu.consultorio_api.dto.request.create.ConsultaCreateDTO;
import br.ifba.edu.consultorio_api.dto.response.ConsultaResponseDTO;
import br.ifba.edu.consultorio_api.service.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;
    @GetMapping("/listar")
    public ResponseEntity<List<ConsultaResponseDTO>>  listarTudo(){
        return consultaService.listarTudo();
    }
    @PostMapping("/agendar")
    @Transactional
    public ConsultaResponseDTO agendarConsulta(@RequestBody @Valid ConsultaCreateDTO consultaCreateDTO) {
        return consultaService.agendarConsulta(consultaCreateDTO);
    }
    @DeleteMapping("/cancelar")
    @Transactional
    public ConsultaResponseDTO cancelarConsulta(@RequestBody @Valid ConsultaCancelDTO consultaCancelDTO){
        return  consultaService.cancelarConsulta(consultaCancelDTO);
    }

}







