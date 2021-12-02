package com.ghassan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    //This example illustrates the sets in Java
    //This example model the bodies in solar system which can be grouped to planets, moons, asteroids, comets
    //the moons are in another group which orbiting a particular planet
    // we use map to store the heavenly body objects then declare sets to declare the grouping into other types
    //We override equal and hashcode when we use HashMap or Hashset as recommended by Oracle
    //The reason of that is when using an object as a key in the hashMap or Hashset the equal method is not sufficient
    // , and since the hashCode method relies on the equal method ( 2 objects are equal if they must
    // have the same hashCode in a collection) we have to override it as well


    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        //Mercury plant
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(),temp);
        planets.add(temp);

        //Earth planet and its moon
        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon",27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        //Mars planet and its moons(Deimos,Phobos)
        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos",1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Phobos",1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        //Jupiter planet and its moons(Io,Europa, Ganymede, Callisto)
        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io",1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Europa",2.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Ganymede",7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Callisto",16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        //Saturn planet
        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Uranus planet
        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Neptune planet
        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Pluto planet
        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //Show planets
        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t"+planet.getName());
        }

        System.out.println("=====================================");
        //Show Jupiter moons
        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of Jupiter");
        for (HeavenlyBody satellite : body.getSatellites()) {
            System.out.println("\t"+satellite.getName());
        }


    }
}
