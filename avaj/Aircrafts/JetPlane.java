/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   JetPlane.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 15:00:51 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:52:37 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;

import avaj.properties.Coordinates;
import avaj.towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String curForcast = weatherTower.getWeather(this.coordinates);
        System.out.println(fullID() + ": ");
        switch (curForcast) {
            case "Rain":
                System.out.println("Rain huh... Eh.");
            case "Fog":
                System.out.println("Murky as s%^&");
            case "Sun":
                System.out.println("Oh finally, some sunshine");
            case "Snow":
                System.out.println("Motha Nature 'bout to frosty us up");
        }
        if (this.coordinates.getHeight() == 0) {
            landing();
            this.weatherTower.unregister(this);
            System.out.println("Tower says: " + fullID() + " unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.unregister(this);
        System.out.println("Tower says: " + fullID() + "registered to weather tower");
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