package com.app.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetName() throws Exception {
        mockMvc.perform(get("/api/name"))
               .andExpect(status().isOk())
               .andExpect(content().string("Eugenio"));
    }

    @Test
    void testGetRandom() throws Exception {
        // This test will just check if the endpoint responds with status OK
        mockMvc.perform(get("/api/random"))
               .andExpect(status().isOk());
    }

    @Test
    void testGetAdd() throws Exception {
        mockMvc.perform(get("/api/add"))
               .andExpect(status().isOk())
               .andExpect(content().string("4")); // Expecting the result of 2 + 2
    }
}
