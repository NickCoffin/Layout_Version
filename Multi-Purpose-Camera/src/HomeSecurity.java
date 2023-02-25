/**
 * HomeSecurity is one of the utilities of the multi-purpose-camera
 * It's meant to alert the user by sending a notification if motion is detected 
 * at the spot where the user puts the camera(namely the front door)
 */
public class HomeSecurity {
    /**
     * Decibels is the intensity of the sound waves picked up
     * by the audio device
     */
    private int Decibels;
    /**
     * Light_Exposure_Levels is the amount of light exposed to the camera
     */
    private int Light_Exposure_Levels;
    /**
     * Decibel_Reading is the function used to record the amount of sound detected
     */
    public int Decibel_Reading(){}
    /**
     * Motion_Detection detects motion through the camera
     */
    public void Motion_Detection(){}
    /**
     * Inactivity_Monitor is what monitors the amount of activity picked up by the 
     * camera 
     */
    public void Inactivity_Monitor(){}
}
