package com.java.download_data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(schema = "data", name = "db_Data")
public class DataModel {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "hash")
    private String hash;
    @Column(name = "language")
    private String language;
    @Column(name = "format")
    private String format;
    @Column(name = "url")
    private String url;
    @Column(name = "title")
    private String title;
    @Column(name = "documentOf")
    private DocumentOf documentOf;
    @Column(name = "datePublished")
    private OffsetDateTime datePublished;
    @Column(name = "documentType")
    private String documentType;
    @Column(name = "dateModified")
    private OffsetDateTime dateModified;
    @Column(name = "relatedItem")
    private String relatedItem;
}
