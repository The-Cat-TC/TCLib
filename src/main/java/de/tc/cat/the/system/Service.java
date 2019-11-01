/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a virtual service.
 *
 *@version 1.0
 * @since  1.8
 * @author Christian Trostmann
 */
public class Service {
    private final String name;
    private String status;
    private String option;
    private final List<ServiceListener> onSystemListener = new ArrayList<>();
    
    /**
     * Creates the service.
     *
     * @param sname Specifies the name of the service.
     * @param sstatus Indicates the status of the service, whether it is enabled or disabled.
     * @param soption Specifies the option of the service whether it is running or stopped.
     */
    public Service(String sname, Status sstatus, Option soption)
    {
        name = sname;
        status = sstatus.name();
        option = soption.name();
        getAction();
    }
    
    /**
     * Issues the option that the service has.
     *
     * @return Return the option of service as a string.
     */
    public String getOption()
    {
        return option;
    }
    
    /**
     * Get the status.
     *
     * @return Returns the status as a string.
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * Get the name.
     *
     * @return Returns the name as a string.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get out if the service is enabled.
     *
     * @return Returns the status as a Boolean.
     */
    public boolean isAktiv()
    {
        return "Aktiviert".equals(status);
    }
    
    /**
     * Get out if the service is running.
     *
     * @return Returns the status of the service as a Boolean.
     */
    public boolean isRunning()
    {
        return "Run".equals(option);
    }
    
    /**
     * Changes the status of the service to Enabled or disabled.
     *
     * @param sstatus Specifies the states to which the service can take turns on or off.
     */
    public void setStatus(Status sstatus)
    {
        status = sstatus.name();
        if("Aktiviert".equals(status))
        {
            onEnableEvent();
    }
        else if ("Deaktiviert".equals(status))
        {
            onDisableEvent();
        }
    
    }
    
    /**
     * Changes the option for the service to stop or run.
     *
     * @param soption Specifies the states to which the service can take run or stop.
     */
    public void setOption(Option soption)
    {
        option = soption.name();
        if (option.equals("Run") || isAktiv() == true)
        {
            onStartEvent();
    }
        else if (option.equals("Stop") || isAktiv() == true)
        {
            onStopEvent();
}
            
    }

    /**
     * Adds an EventListener class to the Service class.
     *
     * @param listener Defines the listener from the type ServiceListener.
     */
    public void addSystemListener(ServiceListener listener)
    {
        onSystemListener.add(listener);
    }
    
    /**
     * Removes the Service class from an EventListener.
     *
     * @param listener Defines the listener from the type ServiceListener.
     */
    public void removeSystemListener(ServiceListener listener)
    {
        onSystemListener.remove(listener);
    }
    
    /**
     * Runs the events that are defined for the Server class.
     */
    public final void getAction()
    {
        if ("Run".equals(option) && isAktiv() == true)
        {
            onStartEvent();
        }
        else if ("Stop".equals(option) && isAktiv() == true)
        {
            onStopEvent();
        }
        
        if("Aktiviert".equals(status))
        {
            onEnableEvent();
        }
        else if ("Deaktiviert".equals(status))
        {
            onDisableEvent();
        }
    }

    
    
    private void onStopEvent()
    {
        onSystemListener.forEach(ServiceListener -> ServiceListener.onStop(this.name));
    }
    
    private void onStartEvent()
    {
        onSystemListener.forEach(ServiceListener -> ServiceListener.onStart(this.name));
    }
    
    private void onEnableEvent()
    {
        onSystemListener.forEach(ServiceListener -> ServiceListener.onEnable(this.name));
    }
    
    private void onDisableEvent()
    {
        onSystemListener.forEach(ServiceListener -> ServiceListener.onDisable(this.name));
    }
}