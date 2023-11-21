package com.demo.person.acceptance;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void TestPeopleWithSameHobby() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/person/hobby")
                        .param("hobby", "running"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assert(content.equals("[\"Imraan\",\"Robert\"]"));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/person/hobby")
                        .param("hobby", "stargazing"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        content = mvcResult.getResponse().getContentAsString();

        assert(content.equals("[\"Robert\",\"Sam\"]"));

    }

    @Test
    void TestChangeHobbyAndAddressPerson() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/person/1")
                        .param("hobbies", "1")
                        .param("address", "12345 Fake Street"))
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assert(content.equals(
            "Person{id='1', name='Imraan', " +
            "hobbies=1, " +
            "address='12345 Fake Street', " +
            "phoneNumber='510-123-4567'}")
        );
    }



}
