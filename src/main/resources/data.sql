-- Onde serão feitas os inserts

-- Inserções na tabela "paciente"
INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Alice Oliveira', 'alice.oliveira@email.com', '(11) 11111-1111', '851.327.170-55', TRUE, 'Rua dos Flores', '123', 'Apto 4A', 'Centro', 'São Paulo', 'SP', '01000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Bruno Santos', 'bruno.santos@email.com', '(22) 22222-2222', '976.671.230-12', TRUE, 'Avenida das Palmeiras', '456', 'Casa 2', 'Jardim Botânico', 'Rio de Janeiro', 'RJ', '20000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Carolina Silva', 'carolina.silva@email.com', '(33) 33333-3333', '976.671.230-12', FALSE, 'Rua dos Coqueiros', '789', 'Bloco B', 'Vila Bela', 'Belo Horizonte', 'MG', '30000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Daniel Costa', 'daniel.costa@email.com', '(44) 44444-4444', '976.671.230-12', TRUE, 'Alameda dos Ipês', '1010', 'Casa 1', 'Jardim das Flores', 'Curitiba', 'PR', '80000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Evelyn Santos', 'evelyn.santos@email.com', '(55) 55555-5555', '555.555.555-55', TRUE, 'Rua das Acácias', '222', 'Apto 3C', 'Nova Esperança', 'Porto Alegre', 'RS', '90000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Felipe Almeida', 'felipe.almeida@email.com', '(66) 66666-6666', '666.666.666-66', TRUE, 'Travessa das Oliveiras', '789', 'Casa 5', 'Centro', 'Florianópolis', 'SC', '88000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Gabriela Pereira', 'gabriela.pereira@email.com', '(77) 77777-7777', '777.777.777-77', TRUE, 'Avenida das Rosas', '456', 'Bloco C', 'Jardim das Flores', 'Salvador', 'BA', '40000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Hugo Rodrigues', 'hugo.rodrigues@email.com', '(88) 88888-8888', '888.888.888-88', TRUE, 'Rua dos Girassóis', '1010', 'Apto 2B', 'Vila Nova', 'Recife', 'PE', '50000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Isabella Lima', 'isabella.lima@email.com', '(99) 99999-9999', '999.999.999-99', TRUE, 'Alameda dos Ipês', '222', 'Casa 3', 'Jardim Botânico', 'Natal', 'RN', '59000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('João Santos', 'joao.santos@email.com', '(44) 12345-6789', '123.456.789-10', TRUE, 'Rua das Flores', '123', 'Apto 4A', 'Centro', 'São Paulo', 'SP', '01000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Lara Oliveira', 'lara.oliveira@email.com', '(11) 98765-4321', '234.567.890-12', TRUE, 'Avenida das Palmeiras', '456', 'Casa 2', 'Jardim Botânico', 'Rio de Janeiro', 'RJ', '20000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Marcelo Silva', 'marcelo.silva@email.com', '(22) 65432-1098', '345.678.901-23', FALSE, 'Rua dos Coqueiros', '789', 'Bloco B', 'Vila Bela', 'Belo Horizonte', 'MG', '30000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Natália Costa', 'natalia.costa@email.com', '(33) 98765-4321', '456.789.012-34', TRUE, 'Alameda dos Ipês', '1010', 'Casa 1', 'Jardim das Flores', 'Curitiba', 'PR', '80000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Otávio Santos', 'otavio.santos@email.com', '(44) 12345-6789', '567.890.123-45', TRUE, 'Rua das Acácias', '222', 'Apto 3C', 'Nova Esperança', 'Porto Alegre', 'RS', '90000-000');

