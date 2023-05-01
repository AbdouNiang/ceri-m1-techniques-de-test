package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {

        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }
    private List<Pokemon> pokemons = new ArrayList<>();
    public int size() {
        return pokemons.size();
    }

    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id > 150){
            throw new PokedexException("Invalid index");
        }else{
            for (Pokemon pokemon:pokemons) {
                if (pokemon.getIndex() == id){
                    return pokemon;
                }
            }
        }

        return null;
    }

    public List<Pokemon> getPokemons() {
        return  pokemons;
    }

    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sorted = new ArrayList<>(pokemons);
        sorted.sort(order);
        return sorted;
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
