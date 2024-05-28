package com.example.demoDepoloyment.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cinema")
@SQLDelete(sql = "update cinema set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Cinema{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String address;

    private boolean deleted = Boolean.FALSE;

}
