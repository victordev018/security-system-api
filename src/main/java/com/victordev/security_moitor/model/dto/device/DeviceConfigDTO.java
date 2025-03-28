package com.victordev.security_moitor.model.dto.device;


public class DeviceConfigDTO {

    private int sensor;
    private int buzzer;
    private int delay;

    public DeviceConfigDTO(int sensor, int buzzer, int delay) {
        this.sensor = sensor;
        this.buzzer = buzzer;
        this.delay = delay;
    }

    public int getSensor() {
        return sensor;
    }

    public void setSensor(int sensor) {
        this.sensor = sensor;
    }

    public int getBuzzer() {
        return buzzer;
    }

    public void setBuzzer(int buzzer) {
        this.buzzer = buzzer;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}

