
package com.educacion.hospital.view;

import com.educacion.hospital.dao.LoginDao;
import com.educacion.hospital.model.Usuario;
import com.educacion.hospital.util.Util;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class LoginView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;

    private String usuario;
    private String password;
    private LoginDao loginDao;
    private String userName;

    public LoginView() {
        loginDao = new LoginDao();
    }

    public void loginUser() {
        try {
            Usuario user = loginDao.validarUsuario(usuario, password);
            if (null != user) {
                HttpSession session = Util.getSession();
               
                session.setAttribute("username", user.getNameUsr());
               
                switch(user.getRol().getIdRol()){
                    case 1:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/home.xhtml");
                    case 2:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/homesec.xhtml");
                    case 3:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/homemed.xhtml");
                    case 4:
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/homepaciente.xhtml");
                }
                
               /* 
                if(user.getRol().getIdRol()==1)
                  FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/home.xhtml");
                else
                    if(user.getRol().getIdRol()==2)
                        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/homesec.xhtml");
                    else
                        if(user.getRol().getIdRol()==3)
                            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/homemed.xhtml");
                         else
                            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/homepac.xhtml");
               */
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login: Usuario/Credenciales inválidas", ""));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Database Error",
                    "Unable to connect database"));
            ex.printStackTrace();
        }
    }

     public void loginRegister() {
       try {
           
                HttpSession session = Util.getSession();
                session.setAttribute("username", "generico");
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/pages/externo.xhtml");
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Database Error",
                    "Unable to connect database"));
            ex.printStackTrace();
        }
    }
    
    
    public void logout() {
        try {
            System.out.println("com.educacion.hospital.view.LoginView.logout()");
            HttpSession session = Util.getSession();
            session.invalidate();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/hospital/");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void logoutex() {
        try {
            System.out.println("com.educacion.hospital.view.LoginView.logout()");
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("/hospital/");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return Util.getUserName();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
