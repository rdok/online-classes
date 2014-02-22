package me.dokollari.course.manager;


public class Verify {
    public static final String NAME_REQ = "Only letters of length 1-45 are acceptable";
    public static final String ID_REQ = "ID can consist of integers only";

    public static void checkName(String name) throws Exception {
        if (!name.matches("[a-zA-z]{1,45}")) {
            throw new Exception(NAME_REQ);
        }
    }

    public static void checkID(String name) throws Exception {
        if (!name.matches("[0-9]+")) {
            throw new Exception(ID_REQ);
        }
    }
}
