import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Home & Energy Management System Demo ===\n");

        // 1. Create Smart Devices
        SmartDevice livingRoomLight = new SmartDevice("DEV-101", "Living Room", SmartDevice.DeviceType.LIGHTING, true);
        SmartDevice kitchenAppliance = new SmartDevice("DEV-102", "Kitchen", SmartDevice.DeviceType.APPLIANCE, false);

        // Specialized HVAC Device (inherits from SmartDevice)
        HvacSystem masterBedroomHvac = new HvacSystem("DEV-103", "Master Bedroom", true, 22.5, 3);

        System.out.println("Device Initialized: " + masterBedroomHvac.getDeviceId() +
                " in " + masterBedroomHvac.getRoomName() +
                " (Status: " + (masterBedroomHvac.isStatus() ? "ON" : "OFF") +
                ", SetPoint: " + masterBedroomHvac.getCurrentSetPoint() + "°C" +
                ", Fan Level: " + masterBedroomHvac.getFanSpeedLevel() + ")");

        // 2. Setup the Smart Home Hub with a collection of devices
        List<SmartDevice> devices = new ArrayList<>();
        devices.add(livingRoomLight);
        devices.add(kitchenAppliance);
        devices.add(masterBedroomHvac);

        SmartHomeHub homeHub = new SmartHomeHub(devices);
        System.out.println("Smart Home Hub active with " + homeHub.getActiveDeviceCount() + " running devices.\n");

        // 3. Test Energy Tariff / Bill Calculations (Tiered pricing)
        EnergyTariff tariff = new EnergyTariff();
        double sampleMonthlyKWh = 350.0; // Falls into Tier 2
        double calculatedBill = homeHub.computeTotalSystemBill(sampleMonthlyKWh);

        System.out.println("--- Energy Consumption & Billing ---");
        System.out.printf("Monthly Consumption: %.1f kWh\n", sampleMonthlyKWh);
        System.out.printf("Calculated Utility Bill: $%.2f\n\n", calculatedBill);

        // 4. Test Device Scheduling Boundaries & Time Checks
        System.out.println("--- Device Scheduling ---");
        DeviceSchedule nightSchedule = new DeviceSchedule(22, 6, 19); // 10 PM to 6 AM overnight span
        int testHour = 23; // 11 PM
        boolean withinSchedule = nightSchedule.isWithinSchedule(testHour);
        System.out.println("Checking schedule at hour " + testHour + ": Is within operating window? " + withinSchedule);
        System.out.println("Scheduled Target Temperature: " + nightSchedule.getTargetTemperature() + "°C\n");

        // 5. Test Sensor Telemetry and Automated Emergency Trigger Rules
        System.out.println("--- Automation & Environmental Sensors ---");
        // Extreme condition: High temp and high humidity triggering emergency cooling
        SensorReading criticalReading = new SensorReading(32.5, 85.0, 3400.0);
        boolean emergencyTriggered = homeHub.checkSystemEmergencyStatus(criticalReading);

        System.out.printf("Sensor Telemetry -> Temp: %.1f°C, Humidity: %.1f%%, Power: %.1fW\n",
                criticalReading.getTemperatureCelsius(),
                criticalReading.getHumidityPercentage(),
                criticalReading.getPowerConsumptionWatts());
        System.out.println("Emergency Cooling Trigger Activated? " + emergencyTriggered);

        // 6. Test HVAC State Modification
        System.out.println("\n--- HVAC Dynamic Controls ---");
        System.out.println("Current Fan Speed: " + masterBedroomHvac.getFanSpeedLevel());
        masterBedroomHvac.adjustFanSpeed(2); // Boost fan speed by 2 levels
        System.out.println("Adjusted Fan Speed (Boost +2): " + masterBedroomHvac.getFanSpeedLevel());

        System.out.println("\n=== Smart Home Demo Complete ===");
    }
}