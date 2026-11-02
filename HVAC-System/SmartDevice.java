public class SmartDevice {
    public enum DeviceType { HVAC, LIGHTING, SECURITY, APPLIANCE }

    private final String deviceId;
    private final String roomName;
    private final DeviceType type;
    private boolean status; // true = ON, false = OFF

    public SmartDevice(String deviceId, String roomName, DeviceType type, boolean status) {
        this.deviceId = deviceId;
        this.roomName = roomName;
        this.type = type;
        this.status = status;
    }

    public String getDeviceId() { return deviceId; }
    public String getRoomName() { return roomName; }
    public DeviceType getType() { return type; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}