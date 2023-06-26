package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.request.ConsultaDTO;
import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.ConsultaRepository;
import br.ifba.edu.consultorio_api.utils.MedicoUtilRandon;
import br.ifba.edu.consultorio_api.validation.*;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    public Consulta agendarConsulta(ConsultaDTO consultaDTO) {
        // Verificar se o paciente está ativo no sistema
        Paciente paciente = pacienteService.buscarPacientePorId(consultaDTO.paciente().getId());
        if (!PacienteValidation.isPacienteAtivo(paciente)) {
            throw new ValidationException("Não é possível agendar a consulta. Paciente inativo.");
        }
        // Verificar se o médico está ativo no sistema
        Medico medico = consultaDTO.medico().getId() != null ? medicoService.buscarMedicoPorId(consultaDTO.medico().getId())
                : null;
        if (consultaDTO.medico().getId() != null && !MedicoValidation.isMedicoAtivo(medico)) {
            throw new ValidationException("Não é possível agendar a consulta. Médico inativo.");
        }
        // Verificar horário de funcionamento da clínica
        HorarioFuncionamentoValidation.validarHorarioFuncionamento(consultaDTO.data_hora().getDayOfWeek(), consultaDTO.data_hora().toLocalTime());
        // Verificar antecedência mínima de agendamento
        AntecedenciaMinimaValidation.validarAntecedenciaMinima(consultaDTO.data_hora());

        // Verificar se o paciente já possui uma consulta no mesmo dia
//        List<Consulta> consultasPaciente = consultaRepository.findByPacienteAndData(paciente, consultaDTO.data_hora().toLocalDate());
//        if (!ConsultaValidation.validarConsultaUnicaPorDia(consultasPaciente)) {
//            throw new ValidationException("Não é possível agendar a consulta. Já existe uma consulta marcada para o paciente nesse dia.");
//        }
        // Verificar se o paciente já possui uma consulta no mesmo dia
        List<Consulta> consultasPaciente = consultaRepository.findByPacienteAndData(paciente, consultaDTO.data_hora());
        ConsultaValidation.validarConsultaUnicaPorDia(paciente, consultaDTO.data_hora().toLocalDate(), consultasPaciente);


        // Verificar se o médico possui outra consulta no mesmo horário

        if (consultaDTO.medico().getId() != null) {
            Medico medicoConsulta = medicoService.buscarMedicoPorId(consultaDTO.medico().getId());
            List<Consulta> consultasMedico = consultaRepository.findByMedicoAndDataHora(medicoConsulta, consultaDTO.data_hora());
            ConsultaValidation.validarMedicoDisponivel(medicoConsulta, consultaDTO.data_hora(), consultasMedico);
        }


//
//        // Caso o médico não tenha sido especificado, escolher aleatoriamente um médico disponível
        if (medico == null) {
            List<Medico> medicosDisponiveis = medicoService.medicoRepository.findByConsultasDataHoraNot(consultaDTO.data_hora());
            if (medicosDisponiveis.isEmpty()) {
                throw new ValidationException("Não é possível agendar a consulta. Não há médicos disponíveis nesse horário.");
            }
            medico = MedicoUtilRandon.escolherMedicoAleatorio(medicosDisponiveis);
        }

//
//        // Agendar a consulta
        Consulta consulta = new Consulta(consultaDTO);
        return consultaRepository.save(consulta);
    }

    }
