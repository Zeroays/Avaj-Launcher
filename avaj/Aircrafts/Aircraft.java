/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Aircraft.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: vrabaib <vrabaib@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/12/17 13:47:16 by vrabaib           #+#    #+#             */
/*   Updated: 2020/01/08 12:51:48 by vrabaib          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package avaj.aircrafts;
import avaj.properties.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
        this.type = this.getClass().getSimpleName();
    }

    protected String fullID() {
        return this.type + '#' + this.name + '(' + this.id + ')';
    }

    protected void landing() {
        System.out.println(fullID() + "landing.");
    }

    private long nextId() {
        return (this.idCounter += 1);
    }
}