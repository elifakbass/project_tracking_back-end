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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private AdminService adminService;

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

    @PostMapping(path = "/admin")
    public ResponseEntity<AdminResponse> findAdmin(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(adminService.findAdmin(loginDTO));
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
    public ResponseEntity<Response> updateProje(@PathVariable int proje_id,@RequestBody ProjeDTO projeDTO){
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

    @GetMapping("/employee/{personel_id}")
    public ResponseEntity<PersonelResponse> getPersonel(@PathVariable int personel_id){
        return ResponseEntity.ok(personelService.getPersonel(personel_id));
    }

    @PostMapping("/monthly-data")
    public List<ProjeResponse> getMonthlyData(@RequestBody DataRangeDTO dataRangeDTO) {
        return projeService.getMonthlyData(dataRangeDTO.getStartDate(), dataRangeDTO.getEndDate());
    }

    @PostMapping("/personel/add")
    public Response savePersonel(@RequestBody PersonelDTO personelDTO){
        return personelService.savePersonel(personelDTO);
    }

    @DeleteMapping("/personel/{personel_id}")
    public ResponseEntity<Response> deletePersonel(@PathVariable int personel_id){
        return ResponseEntity.ok(personelService.deletePersonel(personel_id));
    }

    @PutMapping("/personel/{personel_id}")
    public ResponseEntity<Response> updatePersonel(@PathVariable int personel_id,@RequestBody PersonelDTO personelDTO){
        return ResponseEntity.ok(personelService.updatePersonel(personel_id,personelDTO));
    }

    @GetMapping("/yonetici/{admin_id}")
    public ResponseEntity<List<YoneticiDTO>> getYoneticiler(@PathVariable int admin_id){
        return ResponseEntity.ok(adminService.findYoneticiByAdminId(admin_id));
    }

    @PostMapping("/yonetici/add")
    public ResponseEntity<Response> saveYonetici(@RequestBody YoneticiDTO yoneticiDTO){
        return ResponseEntity.ok(yoneticiService.saveYonetici(yoneticiDTO));
    }

    @DeleteMapping("/yonetici/{yonetici_id}")
    public ResponseEntity<Response> deleteYonetici(@PathVariable int yonetici_id){
        return ResponseEntity.ok(yoneticiService.deleteYonetici(yonetici_id));
    }

    @PutMapping("/yonetici/{yonetici_id}")
    public ResponseEntity<Response> updateYonetici(@PathVariable int yonetici_id,@RequestBody YoneticiDTO yoneticiDTO){
        return ResponseEntity.ok(yoneticiService.updateYonetici(yonetici_id,yoneticiDTO));
    }

    @GetMapping("/logs")
    public ResponseEntity<List<String>> getLogs() {
        String logFilePath = "logs/application.log";

        List<String> logLines = new ArrayList<>();

        try {
            // Log dosyasını satır satır okuma
            BufferedReader reader = new BufferedReader(new FileReader(logFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                logLines.add(line);
            }
            reader.close();

            // Log satırlarını JSON formatında dizi olarak döndürme
            return ResponseEntity.ok().body(logLines);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/kullanicilar")
    public ResponseEntity<List<UsersResponse> > getKullanicilar(){
        return ResponseEntity.ok(userService.findKullaniciler());
    }

}
