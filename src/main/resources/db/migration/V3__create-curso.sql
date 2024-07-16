CREATE TABLE curso (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  categoria varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;