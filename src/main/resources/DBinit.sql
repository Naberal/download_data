CREATE DATABASE IF NOT EXISTS data;
CREATE TABLE IF NOT EXISTS db_data (
  id            VARCHAR(32)                            NOT NULL UNIQUE PRIMARY KEY,
  hash          VARCHAR(36)                           NOT NULL UNIQUE,
  language      VARCHAR(2),
  format        VARCHAR(36)                           NOT NULL,
  url           TEXT                                  NOT NULL,
  title         VARCHAR(45)                           NOT NULL,
  documentOf    ENUM ('tender', 'change', 'contract') NOT NULL,
  datePublished DATETIME,
  documentType  VARCHAR(45),
  dateModified  DATETIME,
  relatedItem   BINARY(32)
);