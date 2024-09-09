package Dao;

import Model.Domicilio;
import Model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Locale;

public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT = "INTO PACIENTES(NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID); " +
            "VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID=?";
    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("Iniciando las operaciones de guardado de un paciente");
        Connection connection = null;
        try{
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3,paciente.getCedula());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5,paciente.getDomicilio().getId());
            psInsert.execute();
            ResultSet rs = psInsert.getGeneratedKeys();
            while(rs.next()){

            }
        }catch(Exception e){
            logger.error("Conexion fallida "+e.getMessage());
        }return null;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        logger.info("Iniciando las operaciones de guardado de un paciente");
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;

        try{
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs = psSelectOne.executeQuery();
            DomicilioDAOH2 daoAux = new DomicilioDAOH2();
            while (rs.next()){
                domicilio = daoAux.buscarPorId(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);
            }

        }catch(Exception e){
            logger.error("Conexion fallida "+e.getMessage());
        }return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("Iniciando las operaciones de guardado de un paciente");
        Connection connection = null;
        try{
            connection = BD.getConnection();
        }catch(Exception e){
            logger.error("Conexion fallida "+e.getMessage());
        }
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("Iniciando las operaciones de guardado de un paciente");
        Connection connection = null;
        try{
            connection = BD.getConnection();
        }catch(Exception e){
            logger.error("Conexion fallida "+e.getMessage());
        }
    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("Iniciando las operaciones de guardado de un paciente");
        Connection connection = null;
        try{
            connection = BD.getConnection();
        }catch(Exception e){
            logger.error("Conexion fallida "+e.getMessage());
        }return List.of();
    }
}
