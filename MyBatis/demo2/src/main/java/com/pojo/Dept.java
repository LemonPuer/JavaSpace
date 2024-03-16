package com.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-21-11:06
 */
public class Dept implements Serializable {
    private int deptId;
    private String name;
    private List<Emp> emps;

    public Dept() {
    }

    public Dept(int deptId) {
        this.deptId = deptId;
    }

    public Dept(int deptId, String name, List<Emp> emps) {
        this.deptId = deptId;
        this.name = name;
        this.emps = emps;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
