package br.ifba.edu.consultorio_api.dto.request.update;
import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Paciente;


public record PacienteUpdateDTO(
                String nome,

                String telefone,

                Endereco endereco

) {
        public PacienteUpdateDTO(Paciente paciente) {
                this(
                                paciente.getNome(),
                                paciente.getTelefone(),
                                paciente.getEndereco()
                                );
        }
}