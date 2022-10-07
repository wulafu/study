package com.study.entity;


import javax.persistence.*;

@Entity
@Table(name="activecode")
public class ActiveCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
