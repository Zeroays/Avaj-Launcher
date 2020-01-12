/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulator.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 16:44:12 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 13:04:13 by vrabaib          ###   ########.fr       */
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
        if (args.length != 1)
            return ;
        openScenario(args[0]);
    }
    public static void openScenario(String file) {
        BufferedReader reader = null;
        File scenario = new File(file);
        String text;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found...");
        } catch (IOException e) {
            System.out.println("Error related to reading file...");
        } finally {
            try {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e) {
                System.out.println("Error closing file...");
            }
        }
    }
}