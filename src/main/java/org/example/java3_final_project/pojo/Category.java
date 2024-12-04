package org.example.java3_final_project.pojo;


/**
 * The category class has 2 class members that is for columns into category table
 * This class has constructors,getters and setters for category table columns.
 */
public class Category {


    //Class members

    //category id and name
    private int id;
    private String name;


    /**
     * Constructor for category class
     * @param id id for category
     * @param name name of category
     */
    public Category(int id,String name){
        this.id = id;
        this.name = name;
    }


    //getters and setters for category id and name
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
