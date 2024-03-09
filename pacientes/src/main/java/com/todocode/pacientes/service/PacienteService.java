
package com.todocode.pacientes.service;

import com.todocode.pacientes.model.Paciente;
import com.todocode.pacientes.repository.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService{
    
    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void savePaciente(Paciente pac) {
        pacienteRepo.save(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);
    }

    @Override
    public void editPaciente(Paciente pac) {
        this.savePaciente(pac);
    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return pacienteRepo.findByDni(dni);
    }
    
}
