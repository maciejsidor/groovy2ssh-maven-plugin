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
package org.slf4j.impl;

import org.apache.maven.plugin.logging.Log;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * A logger binding that allows to bind the slf4j log events over maven log 
 * 
 * @author Maciej SIDOR
 */
public class StaticLoggerBinder implements LoggerFactoryBinder
{
    /**
     * Defult log factory
     */
    private ILoggerFactory factory = new MavenLogLoggerFactory();
    
    /**
     * The unique instance of this class.
     * 
     */
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    /**
     * Return the singleton of this class.
     * 
     * @return the StaticLoggerBinder singleton
     */
    public static final StaticLoggerBinder getSingleton() 
    {
      return SINGLETON;
    }   
    
    /**
     * Sets the maven logger.
     * This method must be called before any log event. 
     * @param log - maven log to set
     */
    public static void setMavenLog(Log log)
    {
        Logger slf4Jlogger = getSingleton().getLoggerFactory().getLogger( "null" );
        
        if(slf4Jlogger instanceof MavenLogAdapter)
        {
            MavenLogAdapter mavenLogAdapter = (MavenLogAdapter)slf4Jlogger;
            mavenLogAdapter.setLogger( log );
        }
        
    }

    @Override
    /**
     * Get the default log factory instance
     */
    public ILoggerFactory getLoggerFactory()
    {
        return factory;
    }

    @Override
    /**
     * Get the default maven log factory name
     */
    public String getLoggerFactoryClassStr()
    {
        return MavenLogLoggerFactory.class.getName();
    }

}
