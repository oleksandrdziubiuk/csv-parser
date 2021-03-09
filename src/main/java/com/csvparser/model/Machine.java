package com.csvparser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "machines")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private boolean available;
    private String country;
    private String currency;
    @Column(name = "machine_info")
    private String machineInfo;
    @Column(name = "machine_type")
    private String machineType;
    private String photos;
    @Column(name = "source_id")
    private int sourceId;
    private double price;
    private String source;
    private String url;

    public Machine() {
    }

    public Machine(String owner, boolean available, String country, String currency,
                   String machineInfo, String machineType, String photos, int sourceId,
                   double price, String source, String url) {
        this.owner = owner;
        this.available = available;
        this.country = country;
        this.currency = currency;
        this.machineInfo = machineInfo;
        this.machineType = machineType;
        this.photos = photos;
        this.sourceId = sourceId;
        this.price = price;
        this.source = source;
        this.url = url;
    }
}
