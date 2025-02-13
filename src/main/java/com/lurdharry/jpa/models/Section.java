package com.lurdharry.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Section extends BaseEntity {



    private String name;

    private int sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id ")
    private Course course;

    @OneToMany(
            mappedBy = "section"
    )
    private List<Lecture> lectures;
}
