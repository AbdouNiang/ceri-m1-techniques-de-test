package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createPokedex() {
        IPokedex addPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider,pokemonFactory);
        assertNotNull(addPokedex);
    }
}