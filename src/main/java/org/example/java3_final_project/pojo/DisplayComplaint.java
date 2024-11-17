package org.example.java3_final_project.pojo;

public class DisplayComplaint {

    private int id;
    private String description;
    private String submit_time;
    private String status;
    private String tenant_name;
    private String flat_num;
    private String manager_name;

    public DisplayComplaint(int id, String description, String submit_time, String status, String tenant_name, String flat_num, String manager_name) {
        this.id = id;
        this.description = description;
        this.submit_time = submit_time;
        this.status = status;
        this.tenant_name = tenant_name;
        this.flat_num = flat_num;
        this.manager_name = manager_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public String getFlat_num() {
        return flat_num;
    }

    public void setFlat_num(String flat_num) {
        this.flat_num = flat_num;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }
}
