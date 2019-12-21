/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Helicopter.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 13:46:24 by vrabaib           #+#    #+#             */
/*   Updated: 2019/12/17 16:29:42 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import Coordinates;
import java.Towers.WeatherTower;

public class Helicopter implements Flyable extends Aircraft {
    private weatherTower;

    private Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}