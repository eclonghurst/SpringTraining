package com.sky.corvid.demo.rest;

import com.sky.corvid.demo.domain.Corvid;
import com.sky.corvid.demo.services.CorvidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CorvidController {

    // @Autowired is valid here but less efficient than a constructor
    private CorvidService service;

    // Spring will automatically inject a CorvidServices when it boots
    public CorvidController(CorvidService service) {
        this.service = service;
    }

    // 'maps' this method to a GET request at /hello
    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

    @PostMapping("/createCorvid")
    public ResponseEntity<Corvid> createCorvid(@RequestBody Corvid c){
        return new ResponseEntity<>(this.service.createCorvid(c), HttpStatus.CREATED);
    }

    @GetMapping("/getCorvid/{id}")
    public ResponseEntity<Corvid> getCorvid(@PathVariable int id){

        System.out.println("ID: " + id);
        Corvid found = this.service.getCorvid(id);

        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(found);
    }

    @GetMapping("/getCorvid/species/{species}")
    public Corvid getCorvidBySpecies(@PathVariable String species){
        return this.service.getCorvidBySpecies(species);
    }

    @GetMapping("/getAll")
    public List<Corvid> getAll(){
        return this.service.getAll();
    }

    @PatchMapping("/updateCorvid/{id}")
    public ResponseEntity<Corvid> updateCorvid(
            @PathVariable int id,
            @RequestParam(name = "species", required = false) String species,
            @RequestParam(name = "weight", required = false) Integer weight, // better to use Integer to avoid null value error
            @RequestParam(name = "colours", required = false) String colours
    ){
        Corvid updated = this.service.updateCorvid(id, species, weight, colours);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/removeCorvid/{id}")
    public ResponseEntity<String> removeCorvid(@PathVariable int id){
        String result = this.service.removeCorvid(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);
    }
}