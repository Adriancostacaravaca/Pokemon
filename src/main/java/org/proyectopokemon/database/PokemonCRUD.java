package org.proyectopokemon.database;

public class PokemonCRUD {

    /*public static List<Pokemon> readPokemon()  {
        String query = "SELECT NOM_POKEMON AS NOMBRE, TIPO1, TIPO2, IMG_URL FROM pokedex";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            preparedStatement = PokemonConnection.getConnection().prepareStatement(query);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NOMBRE");
                String tipo = resultSet.getString("TIPO1").trim();
                String tipo2 = resultSet.getString("TIPO2");

                listaPokemon.add(new Pokemon(name, Tipo.valueOf(tipo),
                        Tipo.valueOf(tipo2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPokemon;
    }
    public static void updatePokemon() {
        System.out.println(Pokedex.getPokedex());
    }

    public static boolean deletePokemon() {
        return true;
    }

     */


}

