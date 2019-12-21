/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Flyable.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 13:46:30 by vrabaib           #+#    #+#             */
/*   Updated: 2019/12/17 16:44:35 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}