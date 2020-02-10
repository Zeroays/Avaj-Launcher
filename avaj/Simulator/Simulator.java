/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulator.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 16:44:12 by vrabaib           #+#    #+#             */
/*   Updated: 2020/02/10 12:57:37 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.simulator;

import avaj.aircrafts.Flyable;
import avaj.aircrafts.AircraftFactory;
import avaj.aircrafts.Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Simulator {
    static WeatherTower avajTower = new WeatherTower();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java Simulator [scenario.txt]");
            return ;
        }
        Processor.processScenario(args[0]);
        runSimulation();
        endReport();
    }
    private static void runSimulation() {
        int simNum = Processor.getSimNum();
        List<Flyable> aircrafts = Processor.getAircrafts();
        for (Flyable avajs : aircrafts) {
            avajs.registerTower(avajTower);
        }
        while (simNum > 0) {
            avajTower.changeWeather();
            simNum--;
        }
    }
    private static void endReport() {
        try {
            Report.getReport().close();
        } catch (IOException e) {
            System.out.println("Could not close file");
            System.exit(1);
        }
    }
}

class Processor {
    private static int simNum;
    private static List<Flyable> aircrafts = new ArrayList<>();
    private static AircraftFactory avajFactory = new AircraftFactory();

    public static int getSimNum() {
        return simNum;
    }

    public static List<Flyable> getAircrafts() {
        return aircrafts;
    }

    public static void processScenario(String file) {
        BufferedReader reader = null;
        File scenario = new File(file);
        String text;
        int lineNum = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((text = reader.readLine()) != null) {
                lineNum++;
                checkScenario(text, lineNum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error related to reading file...");
            System.exit(1);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e) {
                System.out.println("Error closing file...");
                System.exit(1);
            }
        }
    }
    private static void checkScenario(String text, int lineNum) {
        if (lineNum == 1)
            checkSimulationNum(text);
        else
            checkAircrafts(text);
    }
    private static void checkSimulationNum(String simNum) {
        Integer simNumResult = ParseHandler.parseInteger(simNum);

        if (simNumResult == null) {
            System.out.println("Error reading Number of Simulations.  Is it a positive integer?");
            System.exit(1);
        } else if (simNumResult.intValue() <= 0) {
            System.out.println("Invalid First Line.  Simulation must be positive integer value.");
            System.exit(1);
        } 
        Processor.simNum = simNumResult;
    }
    private static void checkAircrafts(String aircraftInfo) {
        String[] aircrafts = {"Baloon", "Helicopter", "JetPlane"};
        String[] result = aircraftInfo.split(" ");

        if (result.length != 5) {
            System.out.println("Format of Aircraft Info should be as follows:");
            System.out.println("[TYPE NAME LONGITUDE LATITUDE HEIGHT]");
            System.exit(1);
        }
        String type = result[0];
        String name = result[1];
        Integer longitude = ParseHandler.parseInteger(result[2]);
        Integer latitude = ParseHandler.parseInteger(result[3]);
        Integer height = ParseHandler.parseInteger(result[4]);

        if (!Arrays.asList(aircrafts).contains(result[0])) {
            System.out.println("Aircraft Name does not exist");
            System.exit(1);
        }
        if (longitude == null || latitude == null || height == null) {
            System.out.println("Longitude, Latitude, and/or Height is not a numerical value");
            System.exit(1);
        }
        if (longitude.intValue() < 0 || latitude.intValue() < 0 || height.intValue() < 0) {
            System.out.println("Longitude, Latitude, and/or Height must be a positive integer value");
            System.exit(1);
        }
        Flyable newAircraft = avajFactory.newAircraft(type, name, longitude, latitude, height);
        Processor.aircrafts.add(newAircraft);
    }
}

class ParseHandler {
    public static Integer parseInteger(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}