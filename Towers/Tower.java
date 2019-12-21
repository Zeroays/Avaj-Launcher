/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 15:08:05 by vrabaib           #+#    #+#             */
/*   Updated: 2019/12/17 16:16:57 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import Flyable;

import java.util.Formatter;
import java.util.ArrayList;

public class Tower {
    private static ArrayList<Flyable> observers = new ArrayList<>();
    
    public void register(Flyable flyable) {
        if (flyable != null)
            observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        Formatter formatter = new Formatter();
        formatter.format("Tower says: %s(%d) unregistered from weather tower.", flyable.name, flyable.id);
        System.out.println(formatter);
    }
    protected void conditionsChanged() {
        
    }
}