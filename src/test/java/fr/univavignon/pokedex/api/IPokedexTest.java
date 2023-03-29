package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    private IPokedex pokedex;

    private Pokemon pokemon0;

    private Pokemon pokemon133;

    @Mock
    protected IPokedexFactory pokedexFactory;

    @Mock
    protected IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    protected IPokemonFactory pokemonFactory;


    @Before
    public void setUp()  {
        pokedex = new Pokedex();
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);
        when(pokemon0.getIndex()).thenReturn(0);
        when(pokemon133.getIndex()).thenReturn(133);



    }

    @Test
    public void size() {
        int result = pokedex.size();
        pokedex.addPokemon(pokemon0);
        assertEquals(result + 1, pokedex.size());
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
        pokedex.getPokemon(-1);
        assertThrows(PokedexException.class, () -> {

        });
    }

    @Test
    public void testGetPokemons() {
    }
}