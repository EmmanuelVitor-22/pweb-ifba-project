package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.request.ConsultaDTO;
import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.ConsultaRepository;
import br.ifba.edu.consultorio_api.repository.MedicoRepository;
import br.ifba.edu.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class ConsultService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    private PacienteRepository pacienteRepository;


    public List<Consulta> listarConsultas() {
        List<Consulta> consultas = consultaRepository.findAll();
        return consultas;
    }

    public ConsultaDTO agendarConsulta(Consulta consulta) {
        // Verificar se paciente e médico existem e estão ativos
        System.out.println("-------- -------- -------- -------- -------- -------- -------- -------- -------- -------- -------- -------- ");

        System.out.println(consulta.getPaciente());

        Optional<Paciente> optionalPaciente = pacienteRepository.findByIdAndStatusTrue(consulta.getPaciente().getId());
        Paciente paciente = optionalPaciente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado ou inativo."));

        Medico medico = null;
        if (consulta.getPaciente().getId() != null) {
            Optional<Medico> optionalMedico = medicoRepository.findByIdAndStatusTrue(consulta.getMedico().getId());
            medico = optionalMedico.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado ou inativo."));
        }


        // Verificar se a data/hora está dentro do horário permitido
        LocalDateTime dataHora = consulta.getData_hora();
        if (dataHora.getDayOfWeek() == DayOfWeek.SUNDAY || dataHora.getHour() < 7 || dataHora.getHour() >= 19) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A consulta deve ser agendada entre segunda e sábado, das 07:00 às 19:00.");
        }

        // Verificar se a data/hora está disponível para o médico
        if (medico != null && consultaRepository.existsByMedicoAndDataHora(medico, dataHora)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "O médico já possui uma consulta agendada na mesma data/hora.");
        }

        // Verificar se o paciente já possui uma consulta agendada no mesmo dia
        if (consultaRepository.existsByPacienteAndDataHoraBetween(paciente, dataHora.toLocalDate().atStartOfDay(), dataHora.toLocalDate().atTime(23, 59, 59))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "O paciente já possui uma consulta agendada para o mesmo dia.");
        }

        // Criar a consulta e salvar no banco de dados
        Consulta consultaData = new Consulta();
        consultaData.setPaciente(paciente);
        consultaData.setMedico(medico);
        consultaData.setData_hora(dataHora);
        consultaData.setStatus(true);
        return consultaRepository.save(consultaData);

    }


}
