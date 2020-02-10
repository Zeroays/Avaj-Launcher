/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherTower.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 15:08:08 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:53:18 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.simulator;

import java.util.Random;
import avaj.aircrafts.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates cor) {
        return WeatherProvider.getProvider().getCurrentWeather(cor);
    }
    void changeWeather() {
        Random weatherRandomizer = new Random();
        WeatherProvider.randomizer = weatherRandomizer.nextInt(4);
        this.conditionsChanged();
    }
}