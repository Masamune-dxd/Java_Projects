package Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum ElementType {
    NORMAL, FIRE, WATER, GRASS, ELECTRIC, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, STEEL, DARK, FAIRY, CRYSTAL
}

abstract class Pokemon {
    protected String name;
    protected int pokedexNumber;
    protected String generation;
    protected ElementType primaryType;
    protected ElementType secondaryType;
    protected String description;

    public Pokemon(String name, int pokedexNumber, String generation, ElementType primaryType, ElementType secondaryType, String description) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.generation = generation;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.description = description;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Pokedex Number: " + pokedexNumber);
        System.out.println("Generation: " + generation);
        System.out.println("Primary Type: " + primaryType);
        if (secondaryType != null) {
            System.out.println("Secondary Type: " + secondaryType);
        }
        System.out.println("Description: " + description);
    }

    public String getName() {
        return name;
    }

    public ElementType getPrimaryType() {
        return primaryType;
    }

    public ElementType getSecondaryType() {
        return secondaryType;
    }

    public String getGeneration() {
        return generation;
    }
}

class StandardPokemon extends Pokemon {
    protected String evolutionStage;

    public StandardPokemon(String name, int pokedexNumber, String generation, ElementType primaryType, ElementType secondaryType, String description, String evolutionStage) {
        super(name, pokedexNumber, generation, primaryType, secondaryType, description);
        this.evolutionStage = evolutionStage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Evolution Stage: " + evolutionStage);
    }
}

class LegendaryPokemon extends Pokemon {
    protected String lore;

    public LegendaryPokemon(String name, int pokedexNumber, String generation, ElementType primaryType, ElementType secondaryType, String description, String lore) {
        super(name, pokedexNumber, generation, primaryType, secondaryType, description);
        this.lore = lore;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Lore: " + lore);
    }
}

class CrystalPokemon extends Pokemon {
    protected String crystalAbility;

    public CrystalPokemon(String name, int pokedexNumber, String generation, ElementType primaryType, ElementType secondaryType, String description, String crystalAbility) {
        super(name, pokedexNumber, generation, primaryType, secondaryType, description);
        this.crystalAbility = crystalAbility;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Crystal Ability: " + crystalAbility);
    }
}

class Pokedex {
    private Map<String, Pokemon> pokemonArchive;

    public Pokedex() {
        pokemonArchive = new HashMap<>();
        initializePokedex();
    }

