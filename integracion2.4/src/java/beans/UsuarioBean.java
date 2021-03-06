/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import logic.HibernateUtil;
import org.hibernate.Session;
import Modelo1.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author seneck
 */
@Named(value = "usuarioBeanT")
@RequestScoped
@ManagedBean
public class UsuarioBean implements Serializable{
    
     private int idUsuario;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String correo;
     private String telefono;
     private String contrasenya;
     private String contrasenyav;
      private HibernateUtil helper;
     Session session;
     
      /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }
    
     public  String cryptMD5(String textoPlano){
     char[] HEXADECIMALES = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
     try{
    
       MessageDigest msgdgt = MessageDigest.getInstance("MD5");
       byte[] bytes = msgdgt.digest(textoPlano.getBytes());
       StringBuilder strCryptMD5 = new StringBuilder(2 * bytes.length);
       for (int i = 0; i < bytes.length; i++)
       {
           int low = (int)(bytes[i] & 0x0f);
           int high = (int)((bytes[i] & 0xf0) >> 4);
           strCryptMD5.append(HEXADECIMALES[high]);
           strCryptMD5.append(HEXADECIMALES[low]);
       }
          return strCryptMD5.toString();
    } catch (NoSuchAlgorithmException e) {
       return null;
    }
  }
     private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validateEmail(String email) {
       
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
     public String registrarEstudiante() {
        int idNew =200;
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Modelo1.Estudiante c = (Modelo1.Estudiante) session.get(Modelo1.Estudiante.class, idNew);
        if(!validateEmail(this.correo)){
        FacesContext.getCurrentInstance().addMessage(null,
           new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo no es valido", null));
           return "registrar";
        }
        while(c != null){
            idNew++;
            c = (Modelo1.Estudiante) session.get(Modelo1.Estudiante.class, idNew);
        }
        this.idUsuario = idNew;
        if(this.contrasenya.equals(this.contrasenyav)){
            Modelo1.Estudiante e = new Modelo1.Estudiante(this.idUsuario,
            this.nombre,this.apellidoPaterno,this.apellidoMaterno,
            this.correo,this.telefono,null,cryptMD5(this.contrasenya),"Por asignar","Por asignar",null);
        if(e != null){
            session.save(e);
            session.getTransaction().commit();
            session.close();
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Estudiante "+ nombre + " Creado"));
        }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña no coincide", null));
          return "registrar";
        }
        return "principal";
    }
     
    public String registrarPrestador() {
        int idNew =100;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Modelo1.Prestador c = (Modelo1.Prestador) session.get(Modelo1.Prestador.class, idNew);
          if(!validateEmail(this.correo)){
        FacesContext.getCurrentInstance().addMessage(null,
           new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo no es valido", null));
           return "registrar";
        }
        while(c != null){
            idNew++;
            c = (Modelo1.Prestador) session.get(Modelo1.Prestador.class, idNew);
        }
        this.idUsuario = idNew;
        if(this.contrasenya.equals(this.contrasenyav) ){
            Modelo1.Prestador e = new Modelo1.Prestador(this.idUsuario,
            this.nombre,this.apellidoPaterno,this.apellidoMaterno,
            this.correo,this.telefono,cryptMD5(this.contrasenya),0);
            session.save(e);
            session.getTransaction().commit();
            session.close();
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Prestador "+ nombre + " Creado"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña no coincide", null));
            return "registro";
        }
    
        return "principal";
    } 

   

    public String getContrasenyav() {
        return contrasenyav;
    }

    public void setContrasenyav(String contrasenyav) {
        this.contrasenyav = contrasenyav;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    
}
