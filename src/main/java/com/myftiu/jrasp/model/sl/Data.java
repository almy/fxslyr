
package com.myftiu.jrasp.model.sl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("BusGroups")
    @Expose
    private List<BusGroup> BusGroups = new ArrayList<BusGroup>();
    @SerializedName("TrainGroups")
    @Expose
    private List<Object> TrainGroups = new ArrayList<Object>();
    @SerializedName("TranCityTypes")
    @Expose
    private List<Object> TranCityTypes = new ArrayList<Object>();
    @SerializedName("TramTypes")
    @Expose
    private List<Object> TramTypes = new ArrayList<Object>();
    @SerializedName("MetroRedGroups")
    @Expose
    private List<Object> MetroRedGroups = new ArrayList<Object>();
    @SerializedName("MetroGreenGroups")
    @Expose
    private List<Object> MetroGreenGroups = new ArrayList<Object>();
    @SerializedName("MetroBlueGroups")
    @Expose
    private List<Object> MetroBlueGroups = new ArrayList<Object>();
    @SerializedName("ShipGroups")
    @Expose
    private List<Object> ShipGroups = new ArrayList<Object>();
    @SerializedName("HasStopPointDeviations")
    @Expose
    private Boolean HasStopPointDeviations;
    @SerializedName("LastUpdate")
    @Expose
    private String LastUpdate;
    @SerializedName("Error")
    @Expose
    private Object Error;
    @SerializedName("HasResultData")
    @Expose
    private Boolean HasResultData;

    /**
     * 
     * @return
     *     The BusGroups
     */
    public List<BusGroup> getBusGroups() {
        return BusGroups;
    }

    /**
     * 
     * @param BusGroups
     *     The BusGroups
     */
    public void setBusGroups(List<BusGroup> BusGroups) {
        this.BusGroups = BusGroups;
    }

    public Data withBusGroups(List<BusGroup> BusGroups) {
        this.BusGroups = BusGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The TrainGroups
     */
    public List<Object> getTrainGroups() {
        return TrainGroups;
    }

    /**
     * 
     * @param TrainGroups
     *     The TrainGroups
     */
    public void setTrainGroups(List<Object> TrainGroups) {
        this.TrainGroups = TrainGroups;
    }

    public Data withTrainGroups(List<Object> TrainGroups) {
        this.TrainGroups = TrainGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The TranCityTypes
     */
    public List<Object> getTranCityTypes() {
        return TranCityTypes;
    }

    /**
     * 
     * @param TranCityTypes
     *     The TranCityTypes
     */
    public void setTranCityTypes(List<Object> TranCityTypes) {
        this.TranCityTypes = TranCityTypes;
    }

    public Data withTranCityTypes(List<Object> TranCityTypes) {
        this.TranCityTypes = TranCityTypes;
        return this;
    }

    /**
     * 
     * @return
     *     The TramTypes
     */
    public List<Object> getTramTypes() {
        return TramTypes;
    }

    /**
     * 
     * @param TramTypes
     *     The TramTypes
     */
    public void setTramTypes(List<Object> TramTypes) {
        this.TramTypes = TramTypes;
    }

    public Data withTramTypes(List<Object> TramTypes) {
        this.TramTypes = TramTypes;
        return this;
    }

    /**
     * 
     * @return
     *     The MetroRedGroups
     */
    public List<Object> getMetroRedGroups() {
        return MetroRedGroups;
    }

    /**
     * 
     * @param MetroRedGroups
     *     The MetroRedGroups
     */
    public void setMetroRedGroups(List<Object> MetroRedGroups) {
        this.MetroRedGroups = MetroRedGroups;
    }

    public Data withMetroRedGroups(List<Object> MetroRedGroups) {
        this.MetroRedGroups = MetroRedGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The MetroGreenGroups
     */
    public List<Object> getMetroGreenGroups() {
        return MetroGreenGroups;
    }

    /**
     * 
     * @param MetroGreenGroups
     *     The MetroGreenGroups
     */
    public void setMetroGreenGroups(List<Object> MetroGreenGroups) {
        this.MetroGreenGroups = MetroGreenGroups;
    }

    public Data withMetroGreenGroups(List<Object> MetroGreenGroups) {
        this.MetroGreenGroups = MetroGreenGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The MetroBlueGroups
     */
    public List<Object> getMetroBlueGroups() {
        return MetroBlueGroups;
    }

    /**
     * 
     * @param MetroBlueGroups
     *     The MetroBlueGroups
     */
    public void setMetroBlueGroups(List<Object> MetroBlueGroups) {
        this.MetroBlueGroups = MetroBlueGroups;
    }

    public Data withMetroBlueGroups(List<Object> MetroBlueGroups) {
        this.MetroBlueGroups = MetroBlueGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The ShipGroups
     */
    public List<Object> getShipGroups() {
        return ShipGroups;
    }

    /**
     * 
     * @param ShipGroups
     *     The ShipGroups
     */
    public void setShipGroups(List<Object> ShipGroups) {
        this.ShipGroups = ShipGroups;
    }

    public Data withShipGroups(List<Object> ShipGroups) {
        this.ShipGroups = ShipGroups;
        return this;
    }

    /**
     * 
     * @return
     *     The HasStopPointDeviations
     */
    public Boolean getHasStopPointDeviations() {
        return HasStopPointDeviations;
    }

    /**
     * 
     * @param HasStopPointDeviations
     *     The HasStopPointDeviations
     */
    public void setHasStopPointDeviations(Boolean HasStopPointDeviations) {
        this.HasStopPointDeviations = HasStopPointDeviations;
    }

    public Data withHasStopPointDeviations(Boolean HasStopPointDeviations) {
        this.HasStopPointDeviations = HasStopPointDeviations;
        return this;
    }

    /**
     * 
     * @return
     *     The LastUpdate
     */
    public String getLastUpdate() {
        return LastUpdate;
    }

    /**
     * 
     * @param LastUpdate
     *     The LastUpdate
     */
    public void setLastUpdate(String LastUpdate) {
        this.LastUpdate = LastUpdate;
    }

    public Data withLastUpdate(String LastUpdate) {
        this.LastUpdate = LastUpdate;
        return this;
    }

    /**
     * 
     * @return
     *     The Error
     */
    public Object getError() {
        return Error;
    }

    /**
     * 
     * @param Error
     *     The Error
     */
    public void setError(Object Error) {
        this.Error = Error;
    }

    public Data withError(Object Error) {
        this.Error = Error;
        return this;
    }

    /**
     * 
     * @return
     *     The HasResultData
     */
    public Boolean getHasResultData() {
        return HasResultData;
    }

    /**
     * 
     * @param HasResultData
     *     The HasResultData
     */
    public void setHasResultData(Boolean HasResultData) {
        this.HasResultData = HasResultData;
    }

    public Data withHasResultData(Boolean HasResultData) {
        this.HasResultData = HasResultData;
        return this;
    }

}
