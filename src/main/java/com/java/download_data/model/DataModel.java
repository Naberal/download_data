package com.java.download_data.model;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * Class model for data
 *
 * @author Khmelyar Volodymyr
 */

@Data
@Entity
@Table(schema = "data", name = "db_data")
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
    @Column(name = "document_of")
    @Enumerated(EnumType.STRING)
    private DocumentOf documentOf;
    @Column(name = "date_published")
    private OffsetDateTime datePublished;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "date_modified")
    private OffsetDateTime dateModified;
    @Column(name = "related_item")
    private String relatedItem;
}
