package com.myftiu.jrasp.model.yr;

/**
 * @author by ali myftiu on 22/12/15.
 */
public class Meta {

    private String lastupdate;

    private String nextupdate;

    public String getLastupdate ()
    {
        return lastupdate;
    }

    public void setLastupdate (String lastupdate)
    {
        this.lastupdate = lastupdate;
    }

    public String getNextupdate ()
    {
        return nextupdate;
    }

    public void setNextupdate (String nextupdate)
    {
        this.nextupdate = nextupdate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lastupdate = "+lastupdate+", nextupdate = "+nextupdate+"]";
    }
}
