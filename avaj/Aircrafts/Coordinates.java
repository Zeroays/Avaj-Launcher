/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 14:27:43 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:52:53 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = (height < 0) ? 0 : (height > 100) ? 100 : height;
    }
    public int getLongitude() {
        return (longitude);
    }
    public int getLatitude() {
        return (latitude);
    }
    public int getHeight() {
        return (height);
    }
}