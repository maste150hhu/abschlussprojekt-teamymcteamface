package mops.foren.domain.model;

import javax.validation.constraints.Email;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    private Email email;
    private HashMap<Id, Permission> permissions;
    private List<ForumId> forums;

    private Image image;

    public boolean checkPermission(Id id, Permission neededPermission) {
        return this.permissions.get(id) == neededPermission;
    }

    public List<ForumId> getUserForums() {
        return this.forums;
    }
}