    private void initializePokedex() {
        pokemonArchive.put("Bulbasaur", new StandardPokemon("Bulbasaur", 1, "Generation I", ElementType.GRASS, ElementType.POISON, "A seed is planted on its back at birth and grows. The plant sprouts and grows larger as it does.", "Basic"));
        pokemonArchive.put("Charmander", new StandardPokemon("Charmander", 4, "Generation I", ElementType.FIRE, null, "The flame on its tail indicates Charmander's life force. If it is healthy, the flame burns brightly.", "Basic"));
        pokemonArchive.put("Squirtle", new StandardPokemon("Squirtle", 7, "Generation I", ElementType.WATER, null, "When it retracts its long neck into its shell, it unleashes a powerful spray of water.", "Basic"));
        pokemonArchive.put("Pikachu", new StandardPokemon("Pikachu", 25, "Generation I", ElementType.ELECTRIC, null, "Pikachu that can generate powerful electricity have cheek sacs that are soft and super stretchy.", "Basic"));
        pokemonArchive.put("Mewtwo", new LegendaryPokemon("Mewtwo", 150, "Generation I", ElementType.PSYCHIC, null, "A Pokémon whose genetic code was repeatedly recombined for research. It is a Pokémon created by scientific manipulation.", "Created by science to be the ultimate Pokémon."));

        // Note: Lugia and Ho-Oh are Generation II, keeping them for context as per your original request
        pokemonArchive.put("Lugia", new LegendaryPokemon("Lugia", 249, "Generation II", ElementType.PSYCHIC, ElementType.FLYING, "Lugia is said to be the guardian of the seas. It is rumored to have the power to quell raging storms.", "Known as the Guardian of the Seas."));
        pokemonArchive.put("Ho-Oh", new LegendaryPokemon("Ho-Oh", 250, "Generation II", ElementType.FIRE, ElementType.FLYING, "Ho-Oh's feathers are said to glow in seven colors. It is rumored to bring happiness to those who see it.", "Brings happiness to those who see its magnificent wings."));
        pokemonArchive.put("Jolteon-Crystal", new CrystalPokemon("Jolteon-Crystal", 135, "Generation I", ElementType.ELECTRIC, ElementType.CRYSTAL, "A special Jolteon variant, powered by an inner crystal, allowing it to manipulate crystallized electricity.", "Can crystallize electricity for enhanced attacks."));
        pokemonArchive.put("Charizard", new StandardPokemon("Charizard", 6, "Generation I", ElementType.FIRE, ElementType.FLYING, "Charizard flies around the sky in search of powerful opponents. It breathes fire of such great heat that it melts anything.", "Final Evolution"));
        pokemonArchive.put("Venusaur", new StandardPokemon("Venusaur", 3, "Generation I", ElementType.GRASS, ElementType.POISON, "A plant blooms on its back. The plant absorbs sunlight and converts it into energy.", "Final Evolution"));

        // Adding all Generation 1 Pokémon (from #001 to #151)
        pokemonArchive.put("Ivysaur", new StandardPokemon("Ivysaur", 2, "Generation I", ElementType.GRASS, ElementType.POISON, "When the bulb on its back grows large, it appears to lose the ability to stand on its hind legs.", "Stage 1"));
        pokemonArchive.put("Charmeleon", new StandardPokemon("Charmeleon", 5, "Generation I", ElementType.FIRE, null, "It has a violent nature. In a battle, it will mercilessly slice up foes with its sharp claws.", "Stage 1"));
        pokemonArchive.put("Wartortle", new StandardPokemon("Wartortle", 8, "Generation I", ElementType.WATER, null, "It is recognized by its long, furry tail. It stores air in its tail to dive underwater for extended periods.", "Stage 1"));
        pokemonArchive.put("Blastoise", new StandardPokemon("Blastoise", 9, "Generation I", ElementType.WATER, null, "It crushes its foe under its heavy body to cause fainting. In a pinch, it will withdraw into its shell.", "Stage 2"));
        pokemonArchive.put("Caterpie", new StandardPokemon("Caterpie", 10, "Generation I", ElementType.BUG, null, "It releases a terribly strong odor from its antennae if it or its nest is disturbed.", "Basic"));
        pokemonArchive.put("Metapod", new StandardPokemon("Metapod", 11, "Generation I", ElementType.BUG, null, "It is vulnerable to attack while its shell is soft, exposing its weak, tender body.", "Stage 1"));
        pokemonArchive.put("Butterfree", new StandardPokemon("Butterfree", 12, "Generation I", ElementType.BUG, ElementType.FLYING, "It loves to eat the nectar of flowers and will even steal it from other Pokémon.", "Stage 2"));
        pokemonArchive.put("Weedle", new StandardPokemon("Weedle", 13, "Generation I", ElementType.BUG, ElementType.POISON, "Often found in forests and grasslands. It has a sharp, 2-inch stinger on its head.", "Basic"));
        pokemonArchive.put("Kakuna", new StandardPokemon("Kakuna", 14, "Generation I", ElementType.BUG, ElementType.POISON, "Able to move only slightly. When endangered, it may stick out its stinger and poison its foe.", "Stage 1"));
        pokemonArchive.put("Beedrill", new StandardPokemon("Beedrill", 15, "Generation I", ElementType.BUG, ElementType.POISON, "It has three stingers: one on its tail and one on each of its two forelegs. They are used to jab foes repeatedly.", "Stage 2"));
        pokemonArchive.put("Pidgey", new StandardPokemon("Pidgey", 16, "Generation I", ElementType.NORMAL, ElementType.FLYING, "A common sight in forests and woods. It will flap its wings to kick up sand.", "Basic"));
        pokemonArchive.put("Pidgeotto", new StandardPokemon("Pidgeotto", 17, "Generation I", ElementType.NORMAL, ElementType.FLYING, "This Pokémon is an extremely aggressive and territorial bird. It will fearlessly attack any intruder, no matter how large it is.", "Stage 1"));
        pokemonArchive.put("Pidgeot", new StandardPokemon("Pidgeot", 18, "Generation I", ElementType.NORMAL, ElementType.FLYING, "This Pokémon flies at Mach 2 speed, searching for prey. Its large wings are also used to create powerful gusts of wind.", "Stage 2"));
        pokemonArchive.put("Rattata", new StandardPokemon("Rattata", 19, "Generation I", ElementType.NORMAL, null, "Will chew on anything with its fangs. If you see one, you can be sure that 40 more live in the area.", "Basic"));
        pokemonArchive.put("Raticate", new StandardPokemon("Raticate", 20, "Generation I", ElementType.NORMAL, null, "It uses its long tail to maintain balance and can also use it to trip foes.", "Stage 1"));
        pokemonArchive.put("Spearow", new StandardPokemon("Spearow", 21, "Generation I", ElementType.NORMAL, ElementType.FLYING, "It's very protective of its territory, so it will attack anyone who enters it.", "Basic"));
        pokemonArchive.put("Fearow", new StandardPokemon("Fearow", 22, "Generation I", ElementType.NORMAL, ElementType.FLYING, "A Pokémon that makes its nest on high mountains. It's a very fast flier.", "Stage 1"));
        pokemonArchive.put("Ekans", new StandardPokemon("Ekans", 23, "Generation I", ElementType.POISON, null, "It slithers through the grass, silently closing in on its prey. It can flatten its body to slip through small cracks.", "Basic"));
        pokemonArchive.put("Arbok", new StandardPokemon("Arbok", 24, "Generation I", ElementType.POISON, null, "The patterns on its belly are said to have been studied by ancient scholars. There are six variations.", "Stage 1"));
        pokemonArchive.put("Raichu", new StandardPokemon("Raichu", 26, "Generation I", ElementType.ELECTRIC, null, "Its tail is used to gather electricity from the atmosphere. It also uses its tail to stand upright.", "Stage 1"));
        pokemonArchive.put("Sandshrew", new StandardPokemon("Sandshrew", 27, "Generation I", ElementType.GROUND, null, "It digs and sleeps in the ground. It can curl into a ball for protection.", "Basic"));
        pokemonArchive.put("Sandslash", new StandardPokemon("Sandslash", 28, "Generation I", ElementType.GROUND, null, "It can roll itself up into a ball of spikes and attack its enemies that way.", "Stage 1"));
        pokemonArchive.put("Nidoran♀", new StandardPokemon("Nidoran♀", 29, "Generation I", ElementType.POISON, null, "Although small, its poison barbs are potent enough to make prey unable to move.", "Basic"));
        pokemonArchive.put("Nidorina", new StandardPokemon("Nidorina", 30, "Generation I", ElementType.POISON, null, "The horn on its head contains venom. It is very timid, so it does not like to fight.", "Stage 1"));
        pokemonArchive.put("Nidoqueen", new StandardPokemon("Nidoqueen", 31, "Generation I", ElementType.POISON, ElementType.GROUND, "Its hardened hide provides excellent protection from any attack. It uses its body to shield its young.", "Stage 2"));
        pokemonArchive.put("Nidoran♂", new StandardPokemon("Nidoran♂", 32, "Generation I", ElementType.POISON, null, "The male Nidoran has a more developed horn than the female. It is more aggressive.", "Basic"));
        pokemonArchive.put("Nidorino", new StandardPokemon("Nidorino", 33, "Generation I", ElementType.POISON, null, "It is very aggressive and will use its horn to attack anyone who dares to challenge it.", "Stage 1"));
        pokemonArchive.put("Nidoking", new StandardPokemon("Nidoking", 34, "Generation I", ElementType.POISON, ElementType.GROUND, "Its thick tail is able to smash a telephone pole. Its horn is powerful enough to pierce diamond.", "Stage 2"));
        pokemonArchive.put("Clefairy", new StandardPokemon("Clefairy", 35, "Generation I", ElementType.FAIRY, null, "Its adorable appearance makes it a favorite among trainers. It is said to be a rare Pokémon.", "Basic"));
        pokemonArchive.put("Clefable", new StandardPokemon("Clefable", 36, "Generation I", ElementType.FAIRY, null, "It is said to live in quiet, remote mountains. It can fly using its small wings.", "Stage 1"));
        pokemonArchive.put("Vulpix", new StandardPokemon("Vulpix", 37, "Generation I", ElementType.FIRE, null, "When it is born, it has a single white tail. The tail splits into six as it ages.", "Basic"));
        pokemonArchive.put("Ninetales", new StandardPokemon("Ninetales", 38, "Generation I", ElementType.FIRE, null, "It is said to live for a thousand years. Its nine tails are imbued with mystical powers.", "Stage 1"));
        pokemonArchive.put("Jigglypuff", new StandardPokemon("Jigglypuff", 39, "Generation I", ElementType.NORMAL, ElementType.FAIRY, "When its huge eyes waver, it sings a relaxing melody that makes anyone who hears it fall asleep.", "Basic"));
        pokemonArchive.put("Wigglytuff", new StandardPokemon("Wigglytuff", 40, "Generation I", ElementType.NORMAL, ElementType.FAIRY, "Its body is so soft and rubbery that it can stretch to enormous lengths.", "Stage 1"));
        pokemonArchive.put("Zubat", new StandardPokemon("Zubat", 41, "Generation I", ElementType.POISON, ElementType.FLYING, "It navigates using ultrasonic waves. It can fly in total darkness.", "Basic"));
        pokemonArchive.put("Golbat", new StandardPokemon("Golbat", 42, "Generation I", ElementType.POISON, ElementType.FLYING, "It loves to drink the blood of living things. It can drink over 10 ounces of blood in one go.", "Stage 1"));
        pokemonArchive.put("Oddish", new StandardPokemon("Oddish", 43, "Generation I", ElementType.GRASS, ElementType.POISON, "During the day, it keeps its face buried in the ground. At night, it wanders about, spreading its seeds.", "Basic"));
        pokemonArchive.put("Gloom", new StandardPokemon("Gloom", 44, "Generation I", ElementType.GRASS, ElementType.POISON, "The nectar it secretes smells so horrible that it can make people pass out. It is a favorite of Grimer.", "Stage 1"));
        pokemonArchive.put("Vileplume", new StandardPokemon("Vileplume", 45, "Generation I", ElementType.GRASS, ElementType.POISON, "Its petals are the largest in the world. It uses its pollen to hypnotize foes.", "Stage 2"));
        pokemonArchive.put("Paras", new StandardPokemon("Paras", 46, "Generation I", ElementType.BUG, ElementType.GRASS, "A host-parasite pair in which the insect is the host and the mushrooms are the parasite.", "Basic"));
        pokemonArchive.put("Parasect", new StandardPokemon("Parasect", 47, "Generation I", ElementType.BUG, ElementType.GRASS, "The bug is controlled by the mushrooms that grow on its back. The mushrooms are the real brain.", "Stage 1"));
        pokemonArchive.put("Venonat", new StandardPokemon("Venonat", 48, "Generation I", ElementType.BUG, ElementType.POISON, "Its large eyes allow it to see in the dark. It is attracted to light.", "Basic"));
        pokemonArchive.put("Venomoth", new StandardPokemon("Venomoth", 49, "Generation I", ElementType.BUG, ElementType.POISON, "It scatters powder to induce sleep. It lives in dark forests.", "Stage 1"));
        pokemonArchive.put("Diglett", new StandardPokemon("Diglett", 50, "Generation I", ElementType.GROUND, null, "It lives about one yard underground. It can dig through any soil, even rock.", "Basic"));
        pokemonArchive.put("Dugtrio", new StandardPokemon("Dugtrio", 51, "Generation I", ElementType.GROUND, null, "A team of Diglett that are able to dig through even the hardest ground. They can reach 60 mph.", "Stage 1"));
        pokemonArchive.put("Meowth", new StandardPokemon("Meowth", 52, "Generation I", ElementType.NORMAL, null, "It loves to collect shiny things. It can be found rummaging through garbage for coins.", "Basic"));
        pokemonArchive.put("Persian", new StandardPokemon("Persian", 53, "Generation I", ElementType.NORMAL, null, "Its elegant movements are the result of its perfectly developed muscles. It has a high opinion of itself.", "Stage 1"));
        pokemonArchive.put("Psyduck", new StandardPokemon("Psyduck", 54, "Generation I", ElementType.WATER, null, "It is constantly plagued by a headache. It uses its psychic powers when its headache gets too bad.", "Basic"));
        pokemonArchive.put("Golduck", new StandardPokemon("Golduck", 55, "Generation I", ElementType.WATER, null, "When it swims at top speed, its webbed hands and feet glow, and it can move at speeds approaching a torpedo.", "Stage 1"));
        pokemonArchive.put("Mankey", new StandardPokemon("Mankey", 56, "Generation I", ElementType.FIGHTING, null, "When it becomes enraged, it will attack without thinking. It is very dangerous.", "Basic"));
        pokemonArchive.put("Primeape", new StandardPokemon("Primeape", 57, "Generation I", ElementType.FIGHTING, null, "It becomes more powerful the angrier it gets. It can even become enraged to the point of losing consciousness.", "Stage 1"));
        pokemonArchive.put("Growlithe", new StandardPokemon("Growlithe", 58, "Generation I", ElementType.FIRE, null, "It is very loyal to its trainer. It will bark loudly to warn of danger.", "Basic"));
        pokemonArchive.put("Arcanine", new StandardPokemon("Arcanine", 59, "Generation I", ElementType.FIRE, null, "It is revered for its majestic beauty. It is said to be able to run 6,200 miles in a single day.", "Stage 1"));
        pokemonArchive.put("Poliwag", new StandardPokemon("Poliwag", 60, "Generation I", ElementType.WATER, null, "Its skin is so thin, its internal organs can be seen. It swims by swirling its tail.", "Basic"));
        pokemonArchive.put("Poliwhirl", new StandardPokemon("Poliwhirl", 61, "Generation I", ElementType.WATER, null, "Its body is covered in a slick, slimy liquid that makes it hard to grab. It can walk on land.", "Stage 1"));
        pokemonArchive.put("Poliwrath", new StandardPokemon("Poliwrath", 62, "Generation I", ElementType.WATER, ElementType.FIGHTING, "Its muscles are so strong it can swim through rivers against the strongest currents. It can also punch with great force.", "Stage 2"));
        pokemonArchive.put("Abra", new StandardPokemon("Abra", 63, "Generation I", ElementType.PSYCHIC, null, "It sleeps for 18 hours a day. If it is awakened, it will teleport away.", "Basic"));
        pokemonArchive.put("Kadabra", new StandardPokemon("Kadabra", 64, "Generation I", ElementType.PSYCHIC, null, "It emits alpha waves that induce headaches. It is said that only a strong-willed person can train it.", "Stage 1"));
        pokemonArchive.put("Alakazam", new StandardPokemon("Alakazam", 65, "Generation I", ElementType.PSYCHIC, null, "Its brain can outperform a supercomputer. It remembers everything it has experienced.", "Stage 2"));
        pokemonArchive.put("Machop", new StandardPokemon("Machop", 66, "Generation I", ElementType.FIGHTING, null, "It trains by lifting boulders. It is very strong for its size.", "Basic"));
        pokemonArchive.put("Machoke", new StandardPokemon("Machoke", 67, "Generation I", ElementType.FIGHTING, null, "Its powerful muscles can lift 25 times its own weight. It has to wear a power-save belt to keep its strength in check.", "Stage 1"));
        pokemonArchive.put("Machamp", new StandardPokemon("Machamp", 68, "Generation I", ElementType.FIGHTING, null, "It can throw 1,000 punches in two seconds. It is a master of all martial arts.", "Stage 2"));
        pokemonArchive.put("Bellsprout", new StandardPokemon("Bellsprout", 69, "Generation I", ElementType.GRASS, ElementType.POISON, "Its thin, flexible body allows it to bend and sway to avoid attacks. It shoots out a liquid from its mouth.", "Basic"));
        pokemonArchive.put("Weepinbell", new StandardPokemon("Weepinbell", 70, "Generation I", ElementType.GRASS, ElementType.POISON, "It eats insects and uses its acidic liquid to dissolve them.", "Stage 1"));
        pokemonArchive.put("Victreebel", new StandardPokemon("Victreebel", 71, "Generation I", ElementType.GRASS, ElementType.POISON, "It has a large mouth that is always open, ready to swallow prey whole. It attracts prey with its sweet-smelling nectar.", "Stage 2"));
        pokemonArchive.put("Tentacool", new StandardPokemon("Tentacool", 72, "Generation I", ElementType.WATER, ElementType.POISON, "It drifts through the water. It uses its two large tentacles to inject poison into its prey.", "Basic"));
        pokemonArchive.put("Tentacruel", new StandardPokemon("Tentacruel", 73, "Generation I", ElementType.WATER, ElementType.POISON, "It has 80 tentacles that can be extended freely. It is a formidable hunter.", "Stage 1"));
        pokemonArchive.put("Geodude", new StandardPokemon("Geodude", 74, "Generation I", ElementType.ROCK, ElementType.GROUND, "It is often found in mountains and caves. It can float in the air.", "Basic"));
        pokemonArchive.put("Graveler", new StandardPokemon("Graveler", 75, "Generation I", ElementType.ROCK, ElementType.GROUND, "It climbs mountains using its four arms. It is said to have been born from a rock.", "Stage 1"));
        pokemonArchive.put("Golem", new StandardPokemon("Golem", 76, "Generation I", ElementType.ROCK, ElementType.GROUND, "It can roll itself up into a ball and roll down mountains at high speed.", "Stage 2"));
        pokemonArchive.put("Ponyta", new StandardPokemon("Ponyta", 77, "Generation I", ElementType.FIRE, null, "Its mane and tail are made of fire. It can run at very high speeds.", "Basic"));
        pokemonArchive.put("Rapidash", new StandardPokemon("Rapidash", 78, "Generation I", ElementType.FIRE, null, "It can run at 150 miles per hour. It is very proud of its speed.", "Stage 1"));
        pokemonArchive.put("Slowpoke", new StandardPokemon("Slowpoke", 79, "Generation I", ElementType.WATER, ElementType.PSYCHIC, "It is a very slow Pokémon. It takes 5 seconds for its brain to process what is happening.", "Basic"));
        pokemonArchive.put("Slowbro", new StandardPokemon("Slowbro", 80, "Generation I", ElementType.WATER, ElementType.PSYCHIC, "A Shellder has latched onto its tail, and the two have merged. It can use its tail to attack.", "Stage 1"));
        pokemonArchive.put("Magnemite", new StandardPokemon("Magnemite", 81, "Generation I", ElementType.ELECTRIC, ElementType.STEEL, "It has two magnets on its sides that generate a strong magnetic field. It is often found near power plants.", "Basic"));
        pokemonArchive.put("Magneton", new StandardPokemon("Magneton", 82, "Generation I", ElementType.ELECTRIC, ElementType.STEEL, "Three Magnemite are linked together by a strong magnetic force. It can generate strong electromagnetic waves.", "Stage 1"));
        pokemonArchive.put("Farfetch'd", new StandardPokemon("Farfetch'd", 83, "Generation I", ElementType.NORMAL, ElementType.FLYING, "It uses a leek as its weapon. It is very rare and is often hunted for its delicious meat.", "Basic"));
        pokemonArchive.put("Doduo", new StandardPokemon("Doduo", 84, "Generation I", ElementType.NORMAL, ElementType.FLYING, "It has two heads, each with its own brain. They sometimes fight over what direction to go.", "Basic"));
        pokemonArchive.put("Dodrio", new StandardPokemon("Dodrio", 85, "Generation I", ElementType.NORMAL, ElementType.FLYING, "It has three heads, each capable of thinking independently. It can run at 60 miles per hour.", "Stage 1"));
        pokemonArchive.put("Seel", new StandardPokemon("Seel", 86, "Generation I", ElementType.WATER, null, "It can endure cold by coating its body with a thick layer of fat. It loves to swim in icy waters.", "Basic"));
        pokemonArchive.put("Dewgong", new StandardPokemon("Dewgong", 87, "Generation I", ElementType.WATER, ElementType.ICE, "Its body is covered in a thick layer of fat that protects it from the cold. It can swim through icy waters at 8 knots.", "Stage 1"));
        pokemonArchive.put("Grimer", new StandardPokemon("Grimer", 88, "Generation I", ElementType.POISON, null, "It was born from sludge that was exposed to X-rays. It lives in filthy places.", "Basic"));
        pokemonArchive.put("Muk", new StandardPokemon("Muk", 89, "Generation I", ElementType.POISON, null, "It emits a foul odor that can make people faint. It is said to have been born from a chemical spill.", "Stage 1"));
        pokemonArchive.put("Shellder", new StandardPokemon("Shellder", 90, "Generation I", ElementType.WATER, null, "Its shell is harder than diamond. It lives at the bottom of the ocean.", "Basic"));
        pokemonArchive.put("Cloyster", new StandardPokemon("Cloyster", 91, "Generation I", ElementType.WATER, ElementType.ICE, "Its shell is so hard that it can withstand a bomb blast. It launches its spikes at foes.", "Stage 1"));
        pokemonArchive.put("Gastly", new StandardPokemon("Gastly", 92, "Generation I", ElementType.GHOST, ElementType.POISON, "It is made of gas. It can float through walls and objects.", "Basic"));
        pokemonArchive.put("Haunter", new StandardPokemon("Haunter", 93, "Generation I", ElementType.GHOST, ElementType.POISON, "It loves to play pranks on people. It can lick its victims to steal their life force.", "Stage 1"));
        pokemonArchive.put("Gengar", new StandardPokemon("Gengar", 94, "Generation I", ElementType.GHOST, ElementType.POISON, "It hides in the shadows and preys on people's fear. It is said to steal the souls of those who get lost in the mountains.", "Stage 2"));
        pokemonArchive.put("Onix", new StandardPokemon("Onix", 95, "Generation I", ElementType.ROCK, ElementType.GROUND, "It burrows through the earth at high speeds. It is said to live for hundreds of years.", "Basic"));
        pokemonArchive.put("Drowzee", new StandardPokemon("Drowzee", 96, "Generation I", ElementType.PSYCHIC, null, "It can put people to sleep by eating their dreams. It remembers all the dreams it has eaten.", "Basic"));
        pokemonArchive.put("Hypno", new StandardPokemon("Hypno", 97, "Generation I", ElementType.PSYCHIC, null, "It uses its pendulum to hypnotize foes. It is said to have stolen children in the past.", "Stage 1"));
        pokemonArchive.put("Krabby", new StandardPokemon("Krabby", 98, "Generation I", ElementType.WATER, null, "Its hard shell protects it from attacks. It can pinch with great force.", "Basic"));
        pokemonArchive.put("Kingler", new StandardPokemon("Kingler", 99, "Generation I", ElementType.WATER, null, "Its large claw can deliver a powerful blow. It is said to be able to crush concrete.", "Stage 1"));
        pokemonArchive.put("Voltorb", new StandardPokemon("Voltorb", 100, "Generation I", ElementType.ELECTRIC, null, "It looks exactly like a Poké Ball. It can explode without warning.", "Basic"));
        pokemonArchive.put("Electrode", new StandardPokemon("Electrode", 101, "Generation I", ElementType.ELECTRIC, null, "It can store a lot of electricity in its body. It can explode with great force.", "Stage 1"));
        pokemonArchive.put("Exeggcute", new StandardPokemon("Exeggcute", 102, "Generation I", ElementType.GRASS, ElementType.PSYCHIC, "A cluster of six eggs. They communicate with each other telepathically.", "Basic"));
        pokemonArchive.put("Exeggutor", new StandardPokemon("Exeggutor", 103, "Generation I", ElementType.GRASS, ElementType.PSYCHIC, "Its three heads think independently. It can use its psychic powers to control its environment.", "Stage 1"));
        pokemonArchive.put("Cubone", new StandardPokemon("Cubone", 104, "Generation I", ElementType.GROUND, null, "It wears the skull of its deceased mother on its head. It cries when it misses its mother.", "Basic"));
        pokemonArchive.put("Marowak", new StandardPokemon("Marowak", 105, "Generation I", ElementType.GROUND, null, "It uses a bone as a weapon. It is said to have been trained by its mother.", "Stage 1"));
        pokemonArchive.put("Hitmonlee", new StandardPokemon("Hitmonlee", 106, "Generation I", ElementType.FIGHTING, null, "Its legs are like springs. It can kick with great force and reach.", "Basic"));
        pokemonArchive.put("Hitmonchan", new StandardPokemon("Hitmonchan", 107, "Generation I", ElementType.FIGHTING, null, "It trains its fists by punching the air. It can punch at incredible speeds.", "Basic"));
        pokemonArchive.put("Lickitung", new StandardPokemon("Lickitung", 108, "Generation I", ElementType.NORMAL, null, "Its tongue is twice as long as its body. It can use its tongue to grab anything.", "Basic"));
        pokemonArchive.put("Koffing", new StandardPokemon("Koffing", 109, "Generation I", ElementType.POISON, null, "It is filled with toxic gas. It can float in the air.", "Basic"));
        pokemonArchive.put("Weezing", new StandardPokemon("Weezing", 110, "Generation I", ElementType.POISON, null, "It is made of two Koffing joined together. It emits an even more potent toxic gas.", "Stage 1"));
        pokemonArchive.put("Rhyhorn", new StandardPokemon("Rhyhorn", 111, "Generation I", ElementType.GROUND, ElementType.ROCK, "Its horn can smash through solid rock. It is very stubborn.", "Basic"));
        pokemonArchive.put("Rhydon", new StandardPokemon("Rhydon", 112, "Generation I", ElementType.GROUND, ElementType.ROCK, "Its horn is capable of piercing diamonds. It can learn to walk on its hind legs.", "Stage 1"));
        pokemonArchive.put("Chansey", new StandardPokemon("Chansey", 113, "Generation I", ElementType.NORMAL, null, "It lays highly nutritious eggs every day. It is very kind-hearted.", "Basic"));
        pokemonArchive.put("Tangela", new StandardPokemon("Tangela", 114, "Generation I", ElementType.GRASS, null, "Its body is covered in blue vines. It can move its vines freely to grab things.", "Basic"));
        pokemonArchive.put("Kangaskhan", new StandardPokemon("Kangaskhan", 115, "Generation I", ElementType.NORMAL, null, "It carries its baby in a pouch on its belly. It is very protective of its young.", "Basic"));
        pokemonArchive.put("Horsea", new StandardPokemon("Horsea", 116, "Generation I", ElementType.WATER, null, "It uses its tail to anchor itself to coral. It can squirt ink from its mouth.", "Basic"));
        pokemonArchive.put("Seadra", new StandardPokemon("Seadra", 117, "Generation I", ElementType.WATER, null, "Its scales are very sharp. It can swim at great speeds.", "Stage 1"));
        pokemonArchive.put("Goldeen", new StandardPokemon("Goldeen", 118, "Generation I", ElementType.WATER, null, "Its horn is very sharp. It can swim against currents.", "Basic"));
        pokemonArchive.put("Seaking", new StandardPokemon("Seaking", 119, "Generation I", ElementType.WATER, null, "It can drill holes in rocks with its horn. It is very territorial.", "Stage 1"));
        pokemonArchive.put("Staryu", new StandardPokemon("Staryu", 120, "Generation I", ElementType.WATER, null, "Its core glows like a jewel. It regenerates any lost limbs.", "Basic"));
        pokemonArchive.put("Starmie", new StandardPokemon("Starmie", 121, "Generation I", ElementType.WATER, ElementType.PSYCHIC, "Its core sparkles in seven colors. It can communicate with aliens.", "Stage 1"));
        pokemonArchive.put("Mr. Mime", new StandardPokemon("Mr. Mime", 122, "Generation I", ElementType.PSYCHIC, ElementType.FAIRY, "It is a master of pantomime. It can create invisible walls.", "Basic"));
        pokemonArchive.put("Scyther", new StandardPokemon("Scyther", 123, "Generation I", ElementType.BUG, ElementType.FLYING, "Its sharp scythes can cut through anything. It moves very fast.", "Basic"));
        pokemonArchive.put("Jynx", new StandardPokemon("Jynx", 124, "Generation I", ElementType.ICE, ElementType.PSYCHIC, "It can dance rhythmically to put foes to sleep. It is often mistaken for a human.", "Basic"));
        pokemonArchive.put("Electabuzz", new StandardPokemon("Electabuzz", 125, "Generation I", ElementType.ELECTRIC, null, "It generates electricity by rotating its arms. It is often found near power plants.", "Basic"));
        pokemonArchive.put("Magmar", new StandardPokemon("Magmar", 126, "Generation I", ElementType.FIRE, null, "It lives in volcanoes. It can breathe fire that melts anything.", "Basic"));
        pokemonArchive.put("Pinsir", new StandardPokemon("Pinsir", 127, "Generation I", ElementType.BUG, null, "Its large pincers can crush anything. It is very aggressive.", "Basic"));
        pokemonArchive.put("Tauros", new StandardPokemon("Tauros", 128, "Generation I", ElementType.NORMAL, null, "It charges at foes at full speed. It has three tails.", "Basic"));
        pokemonArchive.put("Magikarp", new StandardPokemon("Magikarp", 129, "Generation I", ElementType.WATER, null, "It is a very weak Pokémon. It can only splash around.", "Basic"));
        pokemonArchive.put("Gyarados", new StandardPokemon("Gyarados", 130, "Generation I", ElementType.WATER, ElementType.FLYING, "Once it begins to rampage, it will not stop until everything is destroyed. It is very destructive.", "Stage 1"));
        pokemonArchive.put("Lapras", new StandardPokemon("Lapras", 131, "Generation I", ElementType.WATER, ElementType.ICE, "It loves to ferry people across the sea. It is a very gentle Pokémon.", "Basic"));
        pokemonArchive.put("Ditto", new StandardPokemon("Ditto", 132, "Generation I", ElementType.NORMAL, null, "It can transform into anything. It can even mimic the moves of other Pokémon.", "Basic"));
        pokemonArchive.put("Eevee", new StandardPokemon("Eevee", 133, "Generation I", ElementType.NORMAL, null, "It has an unstable genetic makeup that allows it to evolve into many different forms.", "Basic"));
        pokemonArchive.put("Vaporeon", new StandardPokemon("Vaporeon", 134, "Generation I", ElementType.WATER, null, "Its cells are similar to water molecules, allowing it to melt into water. It can control water.", "Stage 1"));
        pokemonArchive.put("Jolteon", new StandardPokemon("Jolteon", 135, "Generation I", ElementType.ELECTRIC, null, "Its fur stands on end when it is angry. It can shoot electric jolts.", "Stage 1"));
        pokemonArchive.put("Flareon", new StandardPokemon("Flareon", 136, "Generation I", ElementType.FIRE, null, "It stores fire in its body. It can breathe fire that is 3,000 degrees Fahrenheit.", "Stage 1"));
        pokemonArchive.put("Porygon", new StandardPokemon("Porygon", 137, "Generation I", ElementType.NORMAL, null, "It is a Pokémon made entirely of programming code. It can freely move in cyberspace.", "Basic"));
        pokemonArchive.put("Omanyte", new StandardPokemon("Omanyte", 138, "Generation I", ElementType.ROCK, ElementType.WATER, "A Pokémon that was resurrected from a fossil. It uses its tentacles to catch prey.", "Basic"));
        pokemonArchive.put("Omastar", new StandardPokemon("Omastar", 139, "Generation I", ElementType.ROCK, ElementType.WATER, "Its shell is very hard. It can use its tentacles to crush prey.", "Stage 1"));
        pokemonArchive.put("Kabuto", new StandardPokemon("Kabuto", 140, "Generation I", ElementType.ROCK, ElementType.WATER, "A Pokémon that was resurrected from a fossil. It lives on the seafloor.", "Basic"));
        pokemonArchive.put("Kabutops", new StandardPokemon("Kabutops", 141, "Generation I", ElementType.ROCK, ElementType.WATER, "It can swim at incredible speeds. It uses its sharp claws to slash prey.", "Stage 1"));
        pokemonArchive.put("Aerodactyl", new StandardPokemon("Aerodactyl", 142, "Generation I", ElementType.ROCK, ElementType.FLYING, "A Pokémon that was resurrected from a fossil. It flew in ancient skies.", "Basic"));
        pokemonArchive.put("Snorlax", new StandardPokemon("Snorlax", 143, "Generation I", ElementType.NORMAL, null, "It eats 900 pounds of food a day. It is so lazy that it only wakes up to eat.", "Basic"));
        pokemonArchive.put("Articuno", new LegendaryPokemon("Articuno", 144, "Generation I", ElementType.ICE, ElementType.FLYING, "A legendary bird Pokémon that is said to appear to doomed people who are lost in icy mountains.", "One of the legendary birds of Kanto."));
        pokemonArchive.put("Zapdos", new LegendaryPokemon("Zapdos", 145, "Generation I", ElementType.ELECTRIC, ElementType.FLYING, "A legendary bird Pokémon that is said to live in thunderclouds. It is said to appear to people who are lost in storms.", "One of the legendary birds of Kanto."));
        pokemonArchive.put("Moltres", new LegendaryPokemon("Moltres", 146, "Generation I", ElementType.FIRE, ElementType.FLYING, "A legendary bird Pokémon that is said to appear to doomed people who are lost in fiery mountains.", "One of the legendary birds of Kanto."));
        pokemonArchive.put("Dratini", new StandardPokemon("Dratini", 147, "Generation I", ElementType.DRAGON, null, "It sheds its skin at regular intervals. It is said to be a mythical Pokémon.", "Basic"));
        pokemonArchive.put("Dragonair", new StandardPokemon("Dragonair", 148, "Generation I", ElementType.DRAGON, null, "It is said to live in clear lakes. It can control the weather.", "Stage 1"));
        pokemonArchive.put("Dragonite", new StandardPokemon("Dragonite", 149, "Generation I", ElementType.DRAGON, ElementType.FLYING, "It is said to be able to circle the globe in 16 hours. It is a kind-hearted Pokémon.", "Stage 2"));
        pokemonArchive.put("Mew", new LegendaryPokemon("Mew", 151, "Generation I", ElementType.PSYCHIC, null, "A mythical Pokémon that is said to contain the genetic code of all Pokémon. It is very shy.", "The ancestor of all Pokémon."));
    }

