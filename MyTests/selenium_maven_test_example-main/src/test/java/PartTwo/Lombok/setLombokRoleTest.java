package PartTwo.Lombok;

import org.junit.jupiter.api.Test;

public class setLombokRoleTest {
    @Test
    public void setRoleTest(){

        Lombok role1 = new Lombok();
        role1.setId(3);
        role1.setRole("ROLE_ADMIN");

        Lombok role2 = new Lombok();
        role2.setId(3);
        role2.setRole("ROLE_ADMIN");

        Lombok role3 = new Lombok();
        role3.setId(2);
        role3.setRole("ROLE_USER");

        Lombok role4 = new Lombok();
        role4.setId(3);
        role4.setRole("ROLE_ADMIN");

        System.out.println(role1);
        System.out.println(role2);
        System.out.println(role3);
        System.out.println(role4);


    }

}
