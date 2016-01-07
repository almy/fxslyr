
package com.myftiu.jrasp.model.sl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusGroup {

    @SerializedName("Type")
    @Expose
    private String Type;
    @SerializedName("Title")
    @Expose
    private String Title;
    @SerializedName("Departures")
    @Expose
    private List<com.myftiu.jrasp.model.sl.Departures> Departures = new ArrayList<com.myftiu.jrasp.model.sl.Departures>();
    @SerializedName("CurrentServerTime")
    @Expose
    private String CurrentServerTime;
    @SerializedName("StopPointDeviations")
    @Expose
    private List<Object> StopPointDeviations = new ArrayList<Object>();
    @SerializedName("GroupId")
    @Expose
    private String GroupId;
    @SerializedName("JourneyProduct")
    @Expose
    private Integer JourneyProduct;

    /**
     * 
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    public BusGroup withType(String Type) {
        this.Type = Type;
        return this;
    }

    /**
     * 
     * @return
     *     The Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * 
     * @param Title
     *     The Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public BusGroup withTitle(String Title) {
        this.Title = Title;
        return this;
    }

    /**
     * 
     * @return
     *     The Departures
     */
    public List<com.myftiu.jrasp.model.sl.Departures> getDepartures() {
        return Departures;
    }

    /**
     * 
     * @param Departures
     *     The Departures
     */
    public void setDepartures(List<com.myftiu.jrasp.model.sl.Departures> Departures) {
        this.Departures = Departures;
    }

    public BusGroup withDepartures(List<com.myftiu.jrasp.model.sl.Departures> Departures) {
        this.Departures = Departures;
        return this;
    }

    /**
     * 
     * @return
     *     The CurrentServerTime
     */
    public String getCurrentServerTime() {
        return CurrentServerTime;
    }

    /**
     * 
     * @param CurrentServerTime
     *     The CurrentServerTime
     */
    public void setCurrentServerTime(String CurrentServerTime) {
        this.CurrentServerTime = CurrentServerTime;
    }

    public BusGroup withCurrentServerTime(String CurrentServerTime) {
        this.CurrentServerTime = CurrentServerTime;
        return this;
    }

    /**
     * 
     * @return
     *     The StopPointDeviations
     */
    public List<Object> getStopPointDeviations() {
        return StopPointDeviations;
    }

    /**
     * 
     * @param StopPointDeviations
     *     The StopPointDeviations
     */
    public void setStopPointDeviations(List<Object> StopPointDeviations) {
        this.StopPointDeviations = StopPointDeviations;
    }

    public BusGroup withStopPointDeviations(List<Object> StopPointDeviations) {
        this.StopPointDeviations = StopPointDeviations;
        return this;
    }

    /**
     * 
     * @return
     *     The GroupId
     */
    public String getGroupId() {
        return GroupId;
    }

    /**
     * 
     * @param GroupId
     *     The GroupId
     */
    public void setGroupId(String GroupId) {
        this.GroupId = GroupId;
    }

    public BusGroup withGroupId(String GroupId) {
        this.GroupId = GroupId;
        return this;
    }

    /**
     * 
     * @return
     *     The JourneyProduct
     */
    public Integer getJourneyProduct() {
        return JourneyProduct;
    }

    /**
     * 
     * @param JourneyProduct
     *     The JourneyProduct
     */
    public void setJourneyProduct(Integer JourneyProduct) {
        this.JourneyProduct = JourneyProduct;
    }

    public BusGroup withJourneyProduct(Integer JourneyProduct) {
        this.JourneyProduct = JourneyProduct;
        return this;
    }

}
