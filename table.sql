CREATE TABLE `USER_T`
(
    `USERNAME`        varchar(20) NOT NULL,
    `PWD`             varchar(20) NOT NULL,
    `TRUENAME`        varchar(20)    DEFAULT NULL,
    `SEX`             varchar(2)     DEFAULT NULL,
    `AGE`             int            DEFAULT NULL,
    `MAJOR`           varchar(20)    DEFAULT NULL,
    `SNO`             varchar(20)    DEFAULT NULL,
    `HIMAGE`          blob,
    `AUTHORITY_ID`    int            DEFAULT NULL,
    `SCORE`           int            DEFAULT 0,
    `TASKTIME`        int            DEFAULT NULL,
    `STARTRANK`       int            DEFAULT NULL,
    `LEVELRANK`       int            DEFAULT NULL,
    `SCORE_AVAILABLE` int            DEFAULT 0,
    `STARRANK`        decimal(38, 0) DEFAULT NULL,
    PRIMARY KEY (`USERNAME`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table task_t
(
    TASK_ID      VARCHAR(20),
    TASK_NAME    VARCHAR(20),
    CONTENT      VARCHAR(2000),
    START_TIME   DATE,
    END_TIME     DATE,
    TASK_SCORE   INT(4) not null,
    TASK_COMMENT VARCHAR(2000),
    START_FLAG   INT,
    primary key (TASK_ID)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table prize_t
(
    PRIZE_ID    VARCHAR(20) primary key,
    PRIZE_NAME  VARCHAR(20),
    PRIZE_IMG   BLOB,
    PRIZE_SCORE INT(4)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table Authority_t
(
    AUTHORITY_ID varchar(20) primary key,
    USERGROUP    varchar(20)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table activity_t
(
    ACTIVITY_ID      varchar(20) primary key,
    ACTIVITY_TITLE   varchar(200) not null,
    ACTIVITY_CONTENT varchar(200)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table publisher_task_t
(
    PUBLISHER_NAME varchar(20),
    TASK_ID        varchar(20) not null,
    UNIQUE KEY `unk_publisher_task_t` (`PUBLISHER_NAME`, `TASK_ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



create table accepter_task_t
(
    ACCEPTER_NAME varchar(20) primary key,
    TASK_ID       varchar(20) not null,
    PROGRESS      int
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table prize_user_t
(
    PRIZE_ID varchar(20) primary key,
    USERNAME varchar(20) not null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;