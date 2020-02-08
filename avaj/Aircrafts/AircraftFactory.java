/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 14:46:45 by vrabaib           #+#    #+#             */
/*   Updated: 2020/02/07 13:36:45 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;

import avaj.properties.Coordinates;

public class AircraftFactory {
    
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (invalidHeight(longitude, latitude, height))
            return (null);
        Coordinates location = new Coordinates(longitude, latitude, height);
        // switch (type) {
        //     case "Helicopter":
        //         return (new Helicopter(name, location));
        //     case "JetPlane":
        //         return (new JetPlane(name, location));
        //     case "Baloon":
        //         return (new Baloon(name, location));
        //     default:
        //         System.out.println("Aircraft Name is not Valid.  Try again...");
        // }
        // Flyable v = new Helicopter(name, location);
        // if (type == "Helicopter")
        //     return new Helicopter(name, location);
        // if (type == "JetPlane")
        //     return new JetPlane(name, location);
        if (type == "Helicopter")
            return new Helicopter(name, location);
        if (type == "JetPlane")
            return new JetPlane(name, location);
        else if (type == "Baloon")
            return new Baloon(name, location);
        return (null);
    }
    private boolean invalidHeight(int longitude, int latitude, int height) {
        if (height < 0 || height > 100) {
            System.out.println("Height must be between 1 to 100.");
            return (false);
        }
        return (true);
    }
    
}