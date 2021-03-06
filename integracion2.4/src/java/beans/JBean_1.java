/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Modelo1.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.inject.Named;
//import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import logic.HibernateUtil;
import logic.MiLoginHelper;

import org.hibernate.Session;

/**
 *
 * @author seneck
 */
@Named(value = "jSFManagedBean_1")
@SessionScoped
@RequestScoped
@ManagedBean
public class JBean_1 implements Serializable {

    private HibernateUtil helper;
      private MiLoginHelper helper1;
    private Session session;

    private Usuario u;
    private Estudiante e;
    private DireccionUsuario d;
    private TieneContratoU con;
    private int id;

    private int idNew;
    private List<Integer> ids;

    private int idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private String contrasenya;

    private String facultad;
    private String carrera;
    int IdSession=0;

    //////////////////////////////////////
    
    private int idDireccionU;
     private String paisU;
     private String estadoU;
     private String delegacionU;
     private int codigoPostalU;
     private String calleU;
     private String coloniaU;
     
     private String ruta="/home/salador/Documentos/Ing s/archivo.txt";
     
      Modelo1.Estudiante UEstudiante; 
      Modelo1.DireccionUsuario Dir;
      
      Modelo1.CalificacionEstudiante cali_es;
      
      public JBean_1() {
    }
   
    

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }
    public int getIdUsuario() {
        carga();
        return UEstudiante.getIdUsuario();
    }
    public void CargaNum(){
    String cadena=null;
        BufferedReader b=null;
        FileReader f;
            try {
                f = new FileReader(ruta); 
                b = new BufferedReader(f);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                cadena = b.readLine();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        helper1 = new MiLoginHelper();
        IdSession=Integer.parseInt(cadena);
    
    }
    public void carga(){
    String cadena=null;
        BufferedReader b=null;
        FileReader f;
            try {
                f = new FileReader(ruta); 
                b = new BufferedReader(f);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                cadena = b.readLine();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                b.close();
            } catch (IOException ex) {
                Logger.getLogger(JBean_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        helper1 = new MiLoginHelper();
        IdSession=Integer.parseInt(cadena);
        UEstudiante = helper1.getLoginPorEstudiante(IdSession);
        
        nombre=UEstudiante.getNombre();
        
        apellidoPaterno=UEstudiante.getApellidoPaterno();
        apellidoMaterno=UEstudiante.getApellidoMaterno();
        correo=UEstudiante.getCorreo();
        telefono=UEstudiante.getTelefono();
        
        facultad=UEstudiante.getFacultad();
        carrera=UEstudiante.getCarrera();
        
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre1() {
        carga();
        return this.nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenya() {
        return this.contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    ////////////////////////////////////////

    public String getFacultad() {
        return this.facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /////////////////////////////////////////
    
    public int getIdDireccionU() {
        return this.idDireccionU;
    }
    
    public void setIdDireccionU(int idDireccionU) {
        this.idDireccionU = idDireccionU;
    }
    public String getPaisU() {
        return this.paisU;
    }
    
    public void setPaisU(String paisU) {
        this.paisU = paisU;
    }
    public String getEstadoU() {
        return this.estadoU;
    }
    
    public void setEstadoU(String estadoU) {
        this.estadoU = estadoU;
    }
    public String getDelegacionU() {
        return this.delegacionU;
    }
    
    public void setDelegacionU(String delegacionU) {
        this.delegacionU = delegacionU;
    }
    public int getCodigoPostalU() {
        return this.codigoPostalU;
    }
       public void setCodigoPostalU(int codigoPostalU) {
        this.codigoPostalU = codigoPostalU;
    }
     
    public String getCalleU() {
        return this.calleU;
    }
    
    public void setCalleU(String calleU) {
        this.calleU = calleU;
    }
    public String getColoniaU() {
        return this.coloniaU;
    }
    
    public void setColoniaU(String coloniaU) {
        this.coloniaU = coloniaU;
    }

    /////////////////////////////////////////
    @PostConstruct
    public void initI() {
        ids = new ArrayList<>();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();

        u = (Usuario) session.get(Usuario.class, idUsuario);
        e = (Estudiante) session.get(Estudiante.class, IdSession);
  d =(DireccionUsuario) session.get(DireccionUsuario.class, idDireccionU);
        session.getTransaction().commit();
        session.close();
        
    }

    public String selecnEliminar() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        u = (Usuario) session.get(Usuario.class, idUsuario);
        e = (Estudiante) session.get(Estudiante.class, idUsuario);
         d=(DireccionUsuario) session.get(DireccionUsuario.class, idUsuario);
        if (u != null && e != null) {
            e.setNombre(this.nombre);
            this.idUsuario = e.getIdUsuario();
            this.apellidoMaterno = e.getApellidoMaterno();
            this.apellidoPaterno = e.getApellidoPaterno();
            this.carrera = e.getCarrera();
            this.correo = e.getCorreo();
            this.facultad = e.getFacultad();
            this.telefono = e.getTelefono();
             this.paisU=d.getPaisU();
            this.estadoU=d.getEstadoU();
            this.delegacionU=d.getDelegacionU();
            this.codigoPostalU=d.getCodigoPostalU();
            this.calleU=d.getCalleU();
            this.coloniaU=d.getColoniaU();
            
            
            return "principal";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        return "principal";
    }

    public String eliminarUsuario() {////pasa como parametro un entero y en el mensaje de error imprimero
       
        CargaNum();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
       Estudiante  e1 = (Estudiante) session.get(Estudiante.class, IdSession);   
       TieneContratoU T_con_u; 
       Contrato contra;
       int i=1;
       while(i<100){
           T_con_u=(TieneContratoU) session.get(TieneContratoU.class,i);
          if(T_con_u!=null){
           if(T_con_u.getEstudiante()==e1.getIdUsuario()){
               contra=(Contrato) session.get(Contrato.class,i);
               session.delete(T_con_u);
               session.delete(contra);
           }
          }
           i++;
       }
         CalificacionEstudiante aux_cali_es=  (CalificacionEstudiante) session.get(CalificacionEstudiante.class,e1.getIdUsuario());
         if(aux_cali_es!=null){
             session.delete(aux_cali_es);
         }
        if ( e1 != null) {
            session.delete(e1);
            session.getTransaction().commit();
            session.close();
            mensajeConfElim();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar Usuario " + id, null));
            return "principal";
        }

        return "principal";
    }
    
    public String modifC()  {
       
        CargaNum();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
       Estudiante  e1 = (Estudiante) session.get(Estudiante.class, IdSession);
       if ( e1 != null) {
            e1.setNombre(getNombre());          
            e1.setApellidoMaterno(getApellidoMaterno());
            e1.setApellidoPaterno(getApellidoPaterno());
            e1.setCarrera(getCarrera());
            e1.setCorreo(getCorreo());
            e1.setFacultad(getFacultad());
            e1.setTelefono(getTelefono());
            
            
            } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Id incorrecto", null));
        }
        if (e1 != null ) {
            session.update(e1);
         
            session.getTransaction().commit();
            session.close();
            mensajeConfModif();
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar Estudiante " + id, null));
            return "principal";
        }
        return "estudiante";
    }

    public void mensaje() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario " + idNew + " Creado"));
    }

    public void mensajeConfElim() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario " + IdSession + " Eliminado"));
    }

    public void mensajeConfModif() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario Modificado"));
    }
    
    public String cancela(){
    return "Principal";
        
    }

    public int daCalificion(){
        CargaNum();
        int res=0;
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        cali_es = (CalificacionEstudiante) session.get(CalificacionEstudiante.class,IdSession);
        
        if(cali_es==null){
        return 0;
        }else{
            if(cali_es.getNumE()!=0){
                res=cali_es.getSumP()/cali_es.getNumE();
                    }
        }
        return res;
    }
  
}
