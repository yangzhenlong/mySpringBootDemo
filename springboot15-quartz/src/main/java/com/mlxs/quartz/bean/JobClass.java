package com.mlxs.quartz.bean;

import javax.persistence.*;

/**
 * JobClass类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/22
 */
@Entity
@Table(name = "job_class")
public class JobClass {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(name = "fullClass")
    private String fullClass;//类全名：包+类

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullClass() {
        return fullClass;
    }

    public void setFullClass(String fullClass) {
        this.fullClass = fullClass;
    }
}
