package pt.tecnico.myDrive.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import pt.ist.fenixframework.DomainRoot;
import pt.ist.fenixframework.FenixFramework;
import pt.tecnico.myDrive.exception.ImportDocumentException;
import pt.tecnico.myDrive.exception.MyDriveException;
import pt.tecnico.myDrive.exception.NoPermissionException;
import pt.tecnico.myDrive.exception.UserAlreadyExistsException;

import java.util.Set;

public class MyDrive extends MyDrive_Base {
    static final Logger log = LogManager.getRootLogger();

    private MyDrive() {
        setRoot(FenixFramework.getDomainRoot());
        FenixFramework.getDomainRoot().setMyDrive(this);
        if (getIdCounter() == null)
            setIdCounter(0);
    }

    public static MyDrive getInstance() {
        MyDrive md = FenixFramework.getDomainRoot().getMyDrive();

        if (md != null)
            return md;

        return new MyDrive();
    }

    public User getUserByUsername(String username) {
        for (User user : getUserSet()) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        // TODO: Make necessary checks
        super.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        // TODO: User deletes itself
        super.removeUser(user);
    }

    @Override
    public Set<User> getUserSet() {
        // TODO: Check if access should be allowed
        return super.getUserSet();
    }

    @Override
    public Integer getIdCounter() {
        // TODO: Check if access should be allowed
        return super.getIdCounter();
    }

    @Override
    public void setIdCounter(Integer idCounter) {
        // TODO: Check if access should be allowed
        super.setIdCounter(idCounter);
    }

    public int getNewId() {
        int id = super.getIdCounter();
        id++;
        super.setIdCounter(id);
        return id;
    }

    @Override
    public void setRoot(DomainRoot root) throws MyDriveException {
        //throw new NoPermissionException("setRoot");
    }

    public void xmlImport(Element element) throws ImportDocumentException {

        for (Element node: element.getChildren("user")) {
            String username = node.getAttribute("username").getValue();

            if(username == null)
                throw new ImportDocumentException("User", "attribute username cannot be read properly");

            User user = getUserByUsername(username);
            if(user != null)
                 throw new UserAlreadyExistsException(username);

            new User(this,username,node);
        }

        for (Element node: element.getChildren("dir")) {
            (new Dir()).xmlImport(node);
        }

        for (Element node: element.getChildren("plain")) {
            new PlainFile(node);
        }

        for (Element node: element.getChildren("link")) {
            new Link(node);
        }

        for (Element node: element.getChildren("app")) {
            new App(node);
        }

    }


    public Document xmlExport() {
        Element myDriveElement = new Element("myDrive");
        Document doc = new Document(myDriveElement);

        for (User u: getUserSet()) {
            myDriveElement.addContent(u.xmlExport());
        }

        for (User u: getUserSet()) {
            for(File file : u.getFileSet()){
                myDriveElement.addContent(file.xmlExport());
            }
        }

        return doc;
    }
}
