package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory;
    Pokemon pokemon0;
    Pokemon pokemon133;


    @Before
    public void setUp()  {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);
        Mockito.when(pokemonFactory.createPokemon(0,613, 202, 5000, 4)) .thenReturn(pokemon0);
        Mockito.when(pokemonFactory.createPokemon(133,2729, 64, 4000, 4)) .thenReturn(pokemon133);


    }

    @Test
    public void createPokemon() {
        Pokemon pokemon00 = pokemonFactory.createPokemon(0,613,64,5000,4);
        //Assert.assertEquals(613,pokemon00.getCp());
        Pokemon pokemon0133 = pokemonFactory.createPokemon(133,2729, 64, 4000, 4);
        assertEquals(133,pokemon0133.getIndex());

    }
}