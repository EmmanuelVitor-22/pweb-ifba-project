package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.response.ConsultaResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.cancel.ConsultaCancelDTO;
import br.ifba.edu.consultorio_api.dto.request.create.ConsultaCreateDTO;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;

import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.ConsultaRepository;
import br.ifba.edu.consultorio_api.repository.MedicoRepository;
import br.ifba.edu.consultorio_api.repository.PacienteRepository;

import br.ifba.edu.consultorio_api.validation.AntecedenciaMinimaValidation;
import br.ifba.edu.consultorio_api.validation.HorarioFuncionamentoValidation;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public ConsultaResponseDTO agendarConsulta(ConsultaCreateDTO consultaCreateDTO) {
        HorarioFuncionamentoValidation.validarHorarioFuncionamento(consultaCreateDTO.dataHora());
        AntecedenciaMinimaValidation.validarAntecedenciaMinima(consultaCreateDTO.dataHora());
        validarSePacienteJaTemConsultaNoDiaEHora(consultaCreateDTO);
        validarSeMedicoJaTemConsultaNoDiaEHora(consultaCreateDTO);
        Medico medico = adicionarMedico(consultaCreateDTO);

        Paciente paciente = pacienteRepository.findById(consultaCreateDTO.pacienteId())
                                              .orElseThrow(() -> new ValidationException("Paciente não encontrado"));
        if (!paciente.isStatus()){
            throw new ValidationException("Paciente não está ativo");
        }

        Consulta consulta = new Consulta();

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(consultaCreateDTO.dataHora());
        consulta.setStatus(true);

        consulta =  consultaRepository.save(consulta);

        ConsultaResponseDTO consultaResponseDTO = new ConsultaResponseDTO(consulta);

        return consultaResponseDTO;
    }
    public ConsultaResponseDTO cancelarConsulta (ConsultaCancelDTO consultaCancelDTO){
        Consulta consulta = consultaRepository.findById(consultaCancelDTO.consultaId())
                                              .orElseThrow(() -> new ValidationException("Consulta não encontrada"));
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getDataHora()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidationException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");
        }
        consulta.setCancelamento(consultaCancelDTO.cancelamento());
        consulta.setStatus(false);
        consultaRepository.save(consulta);
        return  null;
    }
    public Medico adicionarMedico(ConsultaCreateDTO consultaCreateDTO) {
       //verifica se o medico foi inserido (manualmente)
        if (consultaCreateDTO.medicoId() != null){
            Medico medico = medicoRepository.findById(consultaCreateDTO.medicoId())
                    .orElseThrow(() -> new ValidationException("Medico não encontrado"));

            if (!medico.isStatus()){
                throw new ValidationException("Medico não está ativo");
            }
            return medico;
        }
       return  medicoRepository.medicoAleatorioLivreNaData(consultaCreateDTO.dataHora())
                               .orElseThrow(() -> new ValidationException("Não existe medicos disponiveis"));
    }

    //validar paciente;
    public void validarSePacienteJaTemConsultaNoDiaEHora(ConsultaCreateDTO consultaCreateDTO) {
        LocalDateTime primeiroHorario = consultaCreateDTO.dataHora().withHour(7);
        LocalDateTime ultimoHorario = consultaCreateDTO.dataHora().withHour(18);
        Boolean pacientePossuiOutraConsultaNoDia = consultaRepository.existsByCancelamentoNullAndPacienteIdAndDataHoraBetween(consultaCreateDTO.pacienteId(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidationException("Paciente já possui uma consulta agendada nesse dia");
        }
    }
    public void  validarSeMedicoJaTemConsultaNoDiaEHora(ConsultaCreateDTO consultaCreateDTO){
        if(consultaRepository.existsByMedicoIdAndDataHoraAndCancelamentoIsNull(consultaCreateDTO.medicoId(),consultaCreateDTO.dataHora())){
            throw new ValidationException("Médico ja possui outra consulta agendada nesse mesmo horário");
        }
    }
    public ResponseEntity<List<ConsultaResponseDTO>> listarTudo(){
        return ResponseEntity.ok( consultaRepository.findAll().stream().map(ConsultaResponseDTO::new).collect(Collectors.toList()));
    }

}
