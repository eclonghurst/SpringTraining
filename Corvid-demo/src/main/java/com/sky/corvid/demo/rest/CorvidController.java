package com.sky.corvid.demo.rest;

import com.sky.corvid.demo.domain.Corvid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CorvidController {
    
    private List<Corvid> corvidae = new ArrayList<>();

    // 'maps' this method to a GET request at /hello
    @GetMapping("/hello")
    public String test() {
        return "Hello, World!";
    }

    @PostMapping("/create")
    public ResponseEntity<Corvid> createCorvid(@RequestBody Corvid c){
        corvidae.add(c);
        Corvid created = corvidae.get(this.corvidae.size() -1); // returning the last element (to show the new corvid)
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/getCorvid/{id}")
    public ResponseEntity<Corvid> getCorvid(@PathVariable int id){

        System.out.println("ID: " + id);

        if (id>=corvidae.size()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(corvidae.get(id));
    }

    @GetMapping("/getAll")
    public List<Corvid> getAll(){
        return corvidae;
    }

    @PatchMapping("/updateCorvid/{id}")
    public Corvid updateCorvid(
            @PathVariable int id,
            @RequestParam(name = "species", required = false) String species,
            @RequestParam(name = "weight", required = false) Integer weight, // better to use Integer to avoid null value error
            @RequestParam(name = "colours", required = false) String colours
    ){
        corvidae.get(id).setSpecies(species);
        corvidae.get(id).setWeight(weight);
        corvidae.get(id).setColours(colours);
        return corvidae.get(id);
    }

    @DeleteMapping("/removeCorvid/{id}")
    public String removeCorvid(@PathVariable int id){
        String deletedCorvid = corvidae.get(id).getSpecies();
        corvidae.remove(id);
        return "You removed: " + deletedCorvid;
    }

}