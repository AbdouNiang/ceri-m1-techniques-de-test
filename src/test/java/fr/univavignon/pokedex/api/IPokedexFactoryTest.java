package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class IPokedexFactoryTest {
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    Pokemon pokemon0;
    Pokemon pokemon133;
    IPokedex pokedex;
    Comparator<Pokemon> comparatorStamina;

    @Before
        public void setUp() throws PokedexException {
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);
        };





    @Test
    public void createPokedex() throws PokedexException {
        int pokedexSize = pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory).size();
        //assertNull(pokedexSize);
        assertEquals(pokedexSize,0);


    }
}