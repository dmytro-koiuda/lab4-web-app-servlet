package edu.hneu.mjt.kuznecsemen.lab4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class PhoneReparationInfo {
    @Id
    private String id = UUID.randomUUID().toString();

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Manufacturer cannot be blank")
    private String manufacturer;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @NotBlank(message = "Platform cannot be blank")
    private String platform;

    private boolean camera;

    @NotBlank(message = "Internet description cannot be blank")
    private String internet;

    private boolean gpsModule;
    private boolean recorder;

    @PositiveOrZero(message = "Price must be positive or zero")
    private double price;

    @PositiveOrZero(message = "Optimal price must be positive or zero")
    private double optPrice;

    @NotBlank(message = "User last name cannot be blank")
    private String userLastName;

    @Email(message = "Invalid email address")
    private String userEmail;

    private LocalDate creationDate = LocalDate.now();

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setCamera(boolean camera) {
        this.camera = camera;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public void setGpsModule(boolean gpsModule) {
        this.gpsModule = gpsModule;
    }

    public void setRecorder(boolean recorder) {
        this.recorder = recorder;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOptPrice(double optPrice) {
        this.optPrice = optPrice;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getPlatform() {
        return platform;
    }

    public boolean isCamera() {
        return camera;
    }

    public String getInternet() {
        return internet;
    }

    public boolean isGpsModule() {
        return gpsModule;
    }

    public boolean isRecorder() {
        return recorder;
    }

    public double getPrice() {
        return price;
    }

    public double getOptPrice() {
        return optPrice;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
