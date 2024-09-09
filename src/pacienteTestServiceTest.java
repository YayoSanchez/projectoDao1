import static org.junit.jupiter.api.Assertions.*;
import Dao.BD;
import Model.Paciente;
import Service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

class pacienteTestServiceTest {
    @Test
    public void buscarPaciente(){
        BD.crearTablas();
        PacienteService pacienteService = new PacienteService();
        Integer idABuscar = 1;
        Paciente paciente = pacienteService.buscarPorId(idABuscar);
        Assertions.assertTrue(paciente!=null);
    }
}