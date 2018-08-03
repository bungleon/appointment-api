package com.appointment.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentApiApplicationTests {

    private final PasswordEncoder passwordEncoder;

    public AppointmentApiApplicationTests() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void contextLoads() {
        System.out.println(passwordEncoder.encode("72745275"));
    }

}
