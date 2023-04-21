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
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        comparatorStamina = (c1, c2) -> {
            Integer s1 = c1.getStamina();
            Integer s2 = c2.getStamina();
            return s1.compareTo(s2);
        };
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);

        Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory)) .thenReturn(pokedex);

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
        Mockito.when(pokedex.getPokemons()) .then(invocation -> {List<Pokemon> result = new ArrayList<>();
            result.add(pokemon0);
            result.add(pokemon133);
             return result;});
        // mock the getPokemons method with a comparator to return a sorted list of pokemons by stamina
        comparatorStamina =(c1,c2)-> {Integer s1 = c1.getStamina();
        Integer s2 = c2.getStamina();
        return s1.compareTo(s2);};

        Mockito.when(pokedex.getPokemons(comparatorStamina)).thenAnswer(
                invocation -> {
                    List<Pokemon> result = new ArrayList<>();
                    result.add(pokemon133);
                    result.add(pokemon0);
                    return result;
                });

    }

    @Test
    public void createPokedex() throws PokedexException {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory);
        Assert.assertEquals(2, pokedex.size());
        Pokemon pokemon00 = pokedex.getPokemon(0);
        Assert.assertEquals(pokemon00, pokemon0);
        Pokemon pokemon0133 = pokedex.getPokemon(133);
        Assert.assertEquals(pokemon0133, pokemon133);

        assertThrows(PokedexException.class, ()->{pokedex.getPokemon(100);});

        List<Pokemon> pokemons = pokedex.getPokemons();
        Assert.assertEquals(2, pokemons.size());
        Assert.assertEquals("Bulbizarre", pokemons.get(0).getName());
        Assert.assertEquals("Aquali", pokemons.get(1).getName());

        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparatorStamina);
        Assert.assertEquals(2, sortedPokemons.size());
        Assert.assertEquals("Aquali", sortedPokemons.get(0).getName());
        Assert.assertEquals("Bulbizarre", sortedPokemons.get(1).getName());
    }
}