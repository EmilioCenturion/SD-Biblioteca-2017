package com.sd.uni.biblioteca.utils;

import java.lang.management.ManagementFactory;
import java.util.Collection;
import java.util.HashSet;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.catalina.Engine;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardServer;
import org.apache.log4j.Logger;


public class TomcatConnectors {
	
	public static final String CATALINA_SERVICE_NAME = "Catalina";

    public static final String CONNECTOR_HTTP_PROTOCOL_NAME = "HTTP/1.1"; 

    private Logger logger = Logger.getLogger(this.getClass());

    private Collection<Connector> connectors;
    
    
    public TomcatConnectors() {
        super();
        this.connectors = new HashSet<Connector>();
        this.loadConnectors();
    }
    
    
    protected StandardServer getServerInstance(){
        org.apache.catalina.core.StandardServer server = null; 
        try{
            MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
            server = (StandardServer)mbeanServer.getAttribute(
                        new ObjectName("Catalina:type=Server"),
                        "managedResource"
                    );
            if(logger.isDebugEnabled()){
                logger.debug("Server found. Info: ");
                logger.debug(" - address          : " + server.getAddress());
                logger.debug(" - domain           : " + server.getDomain());
                logger.debug(" - info             : " + server.getInfo());
                logger.debug(" - shutdown port    : " + server.getPort());
                logger.debug(" - shutdown command : " + server.getShutdown());
                logger.debug(" - serverInfo       : " + server.getServerInfo());
                logger.debug(" - status           : " + server.getStateName());

            }               

        }catch(Throwable t){
            logger.fatal("Fatal Error Recovering StandardServer from MBeanServer : " + t.getClass().getName() + ": " + t.getMessage(), t);
        }
        return server;
    }

    
    protected Service getCatalinaService(){
        org.apache.catalina.core.StandardServer server = this.getServerInstance();
        Service[] services = server.findServices();
        for(Service aService : services){
            if(logger.isDebugEnabled()){
                logger.debug("Service: " + aService.getName() + 
                        ", info: " + aService.getInfo() + 
                        ", state: " + aService.getStateName());
            }

            if(aService.getName().equalsIgnoreCase(CATALINA_SERVICE_NAME)){
                return aService;                
            }
        }
        return null;
    }

    protected void loadConnectors() {
        Service catalinaService = this.getCatalinaService();
        if(catalinaService == null){
            throw new IllegalStateException("Service Catalina cannot be null");
        }
        if(catalinaService.findConnectors() != null && catalinaService.findConnectors().length > 0){
            logger.debug("List of connectors: ");
            for(Connector aConnector : catalinaService.findConnectors()){
            	Engine engine = (Engine) catalinaService.getContainer();
                if(logger.isDebugEnabled()){
                    logger.debug("Connector.getProtocol: " + aConnector.getProtocol());
                    logger.debug("Connector.getPort: " + aConnector.getPort());
                    logger.debug("Connector.getInfo: " + aConnector.getInfo());
                    logger.debug("Connector.getStateName: " + aConnector.getStateName());
                    logger.debug("Connector.property.bindOnInit: " + aConnector.getProperty("bindOnInit"));
                    logger.debug("Connector.attribute.bindOnInit: " + aConnector.getAttribute("bindOnInit"));
                    logger.debug("Connector.getState: " + aConnector.getState());
                    logger.debug("Engine.getJvmRoute: " + engine.getJvmRoute());
                }
                this.connectors.add(aConnector);
            }
        }
    }

 
    public Collection<Connector> getConnectors() {
        if(this.connectors.isEmpty()){
            this.loadConnectors();
        }
        return connectors;
    }

}
