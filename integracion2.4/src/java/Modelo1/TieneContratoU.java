package Modelo1;
// Generated 13/04/2016 11:24:39 AM by Hibernate Tools 4.3.1



/**
 * TieneContratoU generated by hbm2java
 */
public class TieneContratoU  implements java.io.Serializable {


     private int contrato;
     private int estudiante;
     private int prestador;

    public TieneContratoU() {
    }

    public TieneContratoU(int contrato, int estudiante, int prestador) {
       this.contrato = contrato;
       this.estudiante = estudiante;
       this.prestador = prestador;
    }
   
    public int getContrato() {
        return this.contrato;
    }
    
    public void setContrato(int contrato) {
        this.contrato = contrato;
    }
    public int getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }
    public int getPrestador() {
        return this.prestador;
    }
    
    public void setPrestador(int prestador) {
        this.prestador = prestador;
    }




}


