package ParoleStandard;

import Assets.DBmock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StandardFromFile implements ParoleStandard {
    List<Standard> paroleStandard = new ArrayList<>();

    public StandardFromFile()  {
        readFile();
    }

    private void readFile() {
        try{
            File file = new File("src/Assets/Nazioni2.txt");
            Scanner scanner = new Scanner(file);
            int id = 1;
            while (scanner.hasNextLine()){
                String parola = scanner.nextLine();
                String codice = parola.substring(0, parola.indexOf(',')-1).trim();
                String nome = parola.substring(parola.indexOf(',')+1, parola.length()).trim();
                Standard standard = new Standard(id,codice, nome, 0);
             //   System.out.println("NOME PAESE : " + nome + " CODICE PAESE " + standard.getId() );
                paroleStandard.add(standard);
                DBmock.getIstanza().getStandardTable().put(standard.getId(),standard);
                id = id + 1;
            }
            scanner.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


	@Override
	public List<Standard> getStandards() {
		
	    return paroleStandard;
	}
}
