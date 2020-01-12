/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 15:08:05 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:53:08 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.towers;

import avaj.aircrafts.Flyable;
import avaj.aircrafts.Aircraft;
import java.util.ArrayList;

public class Tower {
    private static ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        if (flyable == null)
            return ;
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        if (flyable == null)
            return ;
        observers.remove(flyable);
    }
    protected void conditionsChanged() {
        for (Flyable flyable : observers)
            flyable.updateConditions();
    }
}