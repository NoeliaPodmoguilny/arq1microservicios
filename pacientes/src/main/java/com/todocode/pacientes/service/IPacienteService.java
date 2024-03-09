package com.todocode.pacientes.service;

import com.todocode.pacientes.model.Paciente;
import java.util.List;

public interface IPacienteService {

    public List<Paciente> getPacientes();

    public Paciente findPaciente(Long id);

    public void savePaciente(Paciente pac);

    public void deletePaciente(Long id);

    public void editPaciente(Paciente pac);

    public Paciente findPacienteDni(String dni);
}
