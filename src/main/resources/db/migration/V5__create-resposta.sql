CREATE TABLE resposta (

  id bigint(20) NOT NULL AUTO_INCREMENT,
  data_criacao datetime(6) DEFAULT NULL,
  mensagem varchar(255) DEFAULT NULL,
  solucao bit(1) DEFAULT NULL,
  autor_id bigint(20) DEFAULT NULL,
  topico_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY `FK_autor_id` (autor_id),
  KEY `FK_topico_id` (topico_id),
  CONSTRAINT `FK_autor_resp_id` FOREIGN KEY (autor_id) REFERENCES usuario (id),
  CONSTRAINT `FK_topico_id` FOREIGN KEY (topico_id) REFERENCES topico (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;