public class EnergyTariff {

    /**
     * Calculates electricity cost based on total kilowatt-hours (kWh) consumed:
     * - Tier 1: <= 100 kWh -> $0.10 per kWh
     * - Tier 2: > 100 kWh and <= 500 kWh -> $0.15 per kWh
     * - Tier 3: > 500 kWh -> $0.25 per kWh
     */
    public double calculateBill(double totalKWh) {
        if (totalKWh < 0.0 || totalKWh > 10000.0) {
            throw new IllegalArgumentException("Invalid energy consumption reading.");
        }

        if (totalKWh <= 100.0) {
            return totalKWh * 0.10;
        } else if (totalKWh <= 500.0) {
            return (100.0 * 0.10) + ((totalKWh - 100.0) * 0.15);
        } else {
            return (100.0 * 0.10) + (400.0 * 0.15) + ((totalKWh - 500.0) * 0.25);
        }
    }
}