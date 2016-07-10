package com.gojavaonline.module2.homework1;

/**
 * Created by oleksii.opanasiuk.
 */
public class Employee extends Person {

    /**
     * @param name First Name
     * @param sname Second Name
     * @param occupation Occupation
     */
    public Employee(String name, String sname, String occupation) {
        super(name, sname);
        this.occupation = occupation;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Employee: {" +
                "\n\tFirst Name: '" + name + "'" +
                "\n\tSecond Name: '" + sname + "'" +
                "\n\tEmployee occupation: '" + occupation + "'" +
                "\n}";
    }

    protected String occupation;
}
