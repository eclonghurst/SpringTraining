package com.sky.corvid.demo.test;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:corvid-schema.sql", "classpath:corvid-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
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
        testCorvid.setId(3);
        String resBody = this.mapper.writeValueAsString(testCorvid);
        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

        System.out.println(testCorvid);
        System.out.println(reqBody);
    }

    @Test
    void testCreateCorvid2() throws Exception {
        String reqBody = this.mapper.writeValueAsString(new Corvid("Crow", 2, "Black"));
        String resBody = this.mapper.writeValueAsString(new Corvid(3, "Crow", 2, "Black"));

        mvc.perform(MockMvcRequestBuilders.post("/createCorvid").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(content().json(resBody));
        System.out.println(resBody);
        System.out.println(reqBody);
    }

    @Test
    void testReadCorvid() throws Exception {
        String resBody = this.mapper.writeValueAsString(new Corvid(1, "Crow", 1, "Black"));
        this.mvc.perform(MockMvcRequestBuilders.get("/getCorvid/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testReadCorvid2() throws Exception {
        String resBody = this.mapper.writeValueAsString(new Corvid(2, "Raven", 3, "Black"));
        this.mvc.perform(MockMvcRequestBuilders.get("/getCorvid/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testReadAll() throws Exception {

        List<Corvid> corvids = new ArrayList<>();
        corvids.add(new Corvid(1, "Crow", 1, "Black"));
        corvids.add(new Corvid(2, "Raven", 3, "Black"));

        String resBody = this.mapper.writeValueAsString(corvids);
        this.mvc.perform(MockMvcRequestBuilders.get("/getAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

    @Test
    void testUpdateCorvid() throws Exception {

        Corvid updatedCorvid = new Corvid(1,"Magpie", 1, "Black");
        String reqBody = this.mapper.writeValueAsString(updatedCorvid);

        String updateURL = "?species=" + updatedCorvid.getSpecies() + "&weight=" + updatedCorvid.getWeight() + "&colours=" + updatedCorvid.getColours();

        String resBody = this.mapper.writeValueAsString(updatedCorvid);

        this.mvc.perform(MockMvcRequestBuilders.patch("/updateCorvid/1" + updateURL).content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(resBody));
    }

  /*  @Test
    void testReadCorvidError() throws Exception {
        String resBody = this.mapper.writeValueAsString(new Corvid(6, "Crow", 1, "Black"));
        this.mvc.perform(MockMvcRequestBuilders.get("/getCorvid/6"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }*/

}
