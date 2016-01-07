
package com.myftiu.jrasp.model.sl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Departures {

    @SerializedName("LineNumber")
    @Expose
    private String LineNumber;
    @SerializedName("Destination")
    @Expose
    private String Destination;
    @SerializedName("ExpectedDateTime")
    @Expose
    private String ExpectedDateTime;
    @SerializedName("DisplayTime")
    @Expose
    private String DisplayTime;
    @SerializedName("Deviations")
    @Expose
    private List<Object> Deviations = new ArrayList<Object>();
    @SerializedName("StopPointNumber")
    @Expose
    private String StopPointNumber;

    /**
     * 
     * @return
     *     The LineNumber
     */
    public String getLineNumber() {
        return LineNumber;
    }

    /**
     * 
     * @param LineNumber
     *     The LineNumber
     */
    public void setLineNumber(String LineNumber) {
        this.LineNumber = LineNumber;
    }

    public Departures withLineNumber(String LineNumber) {
        this.LineNumber = LineNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The Destination
     */
    public String getDestination() {
        return Destination;
    }

    /**
     * 
     * @param Destination
     *     The Destination
     */
    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public Departures withDestination(String Destination) {
        this.Destination = Destination;
        return this;
    }

    /**
     * 
     * @return
     *     The ExpectedDateTime
     */
    public String getExpectedDateTime() {
        return ExpectedDateTime;
    }

    /**
     * 
     * @param ExpectedDateTime
     *     The ExpectedDateTime
     */
    public void setExpectedDateTime(String ExpectedDateTime) {
        this.ExpectedDateTime = ExpectedDateTime;
    }

    public Departures withExpectedDateTime(String ExpectedDateTime) {
        this.ExpectedDateTime = ExpectedDateTime;
        return this;
    }

    /**
     * 
     * @return
     *     The DisplayTime
     */
    public String getDisplayTime() {
        return DisplayTime;
    }

    /**
     * 
     * @param DisplayTime
     *     The DisplayTime
     */
    public void setDisplayTime(String DisplayTime) {
        this.DisplayTime = DisplayTime;
    }

    public Departures withDisplayTime(String DisplayTime) {
        this.DisplayTime = DisplayTime;
        return this;
    }

    /**
     * 
     * @return
     *     The Deviations
     */
    public List<Object> getDeviations() {
        return Deviations;
    }

    /**
     * 
     * @param Deviations
     *     The Deviations
     */
    public void setDeviations(List<Object> Deviations) {
        this.Deviations = Deviations;
    }

    public Departures withDeviations(List<Object> Deviations) {
        this.Deviations = Deviations;
        return this;
    }

    /**
     * 
     * @return
     *     The StopPointNumber
     */
    public String getStopPointNumber() {
        return StopPointNumber;
    }

    /**
     * 
     * @param StopPointNumber
     *     The StopPointNumber
     */
    public void setStopPointNumber(String StopPointNumber) {
        this.StopPointNumber = StopPointNumber;
    }

    public Departures withStopPointNumber(String StopPointNumber) {
        this.StopPointNumber = StopPointNumber;
        return this;
    }

}
