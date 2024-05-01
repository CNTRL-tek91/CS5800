import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CharacterProperties{
    private String font;
    private String color;
    private int size;

    //Default Constructor
    public CharacterProperties(String font, String color, int size)
    {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    //Getter functions
    public String getFont() {
        return font;
    }
    public String getColor(){
        return color;
    }
    public int getSize(){
        return size;
    }
}

class Character{
    private char ch;
    private CharacterProperties properties;

    //Default Constructor
    public Character(char ch, CharacterProperties properties){
        this.ch = ch;
        this.properties = properties;
    }

    //Getter functions
    public char getChar(){
        return ch;
    }
    public CharacterProperties getProperties(){
        return properties;
    }
}


class Document{
    public List<Character> characterList;

    //Default Constructor
    public Document(){
        characterList = new ArrayList<>();
    }

    //addCharacter function that adds a new Character(ch, properties) into the list characterList
    public void addCharacterToList(char ch, CharacterProperties properties){
        characterList.add(new Character(ch, properties));
    }

    public void save(String filename){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for(Character character : characterList){
                writer.write(character.getChar() + "," +
                        character.getProperties().getFont() + "," +
                        character.getProperties().getColor() + "," +
                        character.getProperties().getSize());
                writer.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Document load(String filename){
        Document document = new Document();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) !=  null){
                String[] parts = line.split(",");
                char ch = parts[0].charAt(0);
                String font = parts[1];
                String color = parts[2];
                int size = Integer.parseInt(parts[3]);
                CharacterProperties properties = new CharacterProperties(font, color, size);
                document.addCharacterToList(ch, properties);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return document;
    }
}


public class Main {
    public static void main(String[] args) {
        Document document = new Document();

        document.addCharacterToList('H', new CharacterProperties("Arial", "Red", 12));
        document.addCharacterToList('e', new CharacterProperties("Arial", "Red", 12));
        document.addCharacterToList('l', new CharacterProperties("Calibri", "Blue", 14));
        document.addCharacterToList('l', new CharacterProperties("Calibri", "Blue", 14));
        document.addCharacterToList('o', new CharacterProperties("Verdana", "Black", 16));
        document.addCharacterToList('W', new CharacterProperties("Arial", "Red", 12));
        document.addCharacterToList('o', new CharacterProperties("Arial", "Red", 12));
        document.addCharacterToList('r', new CharacterProperties("Calibri", "Blue", 14));
        document.addCharacterToList('l', new CharacterProperties("Calibri", "Blue", 14));
        document.addCharacterToList('d', new CharacterProperties("Verdana", "Black", 16));
        document.addCharacterToList('C', new CharacterProperties("Arial", "Red", 12));
        document.addCharacterToList('S', new CharacterProperties("Arial", "Red", 12));
        document.addCharacterToList('5', new CharacterProperties("Calibri", "Blue", 14));
        document.addCharacterToList('8', new CharacterProperties("Calibri", "Blue", 14));
        document.addCharacterToList('0', new CharacterProperties("Verdana", "Black", 16));
        document.addCharacterToList('0', new CharacterProperties("Verdana", "Black", 16));

        document.save("document.txt");

        Document loadDocument = Document.load("document.txt");
        for(Character character : loadDocument.characterList){
            System.out.println(character.getChar() + " " + character.getProperties().getFont() +  " " +
                    character.getProperties().getColor() + " " + character.getProperties().getSize());

        }

    }
}
