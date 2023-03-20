package com.leonardo.springmvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class Student {
    
    private String firstName;
    
    @NotNull(message = "Last name is required")
    @Size(min = 1, message = "Last name minimum size is '1'")
    private String lastName;
    private String country;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal code must have only 5 digits")
    private String postalCode;
    private String favoriteLanguage;
    private List<String> operatingSystems;
    private LinkedHashMap<String, String> countryOptions;
    
    @NotNull(message = "Free passes is required")
    @Min(value = 0, message = "Free passes must be greater or equal to zero")
    @Max(value = 10, message = "Free passes must be less than or equal to '10'")
    private Integer freePasses;

    @CourseCode
    private String courseCode;

    public Student() {
        operatingSystems = new ArrayList<>();
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }
    
    public void setOperatingSystems(List<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public List<String> getCountryOptions() {
        List<String> countries = new ArrayList<>();
        countries = countryOptions.entrySet().stream().map(x -> x.getValue()).toList();
        return countries;
    }

    public List<String> getOperatingSystems() {
        return operatingSystems;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
