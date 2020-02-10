/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   JetPlane.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 15:00:51 by vrabaib           #+#    #+#             */
/*   Updated: 2020/02/07 13:00:51 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;

import avaj.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String curForcast = weatherTower.getWeather(this.coordinates);
        Report.update(fullID() + ": ");
        switch (curForcast) {
            case "Rain":
                Report.update("Rain got nothing on me\n");
                break;
            case "Fog":
                Report.update("Lets zip across this cloudy $%#@\n");
                break;
            case "Sun":
                Report.update("Ahhh its blinding...\n");
                break;
            case "Snow":
                Report.update("Oh snow.  How pretty.\n");
                break;
        }
        adjustCor(curForcast);
        if (this.coordinates.getHeight() == 0) {
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
            this.coordinates = new Coordinates(lon + 10, lat, h + 2);
        else if (curForcast == "Rain")
            this.coordinates = new Coordinates(lon, lat + 5, h);
        else if (curForcast == "Fog")
            this.coordinates = new Coordinates(lon, lat + 1, h);
        else if (curForcast == "Snow")
            this.coordinates = new Coordinates(lon, lat, h - 7);
    }
}