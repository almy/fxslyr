
package com.myftiu.jrasp.model.sl;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SLInfo {

    @SerializedName("ms")
    @Expose
    private Integer ms;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * 
     * @return
     *     The ms
     */
    public Integer getMs() {
        return ms;
    }

    /**
     * 
     * @param ms
     *     The ms
     */
    public void setMs(Integer ms) {
        this.ms = ms;
    }

    public SLInfo withMs(Integer ms) {
        this.ms = ms;
        return this;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public SLInfo withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(Data data) {
        this.data = data;
    }

    public SLInfo withData(Data data) {
        this.data = data;
        return this;
    }

}
