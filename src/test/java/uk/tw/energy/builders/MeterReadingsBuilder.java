package uk.tw.energy.builders;

import uk.tw.energy.domain.ElectricityReading;
import uk.tw.energy.domain.MeterReadings;
import uk.tw.energy.generator.ElectricityReadingsGenerator;

import java.util.ArrayList;
import java.util.List;

public class MeterReadingsBuilder {

    private static final String DEFAULT_METER_ID = "id";

    private String smartMeterId = DEFAULT_METER_ID;
    private List<ElectricityReading> electricityReadings = new ArrayList<>();

    MeterReadings FirstMeterBilder;
    MeterReadings SecundMeterBilder;


    public MeterReadingsBuilder setSmartMeterId(String smartMeterId) {
        this.smartMeterId = smartMeterId;
        return this;
    }

    public MeterReadingsBuilder generateElectricityReadings() {
        return generateElectricityReadings(5);
    }

    public MeterReadingsBuilder generateElectricityReadings(int number) {
        ElectricityReadingsGenerator readingsBuilder = new ElectricityReadingsGenerator();
        this.electricityReadings = readingsBuilder.generate(number);
        return this;
    }
    
    public void build() {
        generateElectricityReadings();
        FirstMeterBilder =  new MeterReadings(smartMeterId, electricityReadings);
    }

    public void build(String Smart, int Num) {
        setSmartMeterId(Smart);
        generateElectricityReadings(Num);
        SecundMeterBilder = new MeterReadings(smartMeterId, electricityReadings);
    }

    
    public MeterReadings building() {
        return new MeterReadings(smartMeterId, electricityReadings);
    }
}
