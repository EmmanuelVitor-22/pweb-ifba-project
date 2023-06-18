INSERT INTO paciente (nome, CPF, email, telefone)
VALUES ('João Silva', '12345678901', 'joao@example.com', '123456789');

INSERT INTO paciente (nome, CPF, email, telefone)
VALUES ('Maria Souza', '98765432109', 'maria@example.com', '987654321');

INSERT INTO paciente (nome, CPF, email, telefone)
VALUES ('Pedro Santos', '56789012345', 'pedro@example.com', '567890123');

INSERT INTO paciente (nome, CPF, email, telefone)
VALUES ('Ana Oliveira', '54321098765', 'ana@example.com', '543210987');

INSERT INTO paciente (nome, CPF, email, telefone)
VALUES ('Carlos Ferreira', '13579246801', 'carlos@example.com', '135792468');


INSERT INTO medico (nome, CRM, email, telefone, especialidade)
VALUES ('Dr. João', '123456', 'joao.medico@example.com', '123456789', 2);

INSERT INTO medico (nome, CRM, email, telefone, especialidade)
VALUES ('Dra. Maria', '987654', 'maria.medica@example.com', '987654321', 4);

INSERT INTO medico (nome, CRM, email, telefone, especialidade)
VALUES ('Dr. Pedro', '567890', 'pedro.medico@example.com', '567890123', 1);

INSERT INTO medico (nome, CRM, email, telefone, especialidade)
VALUES ('Dra. Ana', '543210', 'ana.medica@example.com', '543210987', 3);

INSERT INTO medico (nome, CRM, email, telefone, especialidade)
VALUES ('Dr. Carlos', '135792', 'carlos.medico@example.com', '135792468', 2);


-- Primeira consulta
INSERT INTO consulta (dia_hora, medico_id, paciente_id)
VALUES ('2023-06-17T10:00:00', 1, 1);

-- Segunda consulta
INSERT INTO consulta (dia_hora, medico_id, paciente_id)
VALUES ('2023-06-18T14:30:00', 2, 2);

-- Terceira consulta
INSERT INTO consulta (dia_hora, medico_id, paciente_id)
VALUES ('2023-06-19T09:45:00', 3, 3);

-- Quarta consulta
INSERT INTO consulta (dia_hora, medico_id, paciente_id)
VALUES ('2023-06-20T16:15:00', 4, 4);

-- Quinta consulta
INSERT INTO consulta (dia_hora, medico_id, paciente_id)
VALUES ('2023-06-21T11:30:00', 5, 5);
