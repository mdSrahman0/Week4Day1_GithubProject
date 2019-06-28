
package com.example.week4day1_githubproject.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoResponse implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pushed_at")
    @Expose
    private String pushedAt;
    public final static Parcelable.Creator<RepoResponse> CREATOR = new Creator<RepoResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RepoResponse createFromParcel(Parcel in) {
            return new RepoResponse(in);
        }

        public RepoResponse[] newArray(int size) {
            return (new RepoResponse[size]);
        }
    }
    ;

    protected RepoResponse(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.pushedAt = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RepoResponse() {
    }

    /**
     * 
     * @param updatedAt
     * @param pushedAt
     * @param createdAt
     * @param name
     */
    public RepoResponse(String name, String createdAt, String updatedAt, String pushedAt) {
        super();
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.pushedAt = pushedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(pushedAt);
    }

    public int describeContents() {
        return  0;
    }

}
