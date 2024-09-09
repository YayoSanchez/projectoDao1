package Service;

import Dao.PacienteDAOH2;
import Dao.iDao;
import Model.Paciente;

public class PacienteService {
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao = new PacienteDAOH2();
    }
    public Paciente guardaPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorId(Integer id){
        return pacienteiDao.buscarPorId(id);
    }
}