package com;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
@ManagedBean
@RequestScoped
public class login {
    private String user_name;
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_name() {
        return user_name;
    }
     public String submit_form(){
         try {
              String gRecaptchaResponse = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
               boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
               if(verify){
                   return "Success";
               }else{
                   FacesContext context = FacesContext.getCurrentInstance();
                  context.addMessage( null, new FacesMessage( "Select Captcha") );
                   return null;
               }
         } catch (Exception e) {
             System.out.println(e);
         }
        return null;
     }    
}