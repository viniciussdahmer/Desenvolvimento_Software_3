package com.example.desenvolvimento_software_3.application.sintoma;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sintomas")
public class SintomaRestAPI {

    private final SintomaService sintomaService;

    public SintomaRestAPI(SintomaService sintomaService) {
        this.sintomaService = sintomaService;
    }

    @GetMapping
    @ResponseBody
    public List<SintomaDTO> getAll() {
        return sintomaService.getAll().stream().map(SintomaBuilder::fromEntity).collect(Collectors.toList());
    }

    @PostMapping("/{userId}")
    @ResponseBody
    public SintomaDTO create(@RequestBody SintomaDTO sintomaDTO, @PathVariable Long userId) {
        return SintomaBuilder.fromEntity(sintomaService.create(SintomaBuilder.fromDTO(sintomaDTO), userId));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public SintomaDTO getOne(@PathVariable Long id) throws Exception {
        return SintomaBuilder.fromEntity(sintomaService.getOne(id));
    }

    @PutMapping("/{sintomaId}/update")
    public SintomaDTO update(@RequestBody SintomaDTO sintomaDTO, @PathVariable Long sintomaId) {
        return SintomaBuilder.fromEntity(sintomaService.update(SintomaBuilder.fromDTO(sintomaDTO), sintomaId));
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) throws Exception {
        sintomaService.delete(id);
    }

}
