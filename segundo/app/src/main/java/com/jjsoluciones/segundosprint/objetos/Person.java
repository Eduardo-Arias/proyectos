package com.jjsoluciones.segundosprint.objetos;

/**
 * Created by jony on 1/2/2017.
 */

public class Person {
    private String name;
    private String age;
    private int pothoId;
    private int cardColor;

    public Person(String name, String age, int pothoId ,int cardColor) {
        this.name = name;
        this.age = age;
        this.pothoId = pothoId;
        this.cardColor=cardColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPothoId() {
        return pothoId;
    }

    public void setPothoId(int pothoId) {
        this.pothoId = pothoId;
    }

    public int getCardColor() {
        return cardColor;
    }

    public void setCardColor(int cardColor) {
        this.cardColor = cardColor;
    }
}
