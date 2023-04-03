package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp()  {
        IPokedex pokedex = new Pokedex();
        pokedex.addPokemon(new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56));
        pokemonMetadataProvider = pokedex;
    }

    @Test
    public void getPokemonMetadata() {
        assertThrows(PokedexException.class,() -> {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(0);
        });
    }
}