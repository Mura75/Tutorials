package ant.com.fragmentsapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Murager on 09.04.2016.
 */
public class Cinema {

    @SerializedName("Phone")
    private String phone;

    @SerializedName("Geoposition")
    private String geoposition;

    @SerializedName("Website")
    private String website;

    @SerializedName("Mall")
    private String mall;

    @SerializedName("FullName")
    private String fullName;

    @SerializedName("Building")
    private String building;

    @SerializedName("ID")
    private String id;

    @SerializedName("Avenue")
    private String avenue;

    @SerializedName("City")
    private String city;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGeoposition() {
        return geoposition;
    }

    public void setGeoposition(String geoposition) {
        this.geoposition = geoposition;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "phone='" + phone + '\'' +
                ", geoposition='" + geoposition + '\'' +
                ", website='" + website + '\'' +
                ", mall='" + mall + '\'' +
                ", fullName='" + fullName + '\'' +
                ", building='" + building + '\'' +
                ", id='" + id + '\'' +
                ", avenue='" + avenue + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
