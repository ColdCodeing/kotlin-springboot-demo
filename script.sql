CREATE TABLE t_token
(
  tid             INT AUTO_INCREMENT
    PRIMARY KEY,
  username        VARCHAR(120) NOT NULL,
  auth_type       VARCHAR(10)  NOT NULL,
  token           VARCHAR(255) NOT NULL,
  expiration_time DATETIME     NULL,
  CONSTRAINT t_token_token_uindex
  UNIQUE (token)
)
  ENGINE = InnoDB;

CREATE TABLE t_user
(
  uid         INT AUTO_INCREMENT
    PRIMARY KEY,
  username    VARCHAR(120)                       NOT NULL,
  password    VARCHAR(120)                       NOT NULL,
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  update_time DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
  CONSTRAINT t_user_username_uindex
  UNIQUE (username)
)
  ENGINE = InnoDB;



