// Pokedex reading code
// By: Dan Shan
import java.util.ArrayList;
class Main_Class {
	static String map[] = {"normal","fire","water","electric", "grass", "ice", "fighting", "poison",
	"ground", "flying", "psychic", "bug", "rock", "ghost", "dragon", "dark", "steel", 
	"fairy"}; // types in order they occur in pokedex
static String [][] pokedex = Pokedex.getPokedex();
/**
 * takes in a Pokémon's English name not case sensitive
 * returns their description or "Pokemon not found" if pokemon name is not found
 */
public static String getDescription(String name) {
	for(String[] pokemon: pokedex) {
		if(pokemon[2].toLowerCase().equals(name.toLowerCase()))return pokemon[pokemon.length-1];
	}
	return "Pokemon not found.";
}
/**
 * no parameters
 * prints out all the legendary/sublegendary/mythical Pokémon on a separate line from the Pokédex
 * does not return anything
 */
public static void getLegendaries() {
	for(String[] pokemon: pokedex) {
		if(pokemon[41].equals("1"))System.out.print(pokemon[2]+" ");
		else if(pokemon[42].equals("1"))System.out.print(pokemon[2]+" ");
		else if(pokemon[43].equals("1"))System.out.print(pokemon[2]+" ");
	}
	System.out.println();
}
/**
 * takes in a String: primary pokemon type not case sensitive
 * returns an ArrayList of the English name of all the Pokémon that have that primary type
 */
public static ArrayList<String> getType(String type){
	type = type.toLowerCase();
	ArrayList<String> types = new ArrayList<String>();
	for(String[] pokemon: pokedex) {
		if(pokemon[4].equals(type))
			types.add(pokemon[2]);
	}
	return types;
}
/**
 * takes in 2 strings: Pokémon name and type not case sensitive
 * returns true if it is weak to that type and false otherwise
 */
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
/**
 *  no parameters
 *  returns an array of 151 strings 0 indexed for each Pokémon 
 *  each containing the name of the Pokémon followed by all the types 
 *  it has a strong defense against and types its immune against
 */
public static String[] getAllStrengths() {
	String arr[] = new String[151]; 
	for(int i=1;i<152;i++){
		String res = pokedex[i][2]+": "; // name 
		boolean c=false; // whether or not to put comma
		for(int j=23;j<41;j++) {
			if(pokedex[i][j].equals("0")) {
				if(c) res += ",";
				else c = true;
				res += map[j-23]+"(immune)";
			}
			if(pokedex[i][j].equals("0.5")||pokedex[i][j].equals("0.25")) {
				if(c) res += ",";
				else c = true;
				res += map[j-23];
			}
		}
		arr[i-1]= res; // insert into array
	}
	return arr;
}
  public static void main(String[] args) {
	// call to get description for pikachu and print it
	System.out.println(getDescription("pIkAChu"));
	// call to print all legendaries
	getLegendaries();
	// call to find all grass pokemon
	ArrayList<String> t = getType("grAss");
	// prints all grass pokemon returned
	for(String s: t)System.out.print(s+" "); System.out.println();
	// call to  check if bulbasaur is weak to fire and print result
	System.out.println(checkIfWeak("Bulbasaur","fire"));
	// call to return all strengths of every pokemon in a 151 by 18 array
	String[] strengths = getAllStrengths();
	// print out Haunter #93's weaknesses
	System.out.println(strengths[92]);
  }
}
