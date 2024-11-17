package org.example.java3_final_project.pojo;

public class DisplayTenant {

    private String first_name;
    private String last_name;
    private String flat_num;

    public DisplayTenant(String first_name, String last_name, String flat_num) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.flat_num = flat_num;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFlat_num() {
        return flat_num;
    }

    public void setFlat_num(String flat_num) {
        this.flat_num = flat_num;
    }
}
