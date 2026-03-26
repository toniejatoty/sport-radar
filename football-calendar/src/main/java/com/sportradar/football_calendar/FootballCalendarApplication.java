package com.sportradar.football_calendar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportradar.football_calendar.service.DataImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballCalendarApplication.class, args);
    }

    
    
    @Bean
    public ObjectMapper objectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.findAndRegisterModules(); 
    return mapper;
}
    @Bean 
    public CommandLineRunner runImport(DataImportService dataImportService) {
        return args -> {
            String path = "C:\\Users\\konra\\Desktop\\vscode\\sportradar\\sport-radar\\example_input.json"; 
            
            System.out.println(">>> Rozpoczynam automatyczny import danych...");
            dataImportService.importDataFromJson(path);
            System.out.println(">>> Import zakończony!");
        };
    }
}