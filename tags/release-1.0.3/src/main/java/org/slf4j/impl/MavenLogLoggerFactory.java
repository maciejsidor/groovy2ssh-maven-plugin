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

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * A logger factory that returns the wrapper over maven log {@link MavenLogAdapter} in conforming to the {@link Logger} interface..
 * 
 * @author Maciej SIDOR
 */
public class MavenLogLoggerFactory implements ILoggerFactory
{
	//logger adapter set by default
    private MavenLogAdapter logger = new MavenLogAdapter();

    /**
     * Returns the default instance of wrapper over maven log {@link MavenLogAdapter}
     * @param name - name of the logger (but it doesn't matter as the maven log doesn't support that. 
     */
    public Logger getLogger( String name )
    {
        return logger;
    }

}
