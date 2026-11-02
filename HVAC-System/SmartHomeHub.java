import java.util.List;

public class SmartHomeHub {
    private final List<SmartDevice> connectedDevices;
    private final EnergyTariff energyTariff;
    private final AutomationRule automationRule;

    public SmartHomeHub(List<SmartDevice> connectedDevices) {
        if (connectedDevices == null || connectedDevices.isEmpty() || connectedDevices.size() > 50) {
            throw new IllegalArgumentException("Hub must support between 1 and 50 connected devices.");
        }
        this.connectedDevices = connectedDevices;
        this.energyTariff = new EnergyTariff();
        this.automationRule = new AutomationRule();
    }

    public double computeTotalSystemBill(double totalKWh) {
        return energyTariff.calculateBill(totalKWh);
    }

    public boolean checkSystemEmergencyStatus(SensorReading reading) {
        return automationRule.evaluateEmergencyCoolingTrigger(reading);
    }

    public int getActiveDeviceCount() {
        int count = 0;
        for (SmartDevice device : connectedDevices) {
            if (device.isStatus()) {
                count++;
            }
        }
        return count;
    }
}