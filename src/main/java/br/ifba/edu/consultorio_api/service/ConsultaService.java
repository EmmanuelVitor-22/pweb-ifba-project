package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.request.ConsultaDTO;
import br.ifba.edu.consultorio_api.dto.response.MedicoResponseDTO;
import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.ConsultaRepository;
import br.ifba.edu.consultorio_api.repository.MedicoRepository;
import br.ifba.edu.consultorio_api.repository.PacienteRepository;
import br.ifba.edu.consultorio_api.utils.MedicoUtilRandon;
import br.ifba.edu.consultorio_api.validation.*;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ConsultaService {
    private ConsultaRepository consultaRepository;
    private PacienteRepository pacienteRepository;
    private MedicoRepository medicoRepository;

    // Injeção de dependência dos repositórios via construtor
    public ConsultaService(ConsultaRepository consultaRepository,
                           PacienteRepository pacienteRepository,
                           MedicoRepository medicoRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public void agendarConsulta(Long idPaciente, Long idMedico, LocalDateTime dataHora) {
        // Verificar se a clínica está aberta
        DayOfWeek diaSemana = dataHora.getDayOfWeek();
        LocalTime horarioAbertura = LocalTime.of(7, 0);
        LocalTime horarioFechamento = LocalTime.of(19, 0);
        if (diaSemana == DayOfWeek.SUNDAY || dataHora.toLocalTime().isBefore(horarioAbertura) || dataHora.toLocalTime().isAfter(horarioFechamento)) {
            throw new RuntimeException("As consultas só podem ser agendadas de segunda a sábado, entre 07:00 e 19:00.");
        }

        // Verificar se a duração da consulta é válida
        LocalDateTime horaTermino = dataHora.plusHours(1);
        if (horaTermino.toLocalTime().isAfter(horarioFechamento)) {
            throw new RuntimeException("A duração da consulta excede o horário de funcionamento da clínica.");
        }

        // Verificar se a consulta está sendo agendada com antecedência mínima
        LocalDateTime antecedenciaMinima = LocalDateTime.now().plusMinutes(30);
        if (dataHora.isBefore(antecedenciaMinima)) {
            throw new RuntimeException("A consulta deve ser agendada com pelo menos 30 minutos de antecedência.");
        }

        // Verificar se o paciente está ativo
        Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente não encontrado."));
        if (!paciente.isStatus()) {
            throw new RuntimeException("Pacientes inativos não podem agendar consultas.");
        }

        // Verificar se o médico está ativo
        Medico medico = medicoRepository.findById(idMedico).orElseThrow(() -> new RuntimeException("Médico não encontrado."));
        if (!medico.isStatus()) {
            throw new RuntimeException("Médicos inativos não podem ser agendados para consultas.");
        }

        // Verificar se o paciente já possui uma consulta no mesmo dia
        LocalDate dataConsulta = dataHora.toLocalDate();
        List<Consulta> consultasExistentes = consultaRepository.findByPacienteAndData(paciente, dataHora);
        if (!consultasExistentes.isEmpty()) {
            throw new RuntimeException("O paciente já possui uma consulta agendada para o mesmo dia.");
        }

        // Verificar se o médico já possui uma consulta na mesma data e hora
        List<Consulta> consultasMedico = consultaRepository.findByMedicoAndData_Hora(medico, dataHora);
        if (!consultasMedico.isEmpty()) {
            throw new RuntimeException("O médico já possui uma consulta agendada na mesma data e hora.");
        }

        // Se nenhum médico específico for escolhido, selecionar aleatoriamente um médico disponível na data e hora especificadas
        if (idMedico == null) {
            List<Medico> medicosDisponiveis = medicoRepository.findAllByStatusTrue(); // Obtém todos os médicos ativos

            List<Medico> medicosDisponiveisNaDataHora = new ArrayList<>();

            for (Medico medico1 : medicosDisponiveis) {
                // Verifica se o médico não possui outra consulta na mesma data e hora
                List<Consulta> consultas = consultaRepository.findByMedicoAndData_Hora(medico1, dataHora);
                if (consultasMedico.isEmpty()) {
                    medicosDisponiveisNaDataHora.add(medico1);
                }
            }

            if (medicosDisponiveisNaDataHora.isEmpty()) {
                throw new RuntimeException("Não há médicos disponíveis na data e hora especificadas.");
            }

            Random random = new Random();
            int indiceMedico = random.nextInt(medicosDisponiveisNaDataHora.size());
            medico = medicosDisponiveisNaDataHora.get(indiceMedico);
        }


        // Criar e salvar a consulta
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setData_hora(dataHora);
        consultaRepository.save(consulta);

    }


    private List<MedicoResponseDTO> buscarMedicosDisponiveis(LocalDateTime dataHora) {
        List<Medico> medicos = medicoRepository.findAll();
        List<MedicoResponseDTO> medicosResponse = new ArrayList<>();

        for (Medico medico : medicos) {
            MedicoResponseDTO medicoResponse = new MedicoResponseDTO(medico);
            medicosResponse.add(medicoResponse);
        }

// Agora você pode usar a lista de objetos MedicoResponseDTO
// para a lógica desejada
// Por exemplo, retornar a lista no ResponseEntity
        return ResponseEntity.ok(medicosResponse).getBody();

    }

    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.findAll();
    }

//    public List<Consulta> listarConsultasPorData(LocalDateTime localDateTime) {
//        return consultaRepository.findByData(localDateTime);
//    }

    public List<Consulta> listarConsultasPorMedico(Long medicoId) {
        Optional<Medico> medico = medicoRepository.findById(medicoId);
        return consultaRepository.findByMedico(medico);
    }

    public List<Consulta> listarConsultasPorPaciente(Long pacienteId) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        return consultaRepository.findByPaciente(paciente);
    }


}
