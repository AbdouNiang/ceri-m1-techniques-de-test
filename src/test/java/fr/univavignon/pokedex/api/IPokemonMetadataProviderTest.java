package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {
    IPokemonMetadataProvider pokemonMetadataProvider;
    PokemonMetadata pokemonMetadataProvider1;
    PokemonMetadata pokemonMetadataProvider2;

    @Before
    public void setUp()  {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadataProvider1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        pokemonMetadataProvider2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);

    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataProvider1);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataProvider2);
        Mockito.doThrow(new PokedexException("Index Invalide")).when(pokemonMetadataProvider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        assertEquals(pokemonMetadataProvider1,pokemonMetadataProvider.getPokemonMetadata(0));
        assertEquals(pokemonMetadataProvider2, pokemonMetadataProvider.getPokemonMetadata(133));
    }
}