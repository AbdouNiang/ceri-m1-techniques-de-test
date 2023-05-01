package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider pokemonMetadata = new PokemonMetadataProvider();
        String name;
        int attack;
        int defense;
        int stamina;
        int iv;
        try {
            PokemonMetadata metadata = pokemonMetadata.getPokemonMetadata(index);
            name = metadata.getName();
            attack = metadata.getAttack();
            defense = metadata.getDefense();
            stamina = metadata.getStamina();
            iv = (int) ((double) (attack + defense + stamina)*100 / (3*15));
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
        return new Pokemon(index,name,attack,defense,stamina,cp,hp,dust,candy,iv);
    }
}
