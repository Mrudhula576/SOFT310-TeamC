public class DeviceSchedule {
    private final int startHour; // Valid: 0 to 23
    private final int endHour;   // Valid: 0 to 23
    private final int targetTemperature; // Valid: 16 to 30 (Celsius)

    public DeviceSchedule(int startHour, int endHour, int targetTemperature) {
        if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23) {
            throw new IllegalArgumentException("Hours must be between 0 and 23.");
        }
        if (targetTemperature < 16 || targetTemperature > 30) {
            throw new IllegalArgumentException("Target temperature must be between 16 and 30 degrees.");
        }
        this.startHour = startHour;
        this.endHour = endHour;
        this.targetTemperature = targetTemperature;
    }

    public boolean isWithinSchedule(int currentHour) {
        if (currentHour < 0 || currentHour > 23) {
            throw new IllegalArgumentException("Current hour must be between 0 and 23.");
        }
        if (startHour <= endHour) {
            return currentHour >= startHour && currentHour <= endHour;
        } else { // Handles overnight spans e.g., 22:00 to 06:00
            return currentHour >= startHour || currentHour <= endHour;
        }
    }

    public int getTargetTemperature() { return targetTemperature; }
}