INSERT INTO paciente (nome, email, telefone, cpf, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Patrícia Almeida', 'patricia.almeida@email.com', '(55) 65432-1098', '678.901.234-56', FALSE, 'Travessa das Oliveiras', '789', 'Casa 5', 'Centro', 'Florianópolis', 'SC', '88000-000');



-- Inserções na tabela "medicos" INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. João Silva', 'joao.silva@example.com', '(11) 98765-4321', '12345/SP', 'Ortopedia', TRUE, 'Rua A', '123', 'Apto 4', 'Centro', 'São Paulo', 'SP', '01234-567');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dra. Maria Souza', 'maria.souza@example.com', '(21) 99999-8888', '54321/RJ', 'Cardiologia', FALSE, 'Avenida B', '456', 'Casa 2', 'Botafogo', 'Rio de Janeiro', 'RJ', '20000-123');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. Pedro Santos', 'pedro.santos@example.com', '(31) 12345-6789', '98765/MG', 'Ginecologia', TRUE, 'Rua C', '789', NULL, 'Liberdade', 'Belo Horizonte', 'MG', '30000-456');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dra. Ana Costa', 'ana.costa@example.com', '(41) 22222-3333', '45678/PR', 'Dermatologia', FALSE, 'Avenida D', '987', NULL, 'Centro', 'Curitiba', 'PR', '80000-789');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. Lucas Oliveira', 'lucas.oliveira@example.com', '(51) 77777-8888', '98765/RS', 'Ortopedia', TRUE, 'Rua E', '654', 'Sala 3', 'Barra da Tijuca', 'Porto Alegre', 'RS', '90000-321');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dra. Carolina Almeida', 'carolina.almeida@example.com', '(71) 44444-5555', '54321/BA', 'Cardiologia', TRUE, 'Avenida F', '321', NULL, 'Centro', 'Salvador', 'BA', '40000-654');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. Ricardo Pereira', 'ricardo.pereira@example.com', '(81) 33333-4444', '12345/PE', 'Ginecologia', TRUE, 'Rua G', '258', 'Casa 1', 'Boa Viagem', 'Recife', 'PE', '50000-987');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dra. Fernanda Lima', 'fernanda.lima@example.com', '(98) 55555-6666', '54321/MA', 'Dermatologia', TRUE, 'Avenida H', '753', NULL, 'Centro', 'São Luís', 'MA', '65000-456');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. Gabriel Costa', 'gabriel.costa@example.com', '(91) 77777-8888', '98765/PA', 'Ortopedia', FALSE, 'Rua I', '369', 'Apto 7', 'Nazaré', 'Belém', 'PA', '66000-789');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dra. Beatriz Santos', 'beatriz.santos@example.com', '(48) 99999-0000', '54321/SC', 'Cardiologia', TRUE, 'Avenida J', '987', NULL, 'Centro', 'Florianópolis', 'SC', '88000-321');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. Leonardo Oliveira', 'leonardo.oliveira@example.com', '(84) 11111-2222', '12345/RN', 'Ginecologia', FALSE, 'Rua K', '741', 'Casa 3', 'Tirol', 'Natal', 'RN', '59000-654');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dra. Camila Gomes', 'camila.gomes@example.com', '(65) 33333-4444', '54321/MT', 'Dermatologia', TRUE, 'Avenida L', '852', NULL, 'Centro', 'Cuiabá', 'MT', '78000-987');

INSERT INTO medico (nome, email, telefone, crm, especialidade, status, logradouro, numero, complemento, bairro, cidade, uf, cep)
VALUES ('Dr. Rafael Alves', 'rafael.alves@example.com', '(62) 55555-6666', '98765/GO', 'Ortopedia', TRUE, 'Rua M', '963', 'Casa 5', 'Setor Oeste', 'Goiânia', 'GO', '74000-456');


-- Inserções na tabela "consulta"
INSERT INTO consulta ( data_hora, status, paciente_id, medico_id)
VALUES ('2023-06-23 10:00:00', TRUE, 1, 1),
       ('2023-06-24 14:30:00', TRUE, 2, 2),
       ('2023-06-25 16:00:00', TRUE, 3, 3),
       ('2023-06-26 09:15:00', TRUE, 4, 4),
       ('2023-06-27 11:30:00', TRUE, 5, 5),
       ( '2023-06-28 15:45:00', FALSE, 6, 6),
       ( '2023-06-29 17:30:00', FALSE, 7, 7),
       ( '2023-06-30 10:45:00', FALSE, 8, 8),
       ( '2023-07-01 14:00:00', FALSE, 9, 9),
       ( '2023-07-02 16:30:00', FALSE, 10, 10);

