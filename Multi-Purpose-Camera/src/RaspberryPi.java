/**
 * Imports java libraries
 */
import java.util.*;
/**
 * RaspberryPi is the main piece of hardware in this system that
 * will communicate with other devices and code.
 */
public class RaspberryPi{
    /**
     * The wifi used to connect devices
     */
    private String WIFI;
    /**
     * criteria used to determine what is done and when
     */
    private List<Integer> Criteria = new ArrayList<Integer>();
    /**
     * Main method which will control the whole system
     */
    public static void main(String args[]){
        System.out.println("This is the main method");
    }
    /**
     * Will determine if certain criteria has been met, and what functions and objects
     * will be involved if that happens
     */
    public int Criteria_Met(List<int> criteria){}
    /**
     * Saves video recorded by the camera
     */
    public void Save_Video(){}
    /**
     * Sends video to destination specified by the user
     */
    public void Send_Video(){}
    /**
     * Connects the system to a close device via bluetooth
     */
    public void Blue_Tooth_Connection(){}
    /**
     * Connects system to the internet 
     */
    public void WIFI_Connection(){}
    /**
     * Sends alerts and notifications to user if certain criteria have been met
     */
    public Alert Send_Alert( int alert ){}
}