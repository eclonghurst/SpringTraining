package com.sky.corvid.demo.services;
import org.junit.jupiter.api.Assertions;
import com.sky.corvid.demo.domain.Corvid;
import com.sky.corvid.demo.repo.CorvidRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CorvidServiceDBUnitTest {

    @Autowired
    private CorvidService service;

    @MockBean
    private CorvidRepo repo;

    @Test
    void testUpdate(){
        int id = 12;


        Optional<Corvid> found = Optional.of(new Corvid(id, "Crow", 1, "Black"));
        Corvid updated = new Corvid(id, "Magpie", 2, "Black, White");

        // updateCorvid uses .getCorvid which uses this.repo.findById()
        Mockito.when(this.repo.findById(id)).thenReturn(found);
        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        Assertions.assertEquals(updated, this.service.updateCorvid(id, "Magpie", 2, "Black, White"));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);

    }


}
