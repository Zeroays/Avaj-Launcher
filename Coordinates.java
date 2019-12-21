/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 14:27:43 by vrabaib           #+#    #+#             */
/*   Updated: 2019/12/17 15:42:38 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    private Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
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