package model;

public class GoogleDocFile extends GoogleDriveFile {
    @Override
    public void launch() {
        //launch
        System.out.println("Opening google Docs file "+ this.getName());
    }
}
