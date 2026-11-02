public class HvacSystem extends SmartDevice {
    private final double currentSetPoint;
    private int fanSpeedLevel; // Valid levels: 1 to 5

    public HvacSystem(String deviceId, String roomName, boolean status, double currentSetPoint, int fanSpeedLevel) {
        super(deviceId, roomName, DeviceType.HVAC, status);
        if (fanSpeedLevel < 1 || fanSpeedLevel > 5) {
            throw new IllegalArgumentException("Fan speed level must be between 1 and 5.");
        }
        this.currentSetPoint = currentSetPoint;
        this.fanSpeedLevel = fanSpeedLevel;
    }

    public double getCurrentSetPoint() { return currentSetPoint; }
    public int getFanSpeedLevel() { return fanSpeedLevel; }

    public void adjustFanSpeed(int boost) {
        int newSpeed = this.fanSpeedLevel + boost;
        if (newSpeed < 1) this.fanSpeedLevel = 1;
        else if (newSpeed > 5) this.fanSpeedLevel = 5;
        else this.fanSpeedLevel = newSpeed;
    }
}