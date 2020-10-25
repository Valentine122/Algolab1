package ua.lviv.iot;

public class Oscillograph {

    private String brand;
    private Double maxBandWidthSignalInMegahertz;
    private Integer memoryCapacityInKb;
    private Integer speedProcessor;

    public Oscillograph(String brand, Double maxBandWidthSignalInMegahertz, Integer memoryCapacityInKb, Integer speedProcessor) {
        this.brand = brand;
        this.maxBandWidthSignalInMegahertz = maxBandWidthSignalInMegahertz;
        this.memoryCapacityInKb = memoryCapacityInKb;
        this.speedProcessor = speedProcessor;
    }

    public String getBrand() {
        return brand;
    }

    public Double getMaxBandWidthSignalInMegahertz() {
        return maxBandWidthSignalInMegahertz;
    }

    public Integer getMemoryCapacityInKb(){
        return memoryCapacityInKb;
    }

    public Integer getSpeedProcessor() {
        return speedProcessor;
    }

    @Override
    public String toString() {
        return "Oscillograph{" +
                "brand='" + brand + '\'' +
                ", maxBandWidthSignalInMegahertz=" + maxBandWidthSignalInMegahertz +
                ", memoryCapacity=" + memoryCapacityInKb +
                ", speedProcessor=" + speedProcessor +
                '}';
    }
}
