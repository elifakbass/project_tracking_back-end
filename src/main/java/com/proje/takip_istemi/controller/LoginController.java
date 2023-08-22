package com.proje.takip_istemi.controller;


import com.proje.takip_istemi.dao.AppDAO;
import com.proje.takip_istemi.dto.*;
import com.proje.takip_istemi.entity.Gorev;
import com.proje.takip_istemi.entity.Personel;
import com.proje.takip_istemi.entity.Proje;
import com.proje.takip_istemi.entity.Yonetici;
import com.proje.takip_istemi.response.*;
import com.proje.takip_istemi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api")
public class LoginController {

    private AppDAO appDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonelService personelService;

    @Autowired
    private YoneticiService yoneticiService;

    @Autowired
    private ProjeService projeService;

    @Autowired
    private GorevService gorevService;

    @Autowired
    private YorumService yorumService;

    public LoginController(AppDAO appDAO){
        this.appDAO=appDAO;
    }


    @PostMapping(path = "/login")
    public ResponseEntity<LoginMessage> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse =userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(path = "/personel")
    public ResponseEntity<PersonelResponse> findPersonel(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(personelService.findPersonel(loginDTO));
    }
    @PostMapping(path = "/yonetici")
    public ResponseEntity<YoneticiDTO> findYonetici(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(yoneticiService.findYonetici(loginDTO));
    }


    @GetMapping("/proje/{personel_id}")
    public ResponseEntity<List<ProjeResponse>> getProject(@PathVariable int personel_id){
        return ResponseEntity.ok(projeService.findProjects(personel_id));
    }

    @GetMapping("/gorev/{personel_id}")
    public ResponseEntity<List<GorevResponse>> getGorevler(@PathVariable int personel_id){
        return ResponseEntity.ok(gorevService.findGorevlerByPersonelId(personel_id));
    }

    @GetMapping("/personel/{yonetici_id}")
    public ResponseEntity< List<PersonelResponse>> getPersoneller(@PathVariable int yonetici_id){
        return ResponseEntity.ok(yoneticiService.findpersoneller(yonetici_id));
    }

    @GetMapping("/gorevler/{proje_id}")
    public  ResponseEntity<List<GorevResponse>> getGorevlerByProje(@PathVariable int proje_id){
        return ResponseEntity.ok(gorevService.findGorevlerByProjeId(proje_id));
    }

    @PostMapping("/proje")
    public ResponseEntity<String> saveproje(@RequestBody ProjeDTO projeDTO){
        return ResponseEntity.ok(projeService.saveProject(projeDTO));
    }

    @DeleteMapping("/proje/{proje_id}")
    public ResponseEntity<Response> deleteProje(@PathVariable int proje_id){
        return ResponseEntity.ok(projeService.deleteById(proje_id));
    }

    @PutMapping("/proje/{proje_id}")
    public ResponseEntity<ProjeResponse> updateProje(@PathVariable int proje_id,@RequestBody ProjeDTO projeDTO){
        return ResponseEntity.ok(projeService.updateProje(proje_id,projeDTO));
    }

    @PostMapping("/gorev")
    public ResponseEntity<Response> saveGorev(@RequestBody GorevDTO gorevDTO){
        return ResponseEntity.ok(gorevService.saveGorev(gorevDTO));
    }

    @DeleteMapping("/gorev/{gorev_id}")
    public ResponseEntity<Response> deleteGorev(@PathVariable int gorev_id){
        return ResponseEntity.ok(gorevService.deleteById(gorev_id));
    }

    @PutMapping("/gorev/{gorev_id}")
    public ResponseEntity<Response> updateGore(@PathVariable int gorev_id,@RequestBody GorevDTO gorevDTO){
        return ResponseEntity.ok(gorevService.updateGorev(gorev_id,gorevDTO));
    }

    @PostMapping("/durum/proje/{proje_id}")
    public ResponseEntity<Response> updateDurumProje(@PathVariable int proje_id, @RequestBody DurumDTO durumDTO){
        return ResponseEntity.ok(projeService.updateProjeByDurum(proje_id,durumDTO));
    }

    @PostMapping("/durum/gorev/{gorev_id}")
    public ResponseEntity<Response> updateDurumGorev(@PathVariable int gorev_id,@RequestBody DurumDTO durumDTO){
        return ResponseEntity.ok(gorevService.updateDurumGorev(gorev_id,durumDTO));
    }

    @GetMapping("/project/{proje_id}")
    public ResponseEntity<ProjeResponse> getProje(@PathVariable int proje_id){
        return ResponseEntity.ok(projeService.getProje(proje_id));
    }

    @GetMapping("/yorumlar/{proje_id}")
    public ResponseEntity<List<YorumResponse>> getYorumlar(@PathVariable int proje_id){
        return ResponseEntity.ok(projeService.getYorumlarById(proje_id));
    }

    @PostMapping("/yorum")
    public ResponseEntity<Response> saveYorum(@RequestBody YorumDTO yorumDTO){
        return ResponseEntity.ok(yorumService.saveYorum(yorumDTO));
    }
}
