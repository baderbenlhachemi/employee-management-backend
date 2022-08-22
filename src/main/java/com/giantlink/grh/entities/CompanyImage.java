package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tbl_company_image")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyImage {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String imageName;
    private String imageLink;
    private String imageType;

    @Lob
    private byte[] imageFile;

    @ManyToOne
    @JsonBackReference(value = "company-companyImage")
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
