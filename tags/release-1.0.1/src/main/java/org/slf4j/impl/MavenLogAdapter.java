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

import java.io.Serializable;

import org.apache.maven.plugin.logging.Log;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/**
 * A wrapper over maven log in conforming to the {@link Logger} interface.
 * 
 * @author Maciej SIDOR
 */
public final class MavenLogAdapter
    extends MarkerIgnoringBase
    implements LocationAwareLogger, Serializable
{

    /**
     * Default serial version ID
     */
    private static final long serialVersionUID = 7652842044146321574L;

    /**
     * The maven log instance
     */
    transient Log logger = null;

    MavenLogAdapter(  )
    {
        this.name = "Maven log";
    }

    /**
     * Is this logger instance enabled for the TRACE level?
     * 
     * @return True if this Logger is enabled for level TRACE, false otherwise.
     */
    public boolean isTraceEnabled()
    {
        return false;
    }

    /**
     * Log a message object at level TRACE.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void trace( String msg )
    {
        logger.debug( msg );
    }

    /**
     * Log a message at level TRACE according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for level TRACE.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void trace( String format, Object arg )
    {
        if ( isTraceEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg );
            logger.debug( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level TRACE according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the TRACE level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void trace( String format, Object arg1, Object arg2 )
    {
        if ( isTraceEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg1, arg2 );
            logger.debug( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level TRACE according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the TRACE level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arguments
     *          an array of arguments
     */
    public void trace( String format, Object... arguments )
    {
        if ( isTraceEnabled() )
        {
            FormattingTuple ft = MessageFormatter.arrayFormat( format, arguments );
            logger.debug( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log an exception (throwable) at level TRACE with an accompanying message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void trace( String msg, Throwable t )
    {
        logger.debug( msg, t );
    }

    /**
     * Is this logger instance enabled for the DEBUG level?
     * 
     * @return True if this Logger is enabled for level DEBUG, false otherwise.
     */
    public boolean isDebugEnabled()
    {
        return logger.isDebugEnabled();
    }

    /**
     * Log a message object at level DEBUG.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void debug( String msg )
    {
        logger.debug( msg);
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for level DEBUG.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void debug( String format, Object arg )
    {
        if ( logger.isDebugEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg );
            logger.debug( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the DEBUG level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void debug( String format, Object arg1, Object arg2 )
    {
        if ( logger.isDebugEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg1, arg2 );
            logger.debug( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the DEBUG level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arguments an array of arguments
     */
    public void debug( String format, Object... arguments )
    {
        if ( logger.isDebugEnabled() )
        {
            FormattingTuple ft = MessageFormatter.arrayFormat( format, arguments );
            logger.debug( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log an exception (throwable) at level DEBUG with an accompanying message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void debug( String msg, Throwable t )
    {
        logger.debug( msg, t );
    }

    /**
     * Is this logger instance enabled for the INFO level?
     * 
     * @return True if this Logger is enabled for the INFO level, false otherwise.
     */
    public boolean isInfoEnabled()
    {
        return logger.isInfoEnabled();
    }

    /**
     * Log a message object at the INFO level.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void info( String msg )
    {
        logger.info( msg);
    }

    /**
     * Log a message at level INFO according to the specified format and argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void info( String format, Object arg )
    {
        if ( logger.isInfoEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg );
            logger.info( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at the INFO level according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void info( String format, Object arg1, Object arg2 )
    {
        if ( logger.isInfoEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg1, arg2 );
            logger.info( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level INFO according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void info( String format, Object... argArray )
    {
        if ( logger.isInfoEnabled() )
        {
            FormattingTuple ft = MessageFormatter.arrayFormat( format, argArray );
            logger.info( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log an exception (throwable) at the INFO level with an accompanying
     * message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void info( String msg, Throwable t )
    {
        logger.info( msg, t );
    }

    /**
     * Is this logger instance enabled for the WARN level?
     * 
     * @return True if this Logger is enabled for the WARN level, false otherwise.
     */
    public boolean isWarnEnabled()
    {
        return logger.isWarnEnabled();
    }

    /**
     * Log a message object at the WARN level.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void warn( String msg )
    {
        logger.warn(msg);
    }

    /**
     * Log a message at the WARN level according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void warn( String format, Object arg )
    {
        if ( logger.isWarnEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg );
            logger.warn( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at the WARN level according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void warn( String format, Object arg1, Object arg2 )
    {
        if ( logger.isWarnEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg1, arg2 );
            logger.warn( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level WARN according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void warn( String format, Object... argArray )
    {
        if ( logger.isWarnEnabled() )
        {
            FormattingTuple ft = MessageFormatter.arrayFormat( format, argArray );
            logger.warn( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log an exception (throwable) at the WARN level with an accompanying
     * message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void warn( String msg, Throwable t )
    {
        logger.warn( msg, t );
    }

    /**
     * Is this logger instance enabled for level ERROR?
     * 
     * @return True if this Logger is enabled for level ERROR, false otherwise.
     */
    public boolean isErrorEnabled()
    {
        return logger.isErrorEnabled();
    }

    /**
     * Log a message object at the ERROR level.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void error( String msg )
    {
        logger.error( msg );
    }

    /**
     * Log a message at the ERROR level according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void error( String format, Object arg )
    {
        if ( logger.isErrorEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg );
            logger.error( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at the ERROR level according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void error( String format, Object arg1, Object arg2 )
    {
        if ( logger.isErrorEnabled() )
        {
            FormattingTuple ft = MessageFormatter.format( format, arg1, arg2 );
            logger.error( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log a message at level ERROR according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void error( String format, Object... argArray )
    {
        if ( logger.isErrorEnabled() )
        {
            FormattingTuple ft = MessageFormatter.arrayFormat( format, argArray );
            logger.error( ft.getMessage(), ft.getThrowable() );
        }
    }

    /**
     * Log an exception (throwable) at the ERROR level with an accompanying
     * message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void error( String msg, Throwable t )
    {
        logger.error( msg, t );
    }

    public void log( Marker marker, String callerFQCN, int level, String msg, Object[] argArray, Throwable t )
    {
        switch ( level )
        {
            case LocationAwareLogger.TRACE_INT:
                logger.debug( msg, t );
                break;
            case LocationAwareLogger.DEBUG_INT:
                logger.debug( msg, t );
                break;
            case LocationAwareLogger.INFO_INT:
                logger.info( msg, t );
                break;
            case LocationAwareLogger.WARN_INT:
                logger.warn( msg, t );
                break;
            case LocationAwareLogger.ERROR_INT:
                logger.error( msg, t );
                break;
            default:
                throw new IllegalStateException( "Level number " + level + " is not recognized." );
        }
        
    }

    /**
     * Returns the maven logger instance
     * @return the maven logger instance
     */
    public Log getLogger()
    {
        return logger;
    }
    
    /**
     * Sets the maven logger instance
     * @param log - the maven logger instance
     */
    public void setLogger(Log log)
    {
        this.logger=log;
    }

}
