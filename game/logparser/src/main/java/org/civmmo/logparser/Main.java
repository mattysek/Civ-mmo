package org.civmmo.logparser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String args[]) throws IOException
    {
        //parseLogFile(args);
        parseResultsFile(args);
        
    }
    
    private static void parseResultsFile(String args[]) throws IOException
    {
        List<String> originalFile = Files.lines(Paths.get(args[0]),Charset.defaultCharset())
                                            .map(l -> Arrays.asList(l.split(",")).stream().map(i -> 
                                            {
                                                try
                                                {
                                                    return Duration.parse(i.trim()).toNanos();
                                                }
                                                catch(Exception ex)
                                                {
                                                    return 0;        
                                                }
                                            }).collect(Collectors.toList()))
                                            .map(i -> i.toString())
                                            .collect(Collectors.toList());
        
        Files.write(Paths.get("output.txt"), originalFile,Charset.defaultCharset(), StandardOpenOption.APPEND);
    }
    
    private static void parseLogFile(String args[]) throws IOException
    {
        List<String> originalFile = Files.lines(Paths.get(args[0]),Charset.defaultCharset())
                                            .collect(Collectors.toList());
        
        DurationAverager actionTestLogs = originalFile.stream()
                                            .filter(l -> l.contains("[ogm-test-logger]") && l.contains("Action"))
                                            .map(l -> Duration.parse(l.substring(l.lastIndexOf(":") + 2)))
                                            .collect(DurationAverager::new, 
                                                    DurationAverager::accept, 
                                                    DurationAverager::combine);
        
        DurationAverager actionRepositoryLogs = originalFile.stream()
                                            .filter(l -> l.contains("[ogm-repository-logger]") && l.contains("Action"))
                                            .map(l -> Duration.parse(l.substring(l.lastIndexOf(":") + 2)))
                                            .collect(DurationAverager::new, 
                                                    DurationAverager::accept, 
                                                    DurationAverager::combine);
        
        DurationAverager buildingTestLogs = originalFile.stream()
                                            .filter(l -> l.contains("[ogm-test-logger]") && l.contains("Building"))
                                            .map(l -> Duration.parse(l.substring(l.lastIndexOf(":") + 2)))
                                            .collect(DurationAverager::new, 
                                                    DurationAverager::accept, 
                                                    DurationAverager::combine);
        
        DurationAverager buildingRepositoryLogs = originalFile.stream()
                                            .filter(l -> l.contains("[ogm-repository-logger]") && l.contains("Building"))
                                            .map(l -> Duration.parse(l.substring(l.lastIndexOf(":") + 2)))
                                            .collect(DurationAverager::new, 
                                                    DurationAverager::accept, 
                                                    DurationAverager::combine);
        
        System.out.println("action repository logs average: " + actionRepositoryLogs.average());
        System.out.println("action test logs average: " + actionTestLogs.average());
        
        System.out.println("building repository logs average: " + buildingRepositoryLogs.average());
        System.out.println("building test logs average: " + buildingTestLogs.average());
        
        System.out.println("action repository logs total: " + actionRepositoryLogs.total());
        System.out.println("action test logs total: " + actionTestLogs.total());
        System.out.println("building repository logs total: " + buildingRepositoryLogs.total());
        System.out.println("building test logs total: " + buildingTestLogs.total());
    }
}
