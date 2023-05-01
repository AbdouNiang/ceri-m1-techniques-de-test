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
        //pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonMetadataProvider1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        pokemonMetadataProvider2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);

    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        /*Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataProvider1);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataProvider2);
        Mockito.doThrow(new PokedexException("Index Invalide")).when(pokemonMetadataProvider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        assertEquals(pokemonMetadataProvider1,pokemonMetadataProvider.getPokemonMetadata(0));
        assertEquals(pokemonMetadataProvider2, pokemonMetadataProvider.getPokemonMetadata(133));*/
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getIndex(),pokemonMetadataProvider1.getIndex());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getName(),pokemonMetadataProvider1.getName());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getAttack(),pokemonMetadataProvider1.getAttack());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getDefense(),pokemonMetadataProvider1.getDefense());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getStamina(),pokemonMetadataProvider1.getStamina());
    }

    @Test
    public void getPokemonMetadata2() throws PokedexException {
        /*Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataProvider1);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataProvider2);
        Mockito.doThrow(new PokedexException("Index Invalide")).when(pokemonMetadataProvider).getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));

        assertEquals(pokemonMetadataProvider1,pokemonMetadataProvider.getPokemonMetadata(0));
        assertEquals(pokemonMetadataProvider2, pokemonMetadataProvider.getPokemonMetadata(133));*/

    }
}