package com.todocode.pacientes.controller;

import com.todocode.pacientes.model.Paciente;
import com.todocode.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteServ;

//  Creación: localhost:8080/pacientes/crear
    @PostMapping("/crear")
    public String savePaciente(@RequestBody Paciente pac) {
        pacienteServ.savePaciente(pac);
        return "El paciente fue creado correctamente";
    }

//  Lista completa de pacientes: localhost:8080/pacientes
    @GetMapping("/traerLista")
    public List<Paciente> getPacientes() {
        return pacienteServ.getPacientes();
    }

//  Traer un paciente  en particular: localhost:8080/pacientes/{id}
    @GetMapping("/{id}")
    public Paciente getPaciente(@PathVariable Long id) {
        return pacienteServ.findPaciente(id);
    }

//  Eliminación: localhost:8080/pacientes/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public String deletePaciente(@PathVariable Long id) {
        pacienteServ.deletePaciente(id);
        return "El paciente fue eliminado correctamente";
    }

//  Edición: localhost:8080/pacientes/editar
    @PutMapping("/editar")
    public Paciente editPaciente(@RequestBody Paciente pacienteEditar) {
        pacienteServ.editPaciente(pacienteEditar);
        return pacienteEditar;
    }
    
    //Traer paciente x DNI
    @GetMapping("/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }

}
