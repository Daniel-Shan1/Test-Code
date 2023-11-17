// Pokedex reading code
// By: Dan Shan
import java.util.ArrayList;
class Main_Class {
static String [][] pokedex = Pokedex.getPokedex();
public static String getDescription(String name) {
	for(String[] pokemon: pokedex) {
		if(pokemon[2].toLowerCase().equals(name.toLowerCase()))return pokemon[pokemon.length-1];
	}
	return "Pokemon not found.";
}
public static void getLegendaries() {
	for(String[] pokemon: pokedex) {
		if(pokemon[41].equals("1"))System.out.print(pokemon[2]+" ");
		else if(pokemon[42].equals("1"))System.out.print(pokemon[2]+" ");
		else if(pokemon[43].equals("1"))System.out.print(pokemon[2]+" ");
	}
	System.out.println();
}
public static ArrayList<String> getType(String type){
	type = type.toLowerCase();
	ArrayList<String> types = new ArrayList<String>();
	for(String[] pokemon: pokedex) {
		if(pokemon[4].equals(type))
			types.add(pokemon[2]);
	}
	return types;
}
public static boolean checkIfWeak(String p, String t) {
	String map[] = {"normal","fire","water","electric", "grass", "ice", "fighting", "poison",
			"ground", "flying", "psychic", "bug", "rock", "ghost", "dragon", "dark", "steel", 
			"fairy"};
	int index = -1;
	for(int i=0;i<18;i++) {
		if(map[i].equals(t.toLowerCase()))index = i; 
	}
	if(index < 0) return false; // type not found
	for(String[] pokemon: pokedex) {
		if(pokemon[2].toLowerCase().equals(p.toLowerCase())&&
		(pokemon[index+23].equals("2")||pokemon[index+23].equals("4"))) 
		return true;
	}
	return false;
}
  public static void main(String[] args) {
	System.out.println(getDescription("pIkAChu"));
	getLegendaries();
	ArrayList<String> t = getType("grAss");
	for(String s: t)System.out.print(s+" "); System.out.println();
	System.out.println(checkIfWeak("Bulbasaur","fire"));
  }
