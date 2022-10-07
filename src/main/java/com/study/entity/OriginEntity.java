package com.study.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="origin")
public class OriginEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iphone;
    @Basic
    @Column(name ="name")
    private String name;

    private String manager;

    private String applyyear;
    private String applytype;


    public String getApplytype() {
        return applytype;
    }

    public void setApplytype(String applytype) {
        this.applytype = applytype;
    }

    public Long getId() {
        return id;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getApplyyear() {
        return applyyear;
    }

    public void setApplyyear(String applyyear) {
        this.applyyear = applyyear;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
