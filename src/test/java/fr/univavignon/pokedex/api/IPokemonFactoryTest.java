package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory;


    @Before
    public void setUp()  {
        pokemonFactory = new Pokedex();

    }

    @Test
    public void createPokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertNotNull(pokemon);
        assertEquals(pokemon.getIndex(), 0);

    }
}