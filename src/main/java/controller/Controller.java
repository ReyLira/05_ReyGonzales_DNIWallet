package controller;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;

@Data
@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable{
    
    private InetAddress ip;   //Variables para obtener Ip
    private InetAddress mac;  //Variables para obtener la Mac
    
    /* Variables para llamar al momento de consultar */
    private String IpNombre;
    private String Nombre;
    private String MacAdress;
    
    @PostConstruct
    
    public void Controller(){
        try {
            ip = InetAddress.getLocalHost();
            mac = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
        }
    }
        
    public void consultarvariables()throws UnknownHostException, SocketException{
        
        /* Para obtener el Nombre e Ip de la Pc */
        IpNombre = String.valueOf(ip.getHostAddress());
        Nombre = String.valueOf(ip.getHostName());
        
        /* MAC */
        NetworkInterface network = NetworkInterface.getByInetAddress(mac);
        
        byte[] mac = network.getHardwareAddress();
        StringBuilder sb = new StringBuilder();
        for (int i=0 ; i<mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length -1) ? "-" : ""));
        }
        
        /* Actulizar una representación de cadena de los objetos */
        MacAdress = sb.toString();
        
    }
    
}