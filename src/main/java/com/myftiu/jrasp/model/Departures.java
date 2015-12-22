package com.myftiu.jrasp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author by ali myftiu on 22/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Departures
{
    @JsonProperty("LineNumber")
    private String LineNumber;

    @JsonProperty("ExpectedDateTime")
    private String ExpectedDateTime;

    @JsonProperty("StopPointNumber")
    private String StopPointNumber;

    @JsonProperty("Deviations")
    private String[] Deviations;

    @JsonProperty("DisplayTime")
    private String DisplayTime;

    @JsonProperty("Destination")
    private String Destination;

    public String getLineNumber ()
    {
        return LineNumber;
    }

    public void setLineNumber (String LineNumber)
    {
        this.LineNumber = LineNumber;
    }

    public String getExpectedDateTime ()
    {
        return ExpectedDateTime;
    }

    public void setExpectedDateTime (String ExpectedDateTime)
    {
        this.ExpectedDateTime = ExpectedDateTime;
    }

    public String getStopPointNumber ()
    {
        return StopPointNumber;
    }

    public void setStopPointNumber (String StopPointNumber)
    {
        this.StopPointNumber = StopPointNumber;
    }

    public String[] getDeviations ()
    {
        return Deviations;
    }

    public void setDeviations (String[] Deviations)
    {
        this.Deviations = Deviations;
    }

    public String getDisplayTime ()
    {
        return DisplayTime;
    }

    public void setDisplayTime (String DisplayTime)
    {
        this.DisplayTime = DisplayTime;
    }

    public String getDestination ()
    {
        return Destination;
    }

    public void setDestination (String Destination)
    {
        this.Destination = Destination;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LineNumber = "+LineNumber+", ExpectedDateTime = "+ExpectedDateTime+", StopPointNumber = "+StopPointNumber+", Deviations = "+Deviations+", DisplayTime = "+DisplayTime+", Destination = "+Destination+"]";
    }
}
