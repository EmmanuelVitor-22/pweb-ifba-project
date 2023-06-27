package br.ifba.edu.consultorio_api.validation;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import jakarta.validation.ValidationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaValidation {

    public static void validarConsultaUnicaPorDia(Paciente paciente, LocalDate dataConsulta, List<Consulta> consultas) {
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equals(paciente) && consulta.getDataHora().toLocalDate().equals(dataConsulta)) {
                throw new ValidationException("Não é possível agendar a consulta. Já existe uma consulta marcada para o paciente nesse dia.");
            }
        }
    }
    public static void validarMedicoDisponivel(Medico medico, LocalDateTime dataHoraConsulta, List<Consulta> consultas) {
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) && consulta.getDataHora().equals(dataHoraConsulta)) {
                throw new ValidationException("Não é possível agendar a consulta. O médico já possui outra consulta agendada na mesma data/hora.");
            }
        }
    }



}


