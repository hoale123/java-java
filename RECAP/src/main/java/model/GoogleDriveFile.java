package model;

import java.util.List;

public abstract class GoogleDriveFile {
    private String name;
    private String owner;
    private String pathLocation;
    private List<String> usersWithAccess;

    public void rename(String name){
        this.name = name;
    }

    public void share(String user){
        usersWithAccess.add(user);
    }
    public abstract void launch();

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPathLocation() {
        return pathLocation;
    }

    public void setPathLocation(String pathLocation) {
        this.pathLocation = pathLocation;
    }

    public List<String> getUsersWithAccess() {
        return usersWithAccess;
    }

    public void setUsersWithAccess(List<String> usersWithAccess) {
        this.usersWithAccess = usersWithAccess;
    }

    protected String getName() {
        return null;
    }
}

