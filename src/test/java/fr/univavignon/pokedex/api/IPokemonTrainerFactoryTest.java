package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory pokemonTrainerFactory;

    PokedexFactory pokedexFactory;

    @Before
    public void setUp()  {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void createTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("jojo",Team.MYSTIC, pokedexFactory);
        assertNotNull(trainer);
    }
}