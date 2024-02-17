import java.util.ArrayList;
import java.util.List;

class File{
    private String fileName;

    public File(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public void display(){
        System.out.println("File Name: " + fileName);
    }

}
class Folder{
    private String folderName;
    private List<File> files;
    private List <Folder> subfolders;


    public Folder (String folderName)
    {
        this.folderName = folderName;
        this.subfolders = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getFolderName(){
        return folderName;
    }
    public void setFolderName(String folderName){
        this.folderName = folderName;
    }
    public void addFile(File file){
        files.add(file);
    }

    public void addSub(Folder folder){
        subfolders.add(folder);
    }


    public void display(){
        System.out.println("Folder: " + folderName);
        for (int i = 0; i < subfolders.size(); i++)
        {
            subfolders.get(i).display();
        }
        for (int i = 0; i < files.size(); i++){
            files.get(i).display();
        }
    }


}



public class Prob_4 {
    public static void main (String[] args){
        Folder mainFolder = new Folder ("php_demo1");

        Folder subFolder1 = new Folder ("Source Files");

        Folder subFolder2 = new Folder (".phalcon");
        Folder subFolder3 = new Folder ("app");
        Folder subFolder4 = new Folder ("config");
        Folder subFolder5 = new Folder ("controllers");
        Folder subFolder6 = new Folder ("library");
        Folder subFolder7 = new Folder ("migrations");
        Folder subFolder8 = new Folder ("models");
        Folder subFolder9 = new Folder ("views");
        Folder subFolder10 = new Folder ("cache");
        Folder subFolder11= new Folder ("public");
        Folder subFolder12= new Folder ("Include Path");

        File file1 = new File (".htaccess");
        File file2 = new File (".htrouter.php");
        File file3 = new File ("index.html");

        mainFolder.addSub(subFolder1);

        subFolder1.addSub(subFolder2);
        subFolder1.addSub(subFolder3);

        subFolder3.addSub(subFolder4);
        subFolder3.addSub(subFolder5);
        subFolder3.addSub(subFolder6);
        subFolder3.addSub(subFolder7);
        subFolder3.addSub(subFolder8);
        subFolder3.addSub(subFolder9);
        subFolder3.addFile(file1);
        subFolder3.addFile(file2);
        subFolder3.addFile(file3);

        subFolder1.addSub(subFolder10);
        subFolder1.addSub(subFolder11);

        mainFolder.addSub(subFolder12);

        mainFolder.display();

    }
}
