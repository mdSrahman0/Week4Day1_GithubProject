
package com.example.week4day1_githubproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubResponse implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("bio")
    @Expose
    private String bio;
    public final static Parcelable.Creator<GithubResponse> CREATOR = new Creator<GithubResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GithubResponse createFromParcel(Parcel in) {
            return new GithubResponse(in);
        }

        public GithubResponse[] newArray(int size) {
            return (new GithubResponse[size]);
        }

    }
    ;

    protected GithubResponse(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.bio = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public GithubResponse() {
    }

    /**
     * 
     * @param bio
     * @param location
     * @param company
     * @param name
     */
    public GithubResponse(String name, String company, String location, String bio) {
        super();
        this.name = name;
        this.company = company;
        this.location = location;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(company);
        dest.writeValue(location);
        dest.writeValue(bio);
    }

    public int describeContents() {
        return  0;
    }

}
