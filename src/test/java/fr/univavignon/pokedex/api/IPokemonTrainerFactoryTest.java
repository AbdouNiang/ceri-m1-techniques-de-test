package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory;

    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    PokemonTrainer pokemonTrainer;

    @Before
    public void setUp()  {
       /* pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokemonTrainer = new PokemonTrainer("jojo",Team.MYSTIC, pokedex);
        Mockito.when(pokemonTrainerFactory.createTrainer("jojo",Team.MYSTIC,pokedexFactory)) .thenReturn(pokemonTrainer);*/
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());



    }

    @Test
    public void createTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("jojo",Team.MYSTIC, pokedexFactory);
        Assert.assertEquals("jojo",trainer.getName());
        Assert.assertEquals(Team.MYSTIC, trainer.getTeam());
        Assert.assertEquals(0,trainer.getPokedex().size());
    }
}