package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    public static List<PokemonMetadata> pokemonMetadataList;
    public PokemonMetadataProvider() {
        pokemonMetadataList = new ArrayList<>();
        PokemonMetadata pokemonMetadata1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata pokemonMetadata2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonMetadataList.add(pokemonMetadata1);
        pokemonMetadataList.add(pokemonMetadata2);
    }


    @Override
    public  PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= 149) {
            throw new PokedexException("Invalid ID");
        } else {
            for (PokemonMetadata pokemonMetadata : pokemonMetadataList) {
                if (pokemonMetadata.getIndex() == index) {
                    return pokemonMetadata;
                }
            }
        }
        throw new PokedexException("pokemon's index does not exist");
    }

}