    public Pokemon searchPokemon(String name) {
        return pokemonArchive.get(name);
    }

    public List<Pokemon> searchByElement(ElementType type) {
        List<Pokemon> results = new ArrayList<>();
        for (Pokemon p : pokemonArchive.values()) {
            if (p.getPrimaryType() == type || p.getSecondaryType() == type) {
                results.add(p);
            }
        }
        return results;
    }

    public List<Pokemon> searchByGeneration(String generation) {
        List<Pokemon> results = new ArrayList<>();
        for (Pokemon p : pokemonArchive.values()) {
            if (p.getGeneration().equalsIgnoreCase(generation)) {
                results.add(p);
            }
        }
        return results;
    }
}

public class PokemonArchive {
    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Pokedex Menu ---");
            System.out.println("1. Search Pokemon by Name");
            System.out.println("2. Search Pokemon by Element Type");
            System.out.println("3. Search Pokemon by Generation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Pokemon name: ");
                    String name = scanner.nextLine();
                    Pokemon foundPokemon = pokedex.searchPokemon(name);
                    if (foundPokemon != null) {
                        foundPokemon.displayInfo();
                    } else {
                        System.out.println("Pokemon not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter element type (e.g., FIRE, WATER, ELECTRIC): ");
                    String elementTypeString = scanner.nextLine().toUpperCase();
                    try {
                        ElementType type = ElementType.valueOf(elementTypeString);
                        List<Pokemon> elementResults = pokedex.searchByElement(type);
                        if (!elementResults.isEmpty()) {
                            System.out.println("Pokemons with " + type + " element:");
                            for (Pokemon p : elementResults) {
                                p.displayInfo();
                                System.out.println("---");
                            }
                        } else {
                            System.out.println("No Pokemons found with that element type.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid element type.");
                    }
                    break;
                case 3:
                    System.out.print("Enter generation (e.g., Generation I, Generation II): ");
                    String generation = scanner.nextLine();
                    List<Pokemon> generationResults = pokedex.searchByGeneration(generation);
                    if (!generationResults.isEmpty()) {
                        System.out.println("Pokemons from " + generation + ":");
                        for (Pokemon p : generationResults) {
                            p.displayInfo();
                            System.out.println("---");
                        }
                    } else {
                        System.out.println("No Pokemons found for that generation.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Pokedex. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}