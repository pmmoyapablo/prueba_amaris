package com.amaris.springboot.application.ports;

public interface ILoggerApplication {
    void LogInformation(String message);
    void LogWarning(String message);
    void LogError(String message);
}
