package com.in28minutes.course.masterspringcloud.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    // The correct way to prevent circular object reference
////    @JsonBackReference
    // Ignore the object when parsin. A simple way preventing circular object reference
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
