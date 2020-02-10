/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Baloon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 15:00:53 by vrabaib           #+#    #+#             */
/*   Updated: 2020/02/07 12:33:23 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;

import avaj.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String curForcast = weatherTower.getWeather(this.coordinates);
        Report.update(fullID() + ": ");
        switch (curForcast) {
            case "Rain":
                Report.update("ChocOlate Raiiiiiin.\n");
                break;
            case "Fog":
                Report.update("Mmmm.  Misty\n");
                break;
            case "Sun":
                Report.update("Over the Sunshine Rainbowwwww.\n");
                break;
            case "Snow":
                Report.update("Baloon is shriveling.\n");
                break;
        }
        adjustCor(curForcast);
        if (this.coordinates.getHeight() <= 0) {
            landing();
            this.weatherTower.unregister(this);
            Report.update("Tower says: " + fullID() + " unregistered from weather tower\n");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Report.update("Tower says: " + fullID() + "registered to weather tower\n");
    }

    private void adjustCor(String curForcast) {
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int h = this.coordinates.getHeight();
        if (curForcast == "Sun")
            this.coordinates = new Coordinates(lon + 2, lat, h + 4);
        else if (curForcast == "Rain")
            this.coordinates = new Coordinates(lon, lat, h - 5);
        else if (curForcast == "Fog")
            this.coordinates = new Coordinates(lon, lat, h - 3);
        else if (curForcast == "Snow")
            this.coordinates = new Coordinates(lon, lat, h - 15);
    }
}