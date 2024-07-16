CREATE TABLE topico (

  id bigint(20) NOT NULL AUTO_INCREMENT,
  data_criacao datetime(6) DEFAULT NULL,
  mensagem varchar(255) DEFAULT NULL,
  status enum('FECHADO','NAO_RESPONDIDO','NAO_SOLUCIONADO','SOLUCIONADO') DEFAULT NULL,
  titulo varchar(255) DEFAULT NULL,
  autor_id bigint(20) DEFAULT NULL,
  curso_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY `FK_autor_id` (autor_id),
  KEY `FK_curso_id` (curso_id),
  CONSTRAINT `FK_autor_id` FOREIGN KEY (autor_id) REFERENCES usuario (id),
  CONSTRAINT `FK_curso_id` FOREIGN KEY (curso_id) REFERENCES curso (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;