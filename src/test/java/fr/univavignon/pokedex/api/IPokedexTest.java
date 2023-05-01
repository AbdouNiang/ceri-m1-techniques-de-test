package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    IPokedex pokedex;

    Pokemon pokemon0;

    Pokemon pokemon133;
    Comparator<Pokemon> comparator;

    @Mock
    protected IPokedexFactory pokedexFactory;

    @Mock
    protected IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    protected IPokemonFactory pokemonFactory;


    @Before
    public void setUp() throws PokedexException {
        pokedexFactory = new PokedexFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);

        pokedex.addPokemon(pokemon0);
        pokedex.addPokemon(pokemon133);





    }

    @Test
    public void size() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void addPokemon() {
        int result = pokedex.addPokemon(pokemon0);
        assertEquals(pokemon0.getIndex(), result);
        result = pokedex.addPokemon(pokemon133);
        assertEquals(pokemon133.getIndex(), result);
    }

    @Test
    public void getPokemon() throws PokedexException {
        Pokemon result = pokedex.getPokemon(133);
        assertEquals(pokemon133, result);
    }


    @Test
    public void getPokemons() throws PokedexException {
        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(2, result.size());
        assertEquals("Bulbizarre", result.get(0).getName());
        assertEquals("Aquali", result.get(1).getName());
    }

    /*@Test
    public void testGetPokemons() {
        List<Pokemon> result = pokedex.getPokemons();
        assertEquals(2, result.size());
        //assertEquals("Aquali", result.get(0).getName());
        assertEquals("Bulbizarre", result.get(1).getName());
    }*/
}