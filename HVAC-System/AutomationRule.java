public class AutomationRule {

    /**
     * Determines whether emergency climate cooling should trigger based on indoor conditions:
     * - Triggers if temperature > 35.0°C OR (temperature >= 30.0°C AND humidity >= 80.0%)
     */
    public boolean evaluateEmergencyCoolingTrigger(SensorReading reading) {
        if (reading.getTemperatureCelsius() < -40.0 || reading.getTemperatureCelsius() > 60.0) {
            throw new IllegalArgumentException("Temperature out of acceptable bounds.");
        }
        if (reading.getHumidityPercentage() < 0.0 || reading.getHumidityPercentage() > 100.0) {
            throw new IllegalArgumentException("Humidity out of acceptable bounds.");
        }

        double temp = reading.getTemperatureCelsius();
        double humidity = reading.getHumidityPercentage();

        if (temp > 35.0) {
            return true;
        }
        return temp >= 30.0 && humidity >= 80.0;
    }
}