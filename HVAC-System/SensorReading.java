public class SensorReading {
    private final double temperatureCelsius; // Valid range: -40.0 to 60.0
    private final double humidityPercentage; // Valid range: 0.0 to 100.0
    private final double powerConsumptionWatts; // Valid range: 0.0 to 5000.0

    public SensorReading(double temperatureCelsius, double humidityPercentage, double powerConsumptionWatts) {
        this.temperatureCelsius = temperatureCelsius;
        this.humidityPercentage = humidityPercentage;
        this.powerConsumptionWatts = powerConsumptionWatts;
    }

    public double getTemperatureCelsius() { return temperatureCelsius; }
    public double getHumidityPercentage() { return humidityPercentage; }
    public double getPowerConsumptionWatts() { return powerConsumptionWatts; }
}