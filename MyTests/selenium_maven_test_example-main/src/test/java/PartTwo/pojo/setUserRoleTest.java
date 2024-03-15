package PartTwo.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class setUserRoleTest {
    @Test
    public void setRoleTest() throws IOException {

        Role role1 = new Role();
        role1.setId(3);
        role1.setRole("ROLE_ADMIN");

        Role role2 = new Role();
        role2.setId(3);
        role2.setRole("ROLE_ADMIN");

        Role role3 = new Role();
        role3.setId(2);
        role3.setRole("ROLE_USER");

        Role role4 = new Role();
        role4.setId(3);
        role4.setRole("ROLE_ADMIN");

        System.out.println(role1);
        System.out.println(role2);
        System.out.println(role3);
        System.out.println(role4);

        // Рефлексивность
        System.out.println("Рефлексинвость (role1.equals(role1))- " + role1.equals(role1));


// Симметричность
        System.out.println("Симметричность (role1.equals(role2)) - " + role1.equals(role2)); // true
        System.out.println("Симметричность (role2.equals(role1)) - " + role2.equals(role1)); // true

// Транзитивность
        System.out.println("Транзитивность (role1.equals(role2)) - " + role1.equals(role2)); // true
        System.out.println("Транзитивность (role2.equals(role4)) - " + role2.equals(role4)); // true
        System.out.println("Транзитивность (role1.equals(role4)) - " + role1.equals(role4)); // true

// Консистентность
        System.out.println("Консистентность (role1.equals(role2)) - " + role1.equals(role2)); // true
        System.out.println("Консистентность (role1.equals(role2) - " + role1.equals(role2)); // true

// Условие NULL
        System.out.println("Условие NULL (role1.equals(null)) - " + role1.equals(null)); // false


        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("target/role.json"), role1);
        Role createRole =  objectMapper.readValue(new File("target/role.json"), Role.class);
        System.out.println(createRole);
    }

}
