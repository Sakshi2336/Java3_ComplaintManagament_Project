package org.example.java3_final_project.pojo;

/**
 * The Flat class is the table flat from the database and hase 5 class members
 * which are columns from flat table in the database
 */
public class Flat {

    //class members
    private int flat_num; //flat number
    private String description;  //flat short description
    private int hall; //hall number in the flat
    private int bath; //bathroom number in the flat
    private int kitchen; //kitchen in the flat


    /**
     * This will create flat object with following properties
     * @param flat_num flat number
     * @param description flat description
     * @param hall hall number in flat
     * @param bath bathroom in the flat
     * @param kitchen kitchen in flat
     */
    public Flat(int flat_num, String description, int hall, int bath, int kitchen) {
        this.flat_num = flat_num;
        this.description = description;
        this.hall = hall;
        this.bath = bath;
        this.kitchen = kitchen;
    }

    //Getter for flat number
    public int getFlat_num() {
        return flat_num;
    }

    /**
     * This will give string representation of this Flat object
     * @return string presentation of Flat object
     */
    public String toString(){
        return " " + flat_num;
    }
}
