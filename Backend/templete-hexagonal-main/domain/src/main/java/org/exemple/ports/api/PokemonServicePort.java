package org.exemple.ports.api;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
public interface PokemonServicePort <K, V>{
    Map<String,Object> servicePokemon() throws IOException;
    Map<K,V> servicePokemon(String name) throws IOException;
}
