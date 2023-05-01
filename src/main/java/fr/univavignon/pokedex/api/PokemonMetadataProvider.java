package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    public static List<PokemonMetadata> pokemonMetadataList;
    public PokemonMetadataProvider() {
        pokemonMetadataList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 150; i++) {
            String name = "Pokemon" + (i + 1);
            int attack = random.nextInt(16);
            int defense = random.nextInt(16);
            int stamina = random.nextInt(16);
            PokemonMetadata pokemonmetadata = new PokemonMetadata(i, name, attack, defense, stamina);
            pokemonMetadataList.add(pokemonmetadata);
        }
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
