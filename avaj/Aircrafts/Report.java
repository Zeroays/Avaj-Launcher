/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Report.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 14:27:43 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:52:53 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;

import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Report {
    public static BufferedWriter report;
    public static BufferedWriter getReport() {
        if (report == null) {
            try {
                report = new BufferedWriter(new FileWriter("simulation.txt"));
            } catch (IOException e) {
                System.out.println("Error creating the simulation report");
                System.exit(1);
            }
        }
        return report;
    }
    public static void update(String update) {
        BufferedWriter curReport = getReport();
        try {
            curReport.write(update);
        } catch (IOException e) {
            System.out.println("Cannot update simulation report");
            System.exit(1);
        }
        
    }
}