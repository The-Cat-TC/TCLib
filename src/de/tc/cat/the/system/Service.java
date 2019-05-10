/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

/**
 * Creates a virtual service.
 *@version 1.0
 * @since  1.8
 * @author Christian Trostmann
 */
public class Service {
    private final String name;
    private String status;
    private String option;
    
    /**
     * Creates the service.
     * @param sname Specifies the name of the service.
     * @param sstatus Indicates the status of the service, whether it is enabled or disabled.
     * @param soption Specifies the option of the service whether it is running or stopped.
     */
    public Service(String sname, Status sstatus, Option soption)
    {
        name = sname;
        status = sstatus.name();
        option = soption.name();
    }
    
    /**
     * Issues the option that the service has.
     * @return Return the option of service as a string.
     */
    public String getOption()
    {
        return option;
    }
    
    /**
     * Get the status.
     * @return Returns the status as a string.
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * Get the name.
     * @return Returns the name as a string.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get out if the service is enabled.
     * @return Returns the status as a Boolean.
     */
    public boolean isAktiv()
    {
        return "Aktiviert".equals(status);
    }
    
    /**
     * Get out if the service is running.
     * @return Returns the status of the service as a Boolean.
     */
    public boolean isRunning()
    {
        return "Run".equals(option);
    }
    
    /**
     * Changes the status of the service to Enabled or disabled.
     * @param sstatus Specifies the states to which the service can take turns on or off.
     */
    public void setStatus(Status sstatus)
    {
        status = sstatus.name();
    }
    
    /**
     * Changes the option for the service to stop or run.
     * @param soption Specifies the states to which the service can take run or stop.
     */
    public void setOption(Option soption)
    {
        option = soption.name();
    }
}
