package com.map1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Entity
public class Emp {
    @Id
    private int eid;
    private String name;

    // Define a custom join table using @JoinTable
    @ManyToMany
    @JoinTable(
        name = "emp_project",  // Custom join table name
        joinColumns = {@JoinColumn(name = "eid")},  // Foreign key column in join table
        inverseJoinColumns = {@JoinColumn(name = "pid")}  // Foreign key column in join table for Project
    )
    private List<Project> projects;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp(int eid, String name, List<Project> projects) {
        super();
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }

    public Emp() {
        super();
    }
}
