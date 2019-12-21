/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 14:46:45 by vrabaib           #+#    #+#             */
/*   Updated: 2019/12/17 16:41:39 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class AircraftFactory {
    
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (negativeCoordinates(longitude, latitude, height))
            return (null);
        Coordinates location = Coordinates(longitude, latitude, height);
        switch (type) {
            case "Helicopter":
                return (new Helicopter(name, location));
            case "JetPlane":
                return (new JetPlane(name, location));
            case "Baloon":
                return (new Baloon(name, location));
            default:
                System.out.println("Aircraft Name is not Valid.  Try again...");
        }
    }
    private boolean negativeCoordinates(int longitude, int latitude, int height) {
        if (longitude < 0 || latitude < 0 || height < 0) {
            System.out.println("Coordinates are not positive numbers.");
            return (false);
        }
        return (true);
    }
    
}