package com.sky.corvid.demo.test;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.corvid.demo.domain.Corvid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CorvidIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateCorvid() throws Exception{

        Corvid testCorvid = new Corvid("Magpie", 1, "Black, White");
        String reqBody = this.mapper.writeValueAsString(testCorvid);
        RequestBuilder req = MockMvcRequestBuilders.post("/createCorvid").content(reqBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        testCorvid.setId(1);
        String resBody = this.mapper.writeValueAsString(testCorvid);
        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

        System.out.println(testCorvid);
        System.out.println(reqBody);
    }

    @Test
    void testCreateCorvid2() throws Exception {
        String reqBody = this.mapper.writeValueAsString(new Corvid("Crow", 2, "Black"));
        String resBody = this.mapper.writeValueAsString(new Corvid(2, "Crow", 2, "Black"));

        mvc.perform(MockMvcRequestBuilders.post("/createCorvid").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(content().json(resBody));
    }


}
