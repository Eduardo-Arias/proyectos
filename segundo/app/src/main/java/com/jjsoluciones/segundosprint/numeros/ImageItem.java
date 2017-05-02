package com.jjsoluciones.segundosprint.numeros;

/**
 * Created by Marili Arevalo on 16/03/2017.
 */

public class ImageItem {

    private int id;
    private String description;

    public ImageItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public ImageItem(){
        this(0,"");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}
