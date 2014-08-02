/*
Copyright 2014 Maciej SIDOR [maciejsidor@gmail.com]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.	
 */
package com.googlecode.msidor.maven.plugins.groovy2ssh;

import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.googlecode.msidor.groovy2ssh.SSHManager;
import com.jcraft.jsch.JSchException;

/**
 * @author Maciej SIDOR
 * 
 * Implementation of "execute" goal.
 * 
 * <p>
 * Maven plugin that allows to execute shell commands via groovy script on remote host through ssh connection.
 * This is basically only the maven plugin wrapper for com.googlecode.msidor.groovy2ssh library.
 * See {@link com.googlecode.msidor.groovy2ssh} for more information.
 * </p>
 *
 * @goal execute
 */
public class Groovy2SSHMojo extends AbstractMojo
{

    /**
     * SSH user name. REQUIRED
     * @parameter 
     */     
    String userName 			= null;

    /**
     * SSH user password. REQUIRED
     * @parameter 
     */     
    String password 			= null;
    
    /**
     * SSH server address. REQUIRED
     * @parameter 
     */         
    String connectionIP 		= null;
    
    /**
     * SSH known hosts files. REQUIRED
     * @parameter 
     */         
    String knownHostsFileName 	= null;
    
    /**
     * Groovy script to execute. REQUIRED
     * @parameter 
     */         
    String scriptToExecute 		= null;
    
    /**
     * Groovy script roots. REQUIRED
     * @parameter 
     */     
    String scriptRoots 			= null;

    /**
     * SSH connection port.
     * @parameter 
     */         
	int connectionPort = 22;

    /**
     * SSH connection timeout.
     * @parameter 
     */         	
	int connectionTimeOut = 60000;
	
    /**
     * SSH connection timeout.
     * @parameter 
     */             
    int commandTimeOut = 3000;	
    
    /**
     * Additional parameters that will be binded to groovy execution.
     * 
     * @parameter
     */
    private Map<String, Object> parameters = null;    
    
	
    /**
     * Implementation of "execute" goal.
     * 
     * @throws MojoExecutionException if groovy script was not successfully terminated
     */
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException
	{
	    SSHManager instance    = null;
	    boolean    result      = false; 
	    
	    
	    
		getLog().info("Preparing SSH connection...");
		try
		{
		    instance = new SSHManager( userName, password, connectionIP, knownHostsFileName,connectionPort,connectionTimeOut,commandTimeOut );
		}
		catch(JSchException ex)
		{
		    throw new MojoExecutionException(ex.getMessage());
		}		        
        
        try
        {		
            getLog().info("Connecting to remote host...");
            instance.connect();
        }
        catch(JSchException ex)
        {
            throw new MojoExecutionException(ex.getMessage());
        }               

       
        getLog().info("Executing groovy script...");
        result = instance.executeGroovyScript(parameters,scriptToExecute, scriptRoots);
                                                
        getLog().info("Disconnecting from remote host...");
        instance.close();
        
        if(!result)
            throw new MojoExecutionException("Groovy script execution failed. See log for more details");
		
	}
	
	
	

}
