/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulator.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 16:44:12 by vrabaib           #+#    #+#             */
/*   Updated: 2020/02/08 12:42:16 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import avaj.aircrafts.AircraftFactory;
import avaj.towers.*;
import avaj.weather.WeatherProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("usage: java Simulator [scenario.txt]");
            return ;
        }
        openScenario(args[0]);
    }
    private static void openScenario(String file) {
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
            validSimulationNum(text);
        else
            validAircrafts(text);
    }
    private static void validSimulationNum(String simNum) {
        try {
            int result = Integer.parseInt(simNum);
            if (result <= 0) {
                System.out.println("Invalid First Line.  Simulation must be positive integer value.");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error reading Number of Simulations.  Is it a positive integer?");
            System.exit(1);
        }
    }
    private static void validAircrafts(String aircraftInfo) {
        String[] result = aircraftInfo.split(" ");
        if (result[0] != )
    }
}