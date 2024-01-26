package com.amaris.springboot.infraestructure.logger;

import com.amaris.springboot.application.ports.ILoggerApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerApplicationConsole  implements  ILoggerApplication{

    private final Log logger = LogFactory.getLog(this.getClass());
    @Override
    public void LogInformation(String message) {
        logger.info(message);
    }

    @Override
    public void LogWarning(String message) {
        logger.warn(message);
    }

    @Override
    public void LogError(String message) {
        logger.error(message);
    }
}
