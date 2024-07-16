INSERT INTO USUARIO(nome, email, senha) VALUES('Aline', 'aline@gmail.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');  -- senha 123456

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Back-end');
INSERT INTO CURSO(nome, categoria) VALUES('React', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Flyway não inicia', 'Erro ao criar o banco de dados', '2024-07-01 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Erro ao Criar entidades', 'Não gera minhas tabelas no banco de dados', '2024-07-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES('Instalação do NodeJs', 'Node não detectado', '2024-07-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);