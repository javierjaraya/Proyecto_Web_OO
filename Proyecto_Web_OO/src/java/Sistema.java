import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import jpa.classes.UsuarioController;
import jpa.entitys.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javier
 */
@ManagedBean
@RequestScoped
public class Sistema {

    private String rut;
    private String password;
    private final HttpServletRequest httpSerletRequest;
    private final FacesContext facesContext;
    private FacesMessage facesMessage;

    public Sistema() {
        facesContext = FacesContext.getCurrentInstance();
        httpSerletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        if (httpSerletRequest.getSession().getAttribute("rut") != null) {
            rut = httpSerletRequest.getSession().getAttribute("rut").toString();
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validar() {
        if (this.rut.equals("18771223-8") && this.password.equals("1234")) {
            httpSerletRequest.getSession().setAttribute("rut", rut);
            httpSerletRequest.getSession().setAttribute("perfil", "admin");
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso correcto", null);
            facesContext.addMessage(null, facesMessage);
            this.rut = "18771223-8";
            return "admin";
        } else {
            if (this.rut.equals("11789214-k") && this.password.equals("1234")) {
                httpSerletRequest.getSession().setAttribute("rut", rut);
                httpSerletRequest.getSession().setAttribute("perfil", "user");
                facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso correcto", null);
                facesContext.addMessage(null, facesMessage);
                this.rut = "11789214-k";
                return "/views/user/user";
            } else {
                facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut o password incorrecto", null);
                facesContext.addMessage(null, facesMessage);
                return "index";
            }
        }

        //UsuarioDAO usuarioDAO = new UsuarioDAO();
        //boolean result = usuarioDAO.login(rut, password);
        /*UsuarioController usc= new UsuarioController();
        
         Usuario usuario = usc.validate(rut, password);
         if(usuario != null){
         httpSerletRequest.getSession().setAttribute("administrador", rut);
         facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso correcto", null);
         facesContext.addMessage(null, facesMessage);
         return "admin";
         }else{
         facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut o password incorrecto", null);
         facesContext.addMessage(null, facesMessage);
         return "index";
         }*/
    }

    public String cerrar() {
        httpSerletRequest.getSession().removeAttribute("administrador");
        facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Session cerrada correctamente", null);
        facesContext.addMessage(null, facesMessage);
        return "/index";
    }
}
