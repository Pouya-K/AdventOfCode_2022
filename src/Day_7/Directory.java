package src.Day_7;

import java.util.ArrayList;
public class Directory extends RandomFile {
    private ArrayList<RandomFile> files;
    private Directory parentDirectory;
    public Directory(String name, Directory parentDirectory){
        super(name);
        files = new ArrayList<RandomFile>();
        this.parentDirectory = parentDirectory;
    }

    public void addFile(RandomFile file){
        files.add(file);
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public ArrayList<RandomFile> getFiles() {
        return files;
    }

    public int getSize(){
        int sum = 0;
        for(int i = 0; i< files.size(); i++){
            sum += files.get(i).getSize();
        }
        return sum;
    }

    public Directory findFile(String name){
        for(int i = 0; i<files.size(); i++){
            if(files.get(i).getName().equals(name) && files.get(i) instanceof Directory){
                return (Directory) files.get(i);
            }
        }
        return null;
    }
}
