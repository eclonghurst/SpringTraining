package com.sky.corvid.demo.rest;

import com.sky.corvid.demo.domain.Jewellery;
import com.sky.corvid.demo.services.JewelleryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewellery")
public class JewelleryController {

    private JewelleryService service;

    public JewelleryController(JewelleryService service) {
        this.service = service;
    }

    @PostMapping("/createJewellery")
    public Jewellery createJewellery(@RequestBody Jewellery j){
        return this.service.createJewellery(j);

    }

    @GetMapping("/getAllJewellery")
    public List<Jewellery> getAllJewellery(){
        return this.service.getAllJewellery();
    }

    @DeleteMapping("/removeJewellery/{id}")
    public ResponseEntity<String> removeJewellery(@PathVariable int id){
        String result = this.service.removeJewellery(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);
    }
}
