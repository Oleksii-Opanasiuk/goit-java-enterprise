package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public class Professional extends Employee {

    /**
     * @param name First Name
     * @param sname Second Name
     * @param occupation Occupation
     * @param experience Experience
     */
    public Professional(String name, String sname, String occupation, int experience) {
        super(name, sname, occupation);
        this.experience = experience;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Professional: {" +
                "\n\tFirst Name: '" + name + "'" +
                "\n\tSecond Name: '" + sname + "'" +
                "\n\tProfessional Occupation: '" + occupation + "'" +
                "\n\tProfessional Experience: " + experience +
                "\n}";
    }

    /**
     * int
     */
    private int experience;
}