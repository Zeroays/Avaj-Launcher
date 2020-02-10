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

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates location = new Coordinates(longitude, latitude, height);
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
        return (null);
    }
}