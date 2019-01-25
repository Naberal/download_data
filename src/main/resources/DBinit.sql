CREATE DATABASE IF NOT EXISTS data;
CREATE TABLE IF NOT EXISTS db_data (
  id             VARCHAR(32)                           NOT NULL UNIQUE PRIMARY KEY,
  hash           VARCHAR(36)                           NOT NULL,
  language       VARCHAR(2),
  format         VARCHAR(100)                          NOT NULL,
  url            TEXT                                  NOT NULL,
  title          VARCHAR(45)                           NOT NULL,
  document_of    ENUM ('tender', 'change', 'contract') NOT NULL,
  date_published DATETIME,
  document_type  VARCHAR(45),
  date_modified  DATETIME,
  related_item   BINARY(32)
);
