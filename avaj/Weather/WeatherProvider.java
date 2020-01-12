/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/01/07 18:43:52 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:53:28 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.weather;

import avaj.aircrafts.*;
import avaj.properties.Coordinates;

public class WeatherProvider {
    private static WeatherProvider wprovider;
    private String[] weather = {"Rain", "Fog", "Sun", "Snow"};

    private void WeatherProvider() {
        wprovider = this;
    }
    public static WeatherProvider getProvider() {
        if (wprovider == null)
            wprovider = new WeatherProvider();
        return wprovider;
    }
    public String getCurrentWeather(Coordinates cor) {
        int geoVector = cor.getLongitude() + cor.getLatitude() + cor.getHeight();
        int cur = geoVector % weather.length;
        return weather[cur];
    }

}


