package howard.edu.lsp.finals.problem;

import java.util.Set;

public class Driver {

	public static void main(String[] args) {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Jazz", "Always There");
		Set<String> songs = db.getSongs("Rap");
		System.out.println( db.getGenreOfSong("Savage"));
		System.out.println( db.getGenreOfSong("Always There"));
	}

}
