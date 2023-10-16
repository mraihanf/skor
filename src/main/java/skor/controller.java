package skor;

import java.util.HashMap;
import java.util.Map;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
    
    @Autowired
    private SkorRepository skorRepository;

    @GetMapping(value = "/A")
    public ResponseEntity<Map> A(){
        Map data = new HashMap<>();

        long a = skorRepository.countproblem1();
        data.put("data", a);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(value = "/B")
    public ResponseEntity<Map> B(){
        Map data = new HashMap<>();

        long b = skorRepository.countproblem2();
        data.put("data", b);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(value = "/C")
    public ResponseEntity<Map> C(){
        Map data = new HashMap<>();

        long c = skorRepository.countproblem3();
        data.put("data", c);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(value = "/admin")
    public String admin(Model model) {
        System.out.println("masuk");
        return "input.html";
    }

    @GetMapping(value = "/grup1")
    public String grup1(Model model) {
        System.out.println("masuk");
        return "a.html";
    }

    @GetMapping(value = "/grup2")
    public String grup2(Model model) {
        
        return "b";
    }

    @GetMapping(value = "/grup3")
    public String grup3(Model model) {
        
        return "c";
    }
    
    @PostMapping(value = "/input")
    public ResponseEntity<Map> input(@RequestParam Integer skor1, @RequestParam Integer skor2, @RequestParam Integer skor3){

        Map data = new HashMap<>();

        skor ct = new skor();
        ct.setSkor_1(skor1);
        ct.setSkor_2(skor2);
        ct.setSkor_3(skor3);
        skorRepository.save(ct);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping(value = "/put")
    public ResponseEntity<Map> input(@RequestParam Integer id, @RequestParam Integer skor1, @RequestParam Integer skor2, @RequestParam Integer skor3){

        Map data = new HashMap<>();

        skor ct = skorRepository.getById(id);

        ct.setSkor_1(skor1);
        ct.setSkor_2(skor2);
        ct.setSkor_3(skor3);
        skorRepository.save(ct);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    
}
