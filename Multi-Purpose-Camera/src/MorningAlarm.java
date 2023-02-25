/*
 * MorningAlarm is one of the utilities of the Multi-Purpose-Camera.
 * It is used as an alarm system to help the user wake up in the morning.
 */
public interface MorningAlarm {
    /*
     * Light_Exposure_Levels represents the intensity of the amount of light
     * picked up by the camera
     */
    private int Light_Exposure_Levels;
    /*
     * Measure_Light_Levels is the function used to measure the amount of light 
     * picked up by the camera and store it into Light_Exposure_Levels.
     */
    public void Measure_Light_Levels( int levels ){}
    /*
     * Sunrise uses the camera to see if the sun is coming up and if light is 
     * flooding the camera.
     */
    public String Sunrise( int sun ){}
}
