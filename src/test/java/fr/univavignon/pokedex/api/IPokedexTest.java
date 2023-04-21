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
        pokedex = Mockito.mock(IPokedex.class);
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);


        Mockito.when(pokedex.addPokemon(pokemon0))
                .then((invocation)->{
                    Pokemon pokemonToAdd = invocation.getArgument(0, Pokemon.class);
                    return pokemonToAdd.getIndex();
                });
        Mockito.doThrow(new PokedexException("Index Invalide"))
                .when(pokedex)
                .getPokemon(Mockito.intThat(i -> i != 0 && i != 133));

        Mockito.when(pokedex.addPokemon(pokemon133))
                .then((invocation)->{
                    Pokemon pokemonToAdd = invocation.getArgument(0, Pokemon.class);
                    return pokemonToAdd.getIndex();
                });

        Mockito.when(pokedex.getPokemon(0))
                .thenReturn(pokemon0);

        Mockito.when(pokedex.getPokemon(133))
                .thenReturn(pokemon133);

        // mock the size method to return the correct size of the pokedex
        Mockito.when(pokedex.size()).thenReturn(2);
        // mock the getPokemons method to return a list of all the pokemons in the pokedex
        Mockito.when(pokedex.getPokemons()) .then(invocation -> {
            List<Pokemon> result = new ArrayList<>();
            result.add(pokemon0);
            result.add(pokemon133);
            return result;});
        // mock the getPokemons method with a comparator to return a sorted list of pokemons by stamina
        comparator =(c1,c2)-> {Integer s1 = c1.getStamina();
            Integer s2 = c2.getStamina();
            return s1.compareTo(s2);};

        Mockito.when(pokedex.getPokemons(comparator)).thenAnswer(
                invocation -> {
                    List<Pokemon> result = new ArrayList<>();
                    result.add(pokemon133);
                    result.add(pokemon0);
                    return result;
                });





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

    @Test
    public void testGetPokemons() {
        List<Pokemon> result = pokedex.getPokemons(comparator);
        assertEquals(2, result.size());
        assertEquals("Aquali", result.get(0).getName());
        assertEquals("Bulbizarre", result.get(1).getName());
    }
}